package pl.jaceksysiak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.jaceksysiak.model.entity.Profile;
import pl.jaceksysiak.model.entity.SiteUser;
import pl.jaceksysiak.model.repository.ProfileDao;

@Service
public class ProfileService {
	
	@Autowired
	ProfileDao profileDao;
	
	public void save(Profile profile) {
		profileDao.save(profile);
	}
	
	public Profile getUserProfile(SiteUser user) {
		return profileDao.findByUser(user);
	}
}