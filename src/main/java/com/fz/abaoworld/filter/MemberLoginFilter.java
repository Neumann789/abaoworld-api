package com.fz.abaoworld.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.common.RspCodeEnum;
import com.fz.abaoworld.common.SessionUtils;

public class MemberLoginFilter implements Filter {
	private final static Logger logger = LoggerFactory.getLogger(MemberLoginFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		SessionUtils.setSession(session);
		Object sessionObj = session.getAttribute("usrInfo");
		String servletPath = request.getServletPath();

		if (servletPath.contains("register") || servletPath.contains("login")) {
			chain.doFilter(req, resp);
		} else {
			// 无session信息
			if (sessionObj == null) {
				BaseRsp res = new BaseRsp(RspCodeEnum.B_SESSION_IS_INVALID);
				resp.getOutputStream().print(JSON.toJSONString(res));//TODO 前端获取数据有问题 需要优化
			} else {
				chain.doFilter(req, resp);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
