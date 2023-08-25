package com.jspider.Filehandling.operations;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo2 {
	public static void main(String[] args) {
		File file = new File("D:/WEJA2/FileHandling/Peth.txt");

		try {
			file.createNewFile();
			System.out.println("File is created");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File is not created");
		}
	}
}
