package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerT01 {

	@ResponseBody
	@GetMapping("/home.htm") 
	public String Hello(){
		System.out.println("check from console");
		return "Hello! The Controller works so far.";
	}
}
