package com.jspider.Filehandling.operations;

import java.io.File;
import java.io.IOException;

public class Fileexists {

	public static void main(String[] args) {
		File file = new File("D:/Eclipse/FileHandling/Peth.txt");
		if (file.exists()) {
			System.out.println("File is already exists");
		} else {
			try {
				file.createNewFile();
				System.out.println("File is created");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("File is not created");
			}
		}
	}

}
