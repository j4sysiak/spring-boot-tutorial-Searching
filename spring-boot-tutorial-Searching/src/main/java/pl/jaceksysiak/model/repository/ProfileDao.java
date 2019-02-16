package pl.jaceksysiak.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import pl.jaceksysiak.model.entity.Profile;
import pl.jaceksysiak.model.entity.SiteUser;

public interface ProfileDao extends PagingAndSortingRepository<Profile, Long> /* CrudRepository<Profile, Long>*/ {	
	
	Profile findByUser(SiteUser user);
  
	List<Profile> findByInterestsNameContainingIgnoreCase(String text);
	Page<Profile> findByInterestsNameContainingIgnoreCase(String text, Pageable request);
	Page<Profile> findAll(Pageable request);
}