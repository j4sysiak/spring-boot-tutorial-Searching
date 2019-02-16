package pl.jaceksysiak.model.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import pl.jaceksysiak.model.entity.StatusUpdate;

@Repository
public interface StatusUpdateDao extends PagingAndSortingRepository<StatusUpdate, Long> {

	StatusUpdate findFirstByOrderByAddedDesc();
}
