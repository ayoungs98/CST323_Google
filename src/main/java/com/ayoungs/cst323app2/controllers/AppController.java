package com.ayoungs.cst323app2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
		
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
