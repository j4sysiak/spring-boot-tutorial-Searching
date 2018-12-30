package com.caveofprogramming.model.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.caveofprogramming.model.entity.VerificationToken;

@Repository
public interface VerificationDao extends PagingAndSortingRepository<VerificationToken, Long> {
	
	VerificationToken findByToken(String token);
}