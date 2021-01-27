package com.example.testProject.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {

	EndUser findByUserName(String userName);

	EndUser findByEmail(String email);
}
