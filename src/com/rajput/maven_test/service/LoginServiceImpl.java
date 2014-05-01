package com.rajput.maven_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajput.maven_test.dao.LoginDAO;
import com.rajput.maven_test.dto.LoginDTO;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
    private LoginDAO loginDAO;
	
	@Transactional
	public void addLoginDTO(LoginDTO loginDTO) {
		loginDAO.addLoginDTO(loginDTO);
	}

	public List<LoginDTO> listLoginDTO() {
		return loginDAO.listLoginDTO();
	}
	
	@Transactional
	public void removeLoginDTO(Integer id) {
		loginDAO.removeLoginDTO(id);		
	}

	public LoginDTO findLoginDTO(String userName) {
		return loginDAO.findLoginDTO(userName);
	}

}
