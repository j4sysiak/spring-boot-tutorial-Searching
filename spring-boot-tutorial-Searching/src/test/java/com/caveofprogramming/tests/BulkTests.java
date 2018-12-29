package com.caveofprogramming.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class BulkTests {
	
	private static final String namesFile = "/com/caveofprogramming/tests/data/names.txt";
	private static final String interestsFile = "/com/caveofprogramming/tests/data/hobbies.txt";

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
	public void createTestData() throws IOException {
		
		List<String> names = loadFile(namesFile, 25);
		List<String> interests = loadFile(interestsFile, 25);
		
//		for(String s : names){
//			System.out.println(s);
//		}
	}

}
