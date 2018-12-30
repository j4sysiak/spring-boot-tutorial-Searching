package com.caveofprogramming.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.caveofprogramming.model.entity.SiteUser;

@Repository
public interface SiteUserDao extends PagingAndSortingRepository<SiteUser, Long> {
	
	SiteUser findByEmail(String email);

}
