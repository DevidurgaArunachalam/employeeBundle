package com.launchclub.getUserInputs;

import java.util.Scanner;

public class UserInputs {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static String getString(String stringInput) {
		System.out.println(stringInput);
		return SCANNER.next().trim();

	}
}
