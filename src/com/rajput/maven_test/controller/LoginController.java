package com.rajput.maven_test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rajput.maven_test.dto.LoginDTO;
import com.rajput.maven_test.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping("/index")
	public String listLoginDTOs(Map<String, Object> map) {
 
		map.put("loginDTO", new LoginDTO());
		map.put("loginDTOList", loginService.listLoginDTO());

		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addLoginDTO(@ModelAttribute("loginDTO") LoginDTO loginDTO,
			BindingResult result) {

		loginService.addLoginDTO(loginDTO);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{loginDTOId}")
	public String deleteLoginDTO(@PathVariable("loginDTOId") Integer loginDTOId) {

		loginService.removeLoginDTO(loginDTOId);

		return "redirect:/index";
	}
}
