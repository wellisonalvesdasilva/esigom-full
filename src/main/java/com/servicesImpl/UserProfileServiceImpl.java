package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserProfileDao;
import com.model.UserProfile;
import com.services.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileDao dao;

	public UserProfile findById(int id) {
		return dao.findById(id);
	}

	public UserProfile findByType(String type) {
		return dao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return dao.findAll();
	}
}
