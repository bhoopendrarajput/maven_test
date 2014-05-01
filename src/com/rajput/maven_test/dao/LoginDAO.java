package com.rajput.maven_test.dao;

import java.util.List;

import com.rajput.maven_test.dto.LoginDTO;

public interface LoginDAO {
	void addLoginDTO(LoginDTO loginDTO);

	List<LoginDTO> listLoginDTO();

	void removeLoginDTO(Integer id);
	
	LoginDTO findLoginDTO(String userName);
}
