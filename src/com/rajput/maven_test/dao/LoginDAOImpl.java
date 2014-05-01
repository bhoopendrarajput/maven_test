package com.rajput.maven_test.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rajput.maven_test.dto.LoginDTO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void addLoginDTO(LoginDTO loginDTO) {
		sessionFactory.getCurrentSession().save(loginDTO);
	}

	@SuppressWarnings("unchecked")
	public List<LoginDTO> listLoginDTO() {
		return sessionFactory.openSession().createQuery("from LoginDTO")
				.list();
	}

	public void removeLoginDTO(Integer id) {
		LoginDTO contact = (LoginDTO) sessionFactory.getCurrentSession().load(
				LoginDTO.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}
	}

	@SuppressWarnings("unchecked")
	public LoginDTO findLoginDTO(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from LoginDTO where firstname=?");
		query.setString(1, userName);
		List<LoginDTO> users = query.list();
		if(users !=null && !users.isEmpty())
			return users.get(0);
		return null;
	}

}
