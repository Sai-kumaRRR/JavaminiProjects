package UnitConverter;

import java.util.Scanner;

public class UnitConverter01 {
    private final Scanner scanner;

    public UnitConverter01() {
        scanner = new Scanner(System.in);
    }

    // Temperature Conversions
    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Length Conversions
    private double metersToFeet(double meters) {
        return meters * 3.28084;
    }

    private double feetToMeters(double feet) {
        return feet / 3.28084;
    }

    private double kilometersToMiles(double km) {
        return km * 0.621371;
    }

    private double milesToKilometers(double miles) {
        return miles / 0.621371;
    }

    // Weight Conversions
    private double kilosToPounds(double kilos) {
        return kilos * 2.20462;
    }

    private double poundsToKilos(double pounds) {
        return pounds / 2.20462;
    }

    private void convertTemperature() {
        System.out.println("\nTemperature Conversion");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose conversion (1-2): ");

        String choice = scanner.nextLine();
        System.out.print("Enter value to convert: ");
        try {
            double value = Double.parseDouble(scanner.nextLine());
            switch (choice) {
                case "1":
                    System.out.printf("%.2f°C = %.2f°F%n",
                            value, celsiusToFahrenheit(value));
                    break;
                case "2":
                    System.out.printf("%.2f°F = %.2f°C%n",
                            value, fahrenheitToCelsius(value));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }

    private void convertLength() {
        System.out.println("\nLength Conversion");
        System.out.println("1. Meters to Feet");
        System.out.println("2. Feet to Meters");
        System.out.println("3. Kilometers to Miles");
        System.out.println("4. Miles to Kilometers");
        System.out.print("Choose conversion (1-4): ");

        String choice = scanner.nextLine();
        System.out.print("Enter value to convert: ");
        try {
            double value = Double.parseDouble(scanner.nextLine());
            switch (choice) {
                case "1":
                    System.out.printf("%.2f meters = %.2f feet%n",
                            value, metersToFeet(value));
                    break;
                case "2":
                    System.out.printf("%.2f feet = %.2f meters%n",
                            value, feetToMeters(value));
                    break;
                case "3":
                    System.out.printf("%.2f kilometers = %.2f miles%n",
                            value, kilometersToMiles(value));
                    break;
                case "4":
                    System.out.printf("%.2f miles = %.2f kilometers%n",
                            value, milesToKilometers(value));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }

    private void convertWeight() {
        System.out.println("\nWeight Conversion");
        System.out.println("1. Kilograms to Pounds");
        System.out.println("2. Pounds to Kilograms");
        System.out.print("Choose conversion (1-2): ");

        String choice = scanner.nextLine();
        System.out.print("Enter value to convert: ");
        try {
            double value = Double.parseDouble(scanner.nextLine());
            switch (choice) {
                case "1":
                    System.out.printf("%.2f kilograms = %.2f pounds%n",
                            value, kilosToPounds(value));
                    break;
                case "2":
                    System.out.printf("%.2f pounds = %.2f kilograms%n",
                            value, poundsToKilos(value));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }

    private void displayMenu() {
        System.out.println("\nUnit Converter");
        System.out.println("1. Temperature Conversion");
        System.out.println("2. Length Conversion");
        System.out.println("3. Weight Conversion");
        System.out.println("4. Exit");
        System.out.print("Choose category (1-4): ");
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    convertTemperature();
                    break;
                case "2":
                    convertLength();
                    break;
                case "3":
                    convertWeight();
                    break;
                case "4":
                    running = false;
                    System.out.println("Thank you for using the Unit Converter!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        UnitConverter01 converter = new UnitConverter01();
        converter.run();
    }
}


