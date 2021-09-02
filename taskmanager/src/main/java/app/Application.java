package app;

import service.ServiceImpl;

import java.util.*;

/**
 * @author Andrei Kapranov
 * @since 1.0
 */
public class Application {
    /**
     * @param args
     * @throws InputMismatchException when user types String instead of int
     */

    public static void main(String[] args) throws InputMismatchException {
        List<Integer> numbers = new ArrayList<>();
        ServiceImpl serviceImpl = new ServiceImpl();
        System.out.println("Please,enter a number:");
        int number = serviceImpl.getFirstNumber();
        numbers.add(number);
        boolean indicator = true;
        while (indicator) {
            System.out.println("If you want to enter a number-press 1,if you want to see max,min and average-press 2," +
                    "if you want to quit-press 3:");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1) {
                serviceImpl.addNumber(numbers);
            }
            if (input == 2) {
                serviceImpl.ShowTheResult(numbers);
            }
            if (input == 3) {
                indicator = false;
            }
        }
    }
}



