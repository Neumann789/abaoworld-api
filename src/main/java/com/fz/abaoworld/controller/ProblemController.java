package com.fz.abaoworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.common.SessionUtils;
import com.fz.abaoworld.dal.entity.ProblemEntity;
import com.fz.abaoworld.dal.entity.TagEntity;
import com.fz.abaoworld.service.ProblemService;
import com.fz.abaoworld.service.dto.req.ProblemDTO;
import com.fz.abaoworld.service.dto.req.QueryProListDTO;
import com.fz.abaoworld.service.dto.rsp.PageRsp;
import com.fz.abaoworld.utils.DateUtils;

@Controller
@RequestMapping("/abaoworld")
@SuppressWarnings("all")
public class ProblemController extends BaseContoller{
	
	@Autowired
	private ProblemService problemService;
	
/*	@RequestMapping(value="/problem/addPro")
	@ResponseBody
	public BaseRsp addPro(@RequestBody ProblemDTO dto){
		return problemService.addPro(dto);
	}*/
	
	/**
	 * 
	 * addPro:TODO 为什么上面的那种方式不行. <br/>
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/problem/addPro")
	@ResponseBody
	public BaseRsp addPro(HttpServletRequest request,HttpServletResponse response){
		String proTitle = request.getParameter("proTitle");
		String proContent = request.getParameter("proContent");
		String tagIds = request.getParameter("tagIds");
		ProblemDTO dto = new ProblemDTO();
		dto.setMemberId(SessionUtils.getUsrInfo().getUsrId());
		dto.setProDegree("A");
		dto.setProType("tech");
		dto.setProTitle(proTitle);
		dto.setProContent(proContent);
		dto.setTagIds(tagIds);
		return problemService.addPro(dto);
	}
	
	@RequestMapping(value="/problem/queryProList")
	@ResponseBody
	public BaseRsp queryProList(HttpServletRequest request){
		QueryProListDTO dto = new QueryProListDTO();
		/*
		 *                     "pageSize":pageSize,
                    "pageNo":pageNo,
                    "startTime":startTime,
                    "endTime":endTime
		 * */
		int pageSize = StringUtils.isEmpty(request.getParameter("pageSize"))?10:Integer.parseInt(request.getParameter("pageSize"));
		int pageNo = StringUtils.isEmpty(request.getParameter("pageNo"))?1:Integer.parseInt(request.getParameter("pageNo"));
		String startTime = request.getParameter("startTime");
		if(StringUtils.isEmpty(startTime)){
			startTime="1949-01-01";
		}
		String endTime = request.getParameter("endTime");
		if(StringUtils.isEmpty(endTime)){
			endTime="4949-01-01";
		}
		String proTitle = request.getParameter("proTitle");
		dto.setPageSize(pageSize);
		dto.setPageNo(pageNo);
		dto.setStartTime(DateUtils.dateFormat(startTime, DateUtils.DEFAULT_DATE_FORMAT, DateUtils.DATE_FORMAT_YYMMDD));
		dto.setEndTime(DateUtils.dateFormat(endTime, DateUtils.DEFAULT_DATE_FORMAT, DateUtils.DATE_FORMAT_YYMMDD));
		dto.setProTitle(proTitle);
		return problemService.queryProList(dto);
	}
	
	
	
	@RequestMapping(value="/problem/queryProById")
	@ResponseBody
	public BaseRsp<ProblemEntity> queryProById(HttpServletRequest request){
		String proIdStr = request.getParameter("proId");
		if(StringUtils.isEmpty(proIdStr)){
			return BaseRsp.returnFail();
		}
		Long proId = Long.parseLong(proIdStr);
		
		return problemService.queryProById(proId);
	}
	
	@RequestMapping(value="/problem/queryAllTags")
	@ResponseBody
	public BaseRsp<PageRsp<TagEntity>> queryAllTags(HttpServletRequest request){
		return problemService.queryAllTags();
	}
	
	@RequestMapping(value="/problem/modifyPro")
	@ResponseBody
	public BaseRsp modifyPro(HttpServletRequest request){
		String proTitle = request.getParameter("proTitle");
		String proContent = request.getParameter("proContent");
		String tagIds = request.getParameter("tagIds");
		String proId = request.getParameter("proId");
		ProblemDTO dto = new ProblemDTO();
		dto.setMemberId(SessionUtils.getUsrInfo().getUsrId());
		dto.setProTitle(proTitle);
		dto.setProContent(proContent);
		dto.setTagIds(tagIds);
		dto.setProId(proId);
		return problemService.modifyPro(dto);
	}


}
