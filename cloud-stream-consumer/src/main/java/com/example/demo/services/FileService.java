package com.example.demo.services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
