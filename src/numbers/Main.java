package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main extends CheckProperty {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n");
        printWelcome();
        propertiesNumber();
    }

    // Output of the greeting
    static void printWelcome() {
        var textBlock = """
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.
                """;
        System.out.println(textBlock);
    }

    // Validating 0 and Singular Input
    static void propertiesNumber() {
        while (true) {
            System.out.println("\nEnter a request:");
            ArrayList<String> properties = createIn();
            if (!properties.isEmpty() && checkIn(properties)) {
                if (Long.parseLong(properties.get(0)) == 0) {
                    System.out.println("\nGoodbye!");
                    break;
                }
                if (properties.size() == 1)
                    new CheckNumber(Long.parseLong(properties.get(0))).printProperties();
                else
                    properestArray(properties);
            }
        }
    }

    // Creating a list of values
    static ArrayList<String> createIn() {
        ArrayList<String> properties = new ArrayList<>();
        var scanner = new Scanner(System.in).nextLine().split(" ");
        if (scanner[0].isEmpty()) {
            printWelcome();
        } else
            properties.addAll(Arrays.asList(scanner));
        return properties;
    }

    // Instantiating a class CheckNumber before reaching a range of numbers
    static void properestArray(ArrayList<String> properties) {
        var count = 0;
        for (var i = 0; count < Long.parseLong(properties.get(1)); i++)
            count += new CheckNumber(Long.parseLong(properties.get(0)) + i).
                    printPropertiesArray();
    }
}
