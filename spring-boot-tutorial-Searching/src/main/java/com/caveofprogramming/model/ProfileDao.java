package com.caveofprogramming.model;

import java.util.Collection;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileDao extends PagingAndSortingRepository<Profile, Long> {	
	
	Profile findByUser(SiteUser user);

	Collection<Profile> findByInterestsNameContainingIgnoreCase(String text);
}