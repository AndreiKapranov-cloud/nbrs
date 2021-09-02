package service;

import domain.Numbers;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ServiceImpl implements Service {
    /**
     * @param numbers all the numbers we have
     */
    Scanner scanner = new Scanner(System.in);
    Numbers number = new Numbers();

    @Override
    public void ShowTheResult(List<Integer> numbers) {
        System.out.println(numbers);
        System.out.println("Max= " + Collections.max(numbers));
        System.out.println("Min= " + Collections.min(numbers));
        System.out.println("Average= " + numbers.stream().mapToInt(val -> val).average().orElse(0.0));
    }
//when we start the application
    @Override
    public int getFirstNumber() {
        try {
            number.setNumber(scanner.nextInt());
        } catch (
                InputMismatchException e) {//if user types String instead of int.
            scanner.nextLine();
            System.out.println("Only int:");
            number.setNumber(scanner.nextInt());
        }
        return number.getNumber();
    }

    @Override
    public void addNumber(List<Integer> numbers) {
        System.out.println("Please,enter a number:");
        number.setNumber(scanner.nextInt());
        numbers.add(number.getNumber());
    }
}
