package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	@Value("${app.version}")
	private String appVersion;
	
	
	@GetMapping
	@RequestMapping(value="/")
    public Map<Object,Object> getAppVersion() {
		
		 Properties properties = new Properties();
		 properties.setProperty("app.version", appVersion);
		 Map<Object, Object> map = new HashMap<Object,Object>(properties);
		 return map;
      }
}
