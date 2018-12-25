package com.pxl.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pxl.daos.RedisDao;
import com.pxl.pojos.People;
import com.pxl.services.PeopleService;
import com.pxl.utils.HttpUtil;
import com.pxl.utils.StringUtil;

@Controller
@RequestMapping("/people")
public class PeopleController {
	private static Logger log=LoggerFactory.getLogger(PeopleController.class);
	@Autowired
	private PeopleService peopleService;
	@Autowired
	private RedisDao redisDao;
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(HttpServletRequest request,HttpServletResponse response,People people) throws Exception{
//		System.out.println(IOUtils.toString(request.getInputStream()));
//		System.out.println(request.getParameter("id"));
//		redisDao.set("a", "111");
//		System.out.println(redisDao.get("a"));
//		System.out.println(peopleService.selectPeople(people));
//		log.debug("222222222222");
//		log.debug(peopleService.selectPeople(people).toString());
//		System.out.println(peopleService.insertPeople(people));
		System.out.println(request.getParameterNames());
		Map<String, String[]> map = request.getParameterMap();  
        for(Map.Entry<String,String[]> entry:map.entrySet()) {
        	for(String str:entry.getValue()) {
        		if(StringUtils.hasText(str)) {
        			System.out.println("Key = " + entry.getKey() + ", Value = " + str);
        			break;
        		}
        	}
        }
		return HttpUtil.getIpAddr(request);
	}
	@RequestMapping("/insertMany")
	public void insertMany(){
		for(int i=0;i<=1000000;i++) {
			People people =new People(StringUtil.randomString(10),String.valueOf(Math.round(Math.random()*1000000000*100000000)));
			System.out.println(peopleService.insertPeople(people));
		}
	}
}
