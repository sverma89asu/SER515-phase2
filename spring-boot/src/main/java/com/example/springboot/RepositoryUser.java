package com.example.springboot;

import org.springframework.data.repository.CrudRepository;

import scrum_sim_packages.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RepositoryUser extends CrudRepository<User, Integer> {

}
