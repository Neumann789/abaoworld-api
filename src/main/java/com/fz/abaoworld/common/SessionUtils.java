package com.fz.abaoworld.common;

import javax.servlet.http.HttpSession;

import com.fz.abaoworld.service.dto.req.UsrDTO;

@SuppressWarnings("all")
public class SessionUtils {
	
	public static final String USRINFO = "usrInfo";
	
	private static ThreadLocal<HttpSession> threadLocal = new ThreadLocal<>();
	
	public static void setSession(HttpSession session){
		threadLocal.set(session);
	}
	
	public static HttpSession getSession(){
		return threadLocal.get();
	}
	
	public  static <T>  T getAttr(String key){
		return (T)threadLocal.get().getAttribute(key);
	}
	
	public static UsrDTO getUsrInfo(){
		return getAttr(USRINFO);
	}
}
