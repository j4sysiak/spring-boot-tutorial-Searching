package com.caveofprogramming.model.repository;

import java.util.Collection;



//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.caveofprogramming.model.entity.Profile;
import com.caveofprogramming.model.entity.SiteUser;

public interface ProfileDao extends PagingAndSortingRepository<Profile, Long> {	
	
	Profile findByUser(SiteUser user);

	Collection<Profile> findByInterestsNameContainingIgnoreCase(String text);
}