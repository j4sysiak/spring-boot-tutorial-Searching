package com.caveofprogramming.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.caveofprogramming.model.entity.Profile;
import com.caveofprogramming.model.entity.SiteUser;

public interface ProfileDao extends CrudRepository<Profile, Long> {	
	
	Profile findByUser(SiteUser user);

	//Page<Profile> findByInterestsNameContainingIgnoreCase(String text, PageRequest request);

	List<Profile> findByInterestsNameContainingIgnoreCase(String text);
	List<Profile> findByInterestsNameContainingIgnoreCase(String text, Pageable request);
}