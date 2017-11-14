package com.fz.abaoworld.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.service.dto.req.ProblemDTO;

@Controller
@RequestMapping("/abaoworld")
@SuppressWarnings("all")
public class UploadContoller extends BaseContoller{
	
	@Value("${upload.path}")
	private String uploadPath;
	
	@Value("${upload.url}")
	private String uploadUrl;
	
	@RequestMapping(value="/problem/upload")
	public void upload(HttpServletRequest request,HttpServletResponse response){
		logger.info("上传图片");
		try {
			response.setContentType("textml;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        Part part = request.getPart("myFileName");// myFileName是文件域的name属性值
	        // 文件类型限制
	        String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
	        boolean allowed = Arrays.asList(allowedType).contains(part.getContentType());
	        if (!allowed) {
	            response.getWriter().write("error|不支持的类型");
	            return;
	        }
	        // 图片大小限制
	        if (part.getSize() > 5 * 1024 * 1024) {
	            response.getWriter().write("error|图片大小不能超过5M");
	            return;
	        }
	        // 包含原始文件名的字符串
	        String fi = part.getHeader("content-disposition");
	        // 提取文件拓展名
	        String fileNameExtension = fi.substring(fi.lastIndexOf("."), fi.length() - 1);
	        // 生成实际存储的真实文件名
	        String realName = UUID.randomUUID().toString() + fileNameExtension;
	        // 图片存放的真实路径
	        String realPath = uploadPath +"/"+ realName;
	        // 将文件写入指定路径下
	        part.write(realPath);
	        Map result = new HashMap();
	        result.put("url", uploadUrl + "/" + realName);
	        // 返回图片的URL地址
	        response.getWriter().write(JSON.toJSONString(result));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@RequestMapping(value="/problem/uploadFile")
	public void uploadFile(HttpServletRequest request,HttpServletResponse response){
		logger.info("上传图片");
		try {
			response.setContentType("textml;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        Part part = request.getPart("myFileName");// myFileName是文件域的name属性值
	        // 文件类型限制
	        String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
	        boolean allowed = Arrays.asList(allowedType).contains(part.getContentType());
	        if (!allowed) {
	            response.getWriter().write("error|不支持的类型");
	            return;
	        }
	        // 图片大小限制
	        if (part.getSize() > 5 * 1024 * 1024) {
	            response.getWriter().write("error|图片大小不能超过5M");
	            return;
	        }
	        // 包含原始文件名的字符串
	        String fi = part.getHeader("content-disposition");
	        // 提取文件拓展名
	        String fileNameExtension = fi.substring(fi.lastIndexOf("."), fi.length() - 1);
	        // 生成实际存储的真实文件名
	        String realName = UUID.randomUUID().toString() + fileNameExtension;
	        // 图片存放的真实路径
	        String realPath = uploadPath +"/"+ realName;
	        // 将文件写入指定路径下
	        part.write(realPath);
	        Map result = new HashMap();
	        result.put("url", uploadUrl + "/" + realName);
	        // 返回图片的URL地址
	        response.getWriter().write(JSON.toJSONString(result));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
