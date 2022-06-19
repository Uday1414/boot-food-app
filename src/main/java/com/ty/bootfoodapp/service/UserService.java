package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.UserDao;
import com.ty.bootfoodapp.dto.Login;
import com.ty.bootfoodapp.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	public User getUserById( int id){
		return userDao.getUserById(id);
	}
	
	public User updateUserById( User user ,  int id){
		return userDao.updateUserById(user, id);
	}
	
	public String deleteUserById( int id){
		return userDao.deleteUserById(id);
	}
	
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}
}
