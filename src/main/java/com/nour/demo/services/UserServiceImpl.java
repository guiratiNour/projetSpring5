package com.nour.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nour.demo.entities.Role;
import com.nour.demo.entities.User;
import com.nour.demo.repos.RoleRepository;
import com.nour.demo.repos.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public User saveUser(User user) {
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	return userRep.save(user);
	}
	@Override
	public User addRoleToUser(String username, String rolename) {
	User usr = userRep.findByUsername(username);
	Role r = roleRep.findByRole(rolename);
	usr.getRoles().add(r);
	return usr;
	}
	@Override
	public Role addRole(Role role) {
	return roleRep.save(role);
	}
	@Override
	public User findUserByUsername(String username) {
	return userRep.findByUsername(username);
	}
	@Override
	public List<User> findAllUsers() {
		
		return userRep.findAll();
	}
	@Override
	public User updateUser(User user) {
		
		return userRep.save(user) ;
	}
	@Override
	public User getUserbyId(Long id) {
		
		return userRep.findById(id).get();
	}
	@Override
	public void deleteUserbyId(Long id) {
		
		 userRep.deleteById(id);
	}
	@Override
	public Role updateRole(Role role) {
		
		return roleRep.save(role);
	}
	@Override
	public void deleteRolebyId(Long id) {
		roleRep.deleteById(id);
		
	}
	@Override
	public Role getRolebyId(Long id) {
	
		return roleRep.findById(id).get();
	}
	@Override
	public List<Role> findAllRoles() {
		
		return roleRep.findAll();
	}
	

}
