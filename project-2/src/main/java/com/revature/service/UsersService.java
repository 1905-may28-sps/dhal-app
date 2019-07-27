package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.DhalUsers;
import com.revature.repositories.UsersRepository;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersRepository userRepo;
	
	public List<DhalUsers> getAll() {
		return userRepo.findAll();
	}

	public DhalUsers add(DhalUsers u) {
		return userRepo.save(u);
	}

	public DhalUsers findById(int id) {
		return userRepo.findOne(id);
	}

	public DhalUsers findByUsername(String username) {
		return userRepo.findByUsernameIgnoreCase(username);
	}

	public DhalUsers update(DhalUsers u) {
		return null;
	}
	
	public DhalUsers login(DhalUsers loginInfo) {
		DhalUsers user = userRepo.findByUsernameIgnoreCase(loginInfo.getUsername());
		if (user != null && user.getPassword().equals(loginInfo.getPassword()))
			return user;
		return null;
	}

}