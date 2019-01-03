package com.caveofprogramming.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.TestPropertySource;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.caveofprogramming.model.entity.Interest;
import com.caveofprogramming.model.entity.Profile;
import com.caveofprogramming.model.entity.SiteUser;
import com.caveofprogramming.service.InterestService;
import com.caveofprogramming.service.ProfileService;
import com.caveofprogramming.service.SiteUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:test.properties")
//@Transactional
public class BulkTests {
	
	private static final String namesFile = "/com/caveofprogramming/tests/data/names.txt";
	private static final String interestsFile = "/com/caveofprogramming/tests/data/hobbies.txt";
	
	private static final  int NUM_USER=4000;
	
	@Autowired 
	private SiteUserService siteUserService;
	
	@Autowired 
	private ProfileService profileService;
	
	@Autowired
	private InterestService interestService;
	
	private SiteUser[] testUsers = {
		
			new SiteUser("p1@wp.pl", "p1", "test", "test", "ADMIN_USER")
	};
	

	private List<String> loadFile(String filename, int maxLength) throws IOException {
		
		
		Path filePath = new ClassPathResource(filename).getFile().toPath();
		
		//System.out.println("filePath: " + filePath);
		
		Stream<String> stream = Files.lines(filePath);
		
		// @formatter:off
		
		//stream.forEach(System.out::println);

		 List<String> items =  stream
				.filter(line -> !line.isEmpty())
				.map(line -> line.trim())
				.filter(line -> line.length() <= maxLength)
				.map(line -> line.substring(0, 1).toUpperCase() + line.substring(1).toLowerCase())
				.collect(Collectors.toList());
				   
		// @formatter:on
		 
		 stream.close();
		 
		 
		return items;
	}
	
	//@Ignore
	@Test
	public void createSpecificUsers() throws IOException {
		
		for(SiteUser user : testUsers){
			
			SiteUser existingUser = siteUserService.get(user.getEmail());
			
			if(existingUser != null){
				continue;
			}
			
			user.setEnabled(true);
			
			String role = user.getRole();
			
			if(role==null){
				user.setRole("ROLE_USER");
			}
			
			siteUserService.save(user);
			
			user = siteUserService.get(user.getEmail());
			
			Profile profile = new Profile(user);
			
			profileService.save(profile);
			
		}
		
	}
	
	//@Ignore
	@Test
	public void createTestUsers() throws IOException {
		
		Random random = new Random();
		
		List<String> names = loadFile(namesFile, 25);
		List<String> interests = loadFile(interestsFile, 25);
		
//		for(String s: names){
//		System.out.println(s);
//	}
//	
//	for(String s: interests){
//		System.out.println(s);
//	}
	
		for(int numUsers=0; numUsers < NUM_USER; numUsers++) {
			
			String firstname = names.get(random.nextInt(names.size()));
			String surname = names.get(random.nextInt(names.size()));
			
			String email = firstname.toLowerCase() + surname.toLowerCase() + "@example.com";
			
			if(siteUserService.get(email) != null) {
				continue;
			}
			
			String password = "pass" + firstname.toLowerCase();
			password = password.substring(0, Math.min(15, password.length()));
			
			assertTrue(password.length() <= 15);
			

			SiteUser user = new SiteUser(email, password, firstname, surname);
			user.setEnabled(random.nextInt(5) != 0);  // co piaty bedzie disable
			
			System.out.println(user);

			siteUserService.register(user);
			
			Profile profile = new Profile(user);
			
			int numberInterests = random.nextInt(7);
			
			Set<Interest> userInterests = new HashSet<Interest>();

			for(int i=0; i<numberInterests; i++) {
				
				String interestText = interests.get(random.nextInt(interests.size()));
				
				Interest interest = interestService.createIfNotExists(interestText);
				userInterests.add(interest);
			}
			
			profile.setInterests(userInterests);
			profileService.save(profile);
			
		}
	
	assertTrue(true);
	}

}
