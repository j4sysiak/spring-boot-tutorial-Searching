package com.caveofprogramming.model.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.caveofprogramming.model.entity.Interest;

@Repository
public interface InterestDao extends PagingAndSortingRepository<Interest, Long> {
	
	Interest findOneByName(String name);
}
