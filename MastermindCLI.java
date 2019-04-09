package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MastermindCLI {
	String gameNumbers = "";

	public MastermindCLI() {

	}

	public MastermindCLI(String gameNumbers) {
		this.gameNumbers = gameNumbers;
	}

	public static void main(String[] args) {
		MastermindCLI newMastermind = new MastermindCLI();
		newMastermind.run();
	}

	public void run() {
		while (true) {
			displayMastermindBanner();
			playGame(gameNumbers);
		}
	}

	public void playGame(String gameNumbers) {
		for (int i = 0; i < 4; i++) {
			gameNumbers += (int) ((Math.random() * 6) + 1);
		}
			System.out.println(gameNumbers);
		int playerTurns = 0;
		while (true) {
			int plusCounter = 0;
			int minusCounter = 0;
			int sameCounter = 0;
			playerTurns += 1;
			if (playerTurns > 10) {
				System.out.println("Game Over! Number sequence was " + gameNumbers);
				break;
			}
			Scanner kb = new Scanner(System.in);
			String userInput = kb.nextLine();
			for (int i = 0; i < 4; i++) {
				if (userInput.charAt(i) == gameNumbers.charAt(i)) {
					plusCounter++;
					sameCounter++;
				}
				if (plusCounter == 4) {
					winGame();
				}
			}
			
			if(userInput.charAt(0) == gameNumbers.charAt(1) || userInput.charAt(0) == gameNumbers.charAt(2) || userInput.charAt(0) == gameNumbers.charAt(3)) {
				minusCounter +=1;
			}
			else if(userInput.charAt(1) == gameNumbers.charAt(0) || userInput.charAt(1) == gameNumbers.charAt(2) || userInput.charAt(1) == gameNumbers.charAt(3)) {
				minusCounter +=1;
			}
			else if(userInput.charAt(2) == gameNumbers.charAt(0) || userInput.charAt(2) == gameNumbers.charAt(1) || userInput.charAt(2) == gameNumbers.charAt(3)) {
				minusCounter +=1;
			}
			else if(userInput.charAt(3) == gameNumbers.charAt(0) || userInput.charAt(3) == gameNumbers.charAt(1) || userInput.charAt(3) == gameNumbers.charAt(2)) {
				minusCounter +=1;
			}
			// same number 1
			// minus number 3
//			// Check for same numbers at index 0
//			for (int i = 0; i < 4; i++) {
//				if (userInput.charAt(0) == gameNumbers.charAt(i)) {
//					minusCounter+=1;
//				}
//			}
//			// Check for same number at index 1
//			for (int i = 0; i < 4; i++) {
//				if (userInput.charAt(1) == gameNumbers.charAt(i)) {
//					minusCounter+=1;
//				}
//			}
//			// Check for same number at index 2
//			for (int i = 0; i < 4; i++) {
//				if (userInput.charAt(2) == gameNumbers.charAt(i)) {
//					minusCounter+=1;
//				}
//			}
//
//			// Check for same number at index 3
//			for (int i = 0; i < 4; i++) {
//				if (userInput.charAt(3) == gameNumbers.charAt(i)) {
//					minusCounter+=1;
//				}
//			}

			
			System.out.println("Guess #" + playerTurns);
			for (int i = 0; i < plusCounter; i++) {
				System.out.print(" + ");
			}
			minusCounter -= sameCounter;
			for (int i = 0; i < minusCounter ; i++) {
				System.out.print(" - ");
			}
			System.out.println("\n");
		}
	}

	public void winGame() {
		System.out.println(" + + + + \nYou won!");
		run();
	}
	
	public void displayMastermindBanner() {
		System.out.println("  __  __           _                      _           _ \n"
				+ " |  \\/  | __ _ ___| |_ ___ _ __ _ __ ___ (_)_ __   __| |\n"
				+ " | |\\/| |/ _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` |\n"
				+ " | |  | | (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| |\n"
				+ " |_|  |_|\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_|\n"
				+ "Guess the 4 number sequence (Numbers 1-6)\n");

	}

}
