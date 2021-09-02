package app;

import java.util.InputMismatchException;

import service.ServiceImpl;

/**
 * @author Andrei Kapranov
 * @since 1.0
 */
public class Application
{
	/**
	 * @param args
	 * @throws InputMismatchException
	 * 	when user types String instead of int
	 */
	public static void main(String[] args) throws InputMismatchException
	{
		ServiceImpl serviceImpl = new ServiceImpl();
		serviceImpl.addNewNumber();
		boolean indicator = true;
		while (indicator)
		{
			indicator = serviceImpl.processInterfaceMessage();
		}
	}
}



