package com.boot.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ajaxCtrl")
public class AjaxController {

	@RequestMapping("list")
	@ResponseBody
	public String list(String name,String pwd,String fff) {
		System.out.println("===="+name+"=="+fff+"==="+pwd);
		return "";
	}
}
