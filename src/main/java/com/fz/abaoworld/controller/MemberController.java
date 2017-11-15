package com.fz.abaoworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.common.RspCodeEnum;
import com.fz.abaoworld.service.MemberService;
import com.fz.abaoworld.service.dto.req.UsrDTO;

/**
 * 天成
 * 好学
 * 力学
 * @author HP
 *
 */
@RestController
@RequestMapping("/abaoworld")
@SuppressWarnings("all")
public class MemberController {
	@Autowired
	private MemberService memberService;
     //注冊
	@RequestMapping("/member/register")
	public BaseRsp register(UsrDTO vo) {
		return memberService.registerMember(vo);
	}
    //登陸
	@RequestMapping("/member/login")
	public BaseRsp login(HttpServletRequest req, HttpServletResponse rep, UsrDTO vo) {
		BaseRsp res = new BaseRsp();
		res = memberService.findMember(vo);
		if (!"S9999".equals(res.getRspCode())) {
			HttpSession hs = req.getSession(true);
			vo.setUsrPwd("");
			hs.setAttribute("usrInfo", vo);
			res.setBody(vo);
		}
		return res;
	}

	// 查詢
	@RequestMapping("/member/queryInfo")
	public BaseRsp queryInfo(HttpServletRequest req, HttpServletResponse rep) {
		BaseRsp res = new BaseRsp(RspCodeEnum.SUCCESS);
		Object sessionObj = req.getSession().getAttribute("usrInfo");
		res.setBody(sessionObj);
		return res;
	}

	// 登出
	@RequestMapping("/member/loginout")
	public BaseRsp loginout(HttpServletRequest req, HttpServletResponse rep) {
		BaseRsp res = new BaseRsp(RspCodeEnum.SUCCESS);
		req.getSession().removeAttribute("usrInfo");
		return res;
	}
	//更新
	@RequestMapping("/member/update")
	public BaseRsp update(HttpServletRequest req, HttpServletResponse rep, UsrDTO vo) {
		BaseRsp res = new BaseRsp(RspCodeEnum.SUCCESS);
		res = memberService.updateMember(vo);
		return res;
	}

}
