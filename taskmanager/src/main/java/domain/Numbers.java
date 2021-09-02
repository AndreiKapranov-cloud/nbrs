package domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers
{
	private final List<Integer> collection = new ArrayList<>();

	public List<Integer> getCollection()
	{
		return new ArrayList<>(collection);
	}

	public void addNumber(String s) throws NumberFormatException
	{
		collection.add(parseInteger(s));
	}

	public static Integer parseInteger(String s) throws NumberFormatException
	{
		try
		{
			return Integer.parseInt(s);
		}
		catch (NullPointerException e)
		{
			throw new NumberFormatException(e.getMessage());
		}
	}
}


