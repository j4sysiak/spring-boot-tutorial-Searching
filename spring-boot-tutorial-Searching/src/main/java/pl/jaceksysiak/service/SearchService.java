package pl.jaceksysiak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.core.convert.converter.Converter;
//import pl.jaceksysiak.model.SearchResult;

import pl.jaceksysiak.model.dto.SearchResult;
import pl.jaceksysiak.model.entity.Profile;
import pl.jaceksysiak.model.repository.ProfileDao;

@Service
public class SearchService {
	
	@Value("${results.pagesize}")
	private int pageSize;
	
	@Autowired
	private ProfileDao profileDao;

	public Page<SearchResult> search(String text, int pageNumber) {
		 
		PageRequest request = PageRequest.of(pageNumber-1, pageSize); 
		
		Page<Profile> results = null;
		
		if(text.trim().length()==0){
			results = profileDao.findAll(request);
		} else {
			results = profileDao.findByInterestsNameContainingIgnoreCase(text, request);
		}
		  
//		Converter<Profile, SearchResult> converter = new Converter<Profile, SearchResult>() {
//			public SearchResult convert(Profile profile) {
//				return new SearchResult(profile);
//			}	
//		};
		
		//p to jest Page object
		return results.map(p -> new SearchResult(p));
	}

}


































