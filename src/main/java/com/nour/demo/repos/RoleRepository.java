package com.nour.demo.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nour.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String role);

}
