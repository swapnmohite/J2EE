package com.jspiders.SerilizationandDeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("student.txt");
		if (file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Student student = (Student) objectInputStream.readObject();
			System.out.println(student);
			objectInputStream.close();
			fileInputStream.close();
		} else {
			System.out.println("File does not exist");
		}
	}
}
