package com.jspiders.cardekho_case_study.main;

import java.util.Scanner;

import com.jspiders.cardekho_case_study.operation.CarOperation;

public class CarDekhoMenu {

	private static CarOperation operation = new CarOperation();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			displayMenu();
			int choice1 = scanner.nextInt();

			switch (choice1) {
			case 1:
				displayAddRemoveMenu();
				int choice2 = scanner.nextInt();
				switch (choice2) {
				case 1:
					operation.addCarDetails();
					break;
				case 2:
					operation.removeCarDetails();
					break;
				case 3:
					break;
				default:
					System.out.println("\nInvalid choice. Try again..!!");
				}
				break;

			case 2:
				displaySearchMenu();
				int choice3 = scanner.nextInt();
				switch (choice3) {
				case 1:
					operation.searchByName();
					break;
				case 2:
					operation.searchByBrand();
					break;
				case 3:
					operation.searchByFuelType();
					break;
				case 4:
					operation.getAllCarDetails();
					break;
				case 5:
					break;
				default:
					System.out.println("\nInvalid choice. Try again..!!");
				}
				break;

			case 3:
				operation.editCarDetails();
				break;

			case 4:
				System.out.println("Thank you..!!");
				scanner.close();
				return;

			default:
				System.out.println("\nInvalid choice. Try again..!!");
				break;
			}
		}
	}

	private static void displayMenu() {
		System.out.println("===========MENU==========");
		System.out.println("1. Add/Remove Car Details");
		System.out.println("2. Search Car Details");
		System.out.println("3. Edit Car Details");
		System.out.println("4. Exit");
		System.out.print("\nEnter your choice : ");
	}

	private static void displayAddRemoveMenu() {
		System.out.println("===========MENU==========");
		System.out.println("1. Add Car Details");
		System.out.println("2. Remove Car Details");
		System.out.println("3. Go Back To Main Menu");
		System.out.print("\nEnter your choice : ");
	}

	private static void displaySearchMenu() {
		System.out.println("--------MENU--------");
		System.out.println("1. Search Car By Name");
		System.out.println("2. Search Car By Brand");
		System.out.println("3. Search Car By Fuel Type");
		System.out.println("4. Search All Cars");
		System.out.println("5. Go Back To Main Menu");
		System.out.print("\nEnter your choice : ");
	}
}
