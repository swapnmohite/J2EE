package com.jspider.Filehandling.operations;

import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		File file = new File("Demo.txt");
		if (file.exists()) {
			file.delete();
			System.out.println("File is Deleted");
		} else {
			System.out.println("File not found");
		}
	}
}