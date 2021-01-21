package com.techelevator;

import com.techelevator.view.Menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import materials.Candy;
import materials.Chips;
import materials.Drinks;
import materials.Gum;
import materials.OurWallet;
import materials.Sellables;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String CASH_OUT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			CASH_OUT };
	private static final String[] PURCHASE_MENU = { "Feed Money", "Select Product", "Finish Transaction", "Back" };
	private static final String[] FEED_MONEY_MENU = { "$1", "$2", "$5", "$10", "Back" };

	private Menu menu;
	private OurWallet wallet = new OurWallet();

	List<Sellables> sellables = new ArrayList<Sellables>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {

		File vendingMachineFile = new File("vendingmachine.csv");
		Scanner sellablesScanner = new Scanner(vendingMachineFile);
		while (sellablesScanner.hasNextLine()) {
			String line = sellablesScanner.nextLine();
			String[] lineArr = line.split("\\|");
			String type = lineArr[3];

			if (type.equals("Chip")) {
				Chips chip = new Chips(lineArr[0], lineArr[1], Double.parseDouble(lineArr[2]));
				sellables.add(chip);
			} else if (type.equals("Candy")) {
				Candy candy = new Candy(lineArr[0], lineArr[1], Double.parseDouble(lineArr[2]));
				sellables.add(candy);
			} else if (type.equals("Drink")) {
				Drinks drink = new Drinks(lineArr[0], lineArr[1], Double.parseDouble(lineArr[2]));
				sellables.add(drink);
			} else if (type.equals("Gum")) {
				Gum gum = new Gum(lineArr[0], lineArr[1], Double.parseDouble(lineArr[2]));
				sellables.add(gum);
			}
		}

		System.out.println("Welcome to Umbrella Corp's Vendo-Matic 800!");
		System.out.println("Please use the options below to make a selection: ");

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			System.out.println("You picked: " + choice);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				System.out.println("\n" + "Here's what is currently in stock:" + "\n");
				for (Sellables item : sellables) {
					System.out.println(item.getCode() + " | " + item.getName() + " $" + item.getPrice()
							+ " | Current Quantity: " + item.getQuantity());
				}
			}
			if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				String selection = "";

				while (!selection.equals("Back")) {
					selection = (String) menu.getChoiceFromOptions(PURCHASE_MENU);

					if (selection.equals("Feed Money")) {
						processMoney();
					}

					if (selection.equals("Select Product")) {
						selectProduct();
					}

					else if (selection.equals("Finish Transaction")) {
						finishTransaction();
					}

					System.out.println("You selected from the 2nd level");
				}

			}
			if (choice.equals(CASH_OUT)) {
					System.out.println("Thank you for choosing the Vendo-Matic 800! If you change your mind, please select one of the options below:");
				}

			}
		}

	

	public void processMoney() {

		String selection = "";

		while (!selection.equals("Back")) {

			selection = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU);

			if (selection.equals("$1")) {
				wallet.addMoney(1.00);
			} else if (selection.equals("$2")) {
				wallet.addMoney(2.00);
			} else if (selection.equals("$5")) {
				wallet.addMoney(5.00);
			} else if (selection.equals("$10")) {
				wallet.addMoney(10.00);

			}

			System.out.print("You have " + wallet.getBalanceAsString() + "\n");
		}
	}

	public void selectProduct() throws FileNotFoundException {

		System.out.println("\n" + "Here's what is currently in stock:" + "\n");
		for (Sellables item : sellables) {
			System.out.println(item.getCode() + " | " + item.getName() + " | $" + item.getPrice()
					+ " | Current Quantity: " + item.getQuantity());
		}

		Scanner productInputScanner = new Scanner(System.in);
		System.out.println("Enter product code: ");
		String prodCodeEntered = productInputScanner.nextLine();

		boolean prodFound = false;

		for (Sellables item : sellables) {

			if (item.getCode().equals(prodCodeEntered)) {
				prodFound = true;

				double trialBalance = wallet.getBalance() - item.getPrice();

				if (trialBalance >= 0) {

					int currentQty = item.getQuantity();
					int newQty = currentQty - 1;
					item.setQuantity(newQty);

					wallet.withdrawMoney(item.getPrice());
					System.out.println(item.getMessage() + " You've selected " + item.getName() + ", and they cost $"
							+ item.getPrice() + ". You have " + wallet.getBalanceAsString() + " left to spend.");

				} else {
					System.out.println("You don't have enough money. Please feed more money into the machine. ");
				}
			}
		}

		if (!prodFound) {
			System.out.println("product not found.");
		}

	}

	public void finishTransaction() {
		System.out.println("/n" + "We are now dispensing your change.");
		System.out.println("Your change comes out to:");
		wallet.returnChangeAsCoins();
		System.out.println("\n" + "Thank you for using Umbrealla Corp's Vendo-Matic 800!" + "\n");
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
