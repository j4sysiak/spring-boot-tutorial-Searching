package pl.jaceksysiak.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import pl.jaceksysiak.model.entity.SiteUser;

@Repository
public interface SiteUserDao extends PagingAndSortingRepository<SiteUser, Long> {
	
	SiteUser findByEmail(String email);

}
