package com.caveofprogramming.tests;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.TestPropertySource;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:test.properties")
@Transactional
public class BulkTests2 {
	
	private static final String namesFile = "/com/caveofprogramming/tests/data/names.txt";
	private static final String interestsFile = "/com/caveofprogramming/tests/data/hobbies.txt";

	private List<String> loadFile(String filename, int maxLength) throws IOException {
		
		Path filePath = new ClassPathResource(filename).getFile().toPath();
		
		System.out.println(filePath);
		 
		return null;
	}
	
	//@Ignore
	@Test
	public void createTestData() throws IOException {
		
		List<String> names = loadFile(namesFile, 25);
		List<String> interests = loadFile(interestsFile, 25);
	}

}
