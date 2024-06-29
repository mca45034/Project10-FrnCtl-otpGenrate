package com.rays.common;

import java.util.Random;

public class RendomNumber {

	public static void main(String[] args) {
		
		        // Create a Random object
		        Random random = new Random();

		        // Generate a random integer
		        int randomNumber = random.nextInt();

		        String strNumber = Integer.toString(randomNumber);

		        // Print the random integer
		        System.out.println("Random number: " + strNumber);
		    }
		}

	


