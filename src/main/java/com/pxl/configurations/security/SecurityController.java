package com.pxl.configurations.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/login")
public class SecurityController {
	private RequestCache requestCache=new HttpSessionRequestCache();
	@RequestMapping("/html")
	@ResponseStatus(code=HttpStatus.UNAUTHORIZED)
	public String login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		SavedRequest save=requestCache.getRequest(request, response);
		if(save!=null) {
			String url=save.getRedirectUrl();
			System.out.println(url);
		}
		//return "redirect:"+url;
		return "sign";
	}
	
}
