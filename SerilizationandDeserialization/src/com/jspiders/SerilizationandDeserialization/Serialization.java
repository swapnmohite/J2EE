package com.jspiders.SerilizationandDeserialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	public static void main(String[] args) throws IOException {
		File file = new File("student.txt");
		if (file.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			Student student = new Student(1, "John", "john@gmail.com", 25);
			objectOutputStream.writeObject(student);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Object has been serialized");
		} else {
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			Student student = new Student(1, "John", "john@gmail.com", 25);
			objectOutputStream.writeObject(student);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Object has been serialized");

		}
	}
}
