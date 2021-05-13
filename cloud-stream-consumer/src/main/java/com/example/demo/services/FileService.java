package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class FileService {

	public void save(String fileName, String order) {
       
		Path path = Paths.get(fileName+".txt");
       
		try {
			Files.writeString(path, order);
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
