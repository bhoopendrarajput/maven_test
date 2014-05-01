package com.rajput.maven_test.service;
import java.util.List;

import com.rajput.maven_test.dto.LoginDTO;

public interface LoginService {
	void addLoginDTO(LoginDTO loginDTO);

	List<LoginDTO> listLoginDTO() ;

	void removeLoginDTO(Integer id);

	LoginDTO findLoginDTO(String userName);
}
