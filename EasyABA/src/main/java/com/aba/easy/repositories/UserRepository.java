package com.aba.easy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aba.easy.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
