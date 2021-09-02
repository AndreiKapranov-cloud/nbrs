package service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import domain.Numbers;

public class ServiceImpl
{
	private static final String ENTER_A_NUMBER_MESSAGE = "Please,enter a number:";
	private static final String ONLY_NUMBERS_MESSAGE = "Only numbers!";
	private static final String ONLY_NUMBERS_FOR_INTERFACE_MESSAGE = "Only numbers from 1 to 3!";
	private static final String INTERFACE_MESSAGE =
		"If you want to enter a number-press 1,if you want to see max,min and average-press 2," +
			"if you want to quit-press 3:";
	private static final Scanner scanner = new Scanner(System.in);
	private static final Numbers numbers = new Numbers();

	public void addNewNumber()
	{
		System.out.println(ENTER_A_NUMBER_MESSAGE);
		try
		{
			numbers.addNumber(scanner.next());
		}
		catch (NumberFormatException e)
		{
			System.out.println(ONLY_NUMBERS_MESSAGE);
			addNewNumber();
		}
	}

	public boolean processInterfaceMessage()
	{
		System.out.println(INTERFACE_MESSAGE);
		Integer decision;
		try
		{
			String next = scanner.next();
			decision = Numbers.parseInteger(next);
			return processDecision(decision);
		}
		catch (NumberFormatException e)
		{
			System.out.println(ONLY_NUMBERS_FOR_INTERFACE_MESSAGE);
			return processInterfaceMessage();
		}

	}

	private boolean processDecision(Integer decision) throws NumberFormatException
	{
		switch (decision)
		{
			case 1:
				addNewNumber();
				break;
			case 2:
				printResult();
				break;
			case 3:
				return false;
			default:
				throw new NumberFormatException("");
		}
		return true;
	}

	private void printResult()
	{
		List<Integer> collection = numbers.getCollection();

		System.out.println(collection);
		System.out.println("Max= " + Collections.max(collection));
		System.out.println("Min= " + Collections.min(collection));
		System.out.println("Average= " + collection.stream().mapToInt(val -> val).average().orElse(0.0));
	}

}
