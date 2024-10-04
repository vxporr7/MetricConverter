import java.util.Scanner;
public class MetricConverter {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        double value = 0;
        char unit = ' ';

        // Input loop
        do {
            try {
                System.out.print("Enter value followed by unit (m for miles, y for yards, f for feet, i for inches): ");
                String input = in.nextLine().trim();

                if (input.length() > 1) {
                    value = Double.parseDouble(input.substring(0, input.length() - 1));
                    unit = Character.toLowerCase(input.charAt(input.length() - 1));

                    if (unit == 'm' || unit == 'y' || unit == 'f' || unit == 'i') {
                        validInput = true;
                    } else {
                        System.out.println("Invalid unit. Please enter 'm' for miles, 'y' for yards, 'f' for feet, or 'i' for inches.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid value followed by a unit.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid format. Please enter a valid number followed by a unit.");
            }
        } while (!validInput);

        // Conversion
        switch (unit) {
            case 'm':
                System.out.printf("%.2f miles is %.2f yards, %.2f feet, %.2f inches%n", value, value * 1760, value * 5280, value * 63360);
                break;
            case 'y':
                System.out.printf("%.2f yards is %.2f miles, %.2f feet, %.2f inches%n", value, value / 1760, value * 3, value * 36);
                break;
            case 'f':
                System.out.printf("%.2f feet is %.2f miles, %.2f yards, %.2f inches%n", value, value / 5280, value / 3, value * 12);
                break;
            case 'i':
                System.out.printf("%.2f inches is %.2f miles, %.2f yards, %.2f feet%n", value, value / 63360, value / 36, value / 12);
                break;
        }

        // Tests
        System.out.println("\nRunning tests...");
        runTests();
    }

    public static void runTests() {
        // Known cases
        double testValueMiles = 1;
        double testValueYards = 1760;
        double testValueFeet = 5280;
        double testValueInches = 63360;

        System.out.printf("1 mile is %.2f yards, %.2f feet, %.2f inches%n", testValueMiles * 1760, testValueMiles * 5280, testValueMiles * 63360);
        System.out.printf("1760 yards is %.2f miles, %.2f feet, %.2f inches%n", testValueYards / 1760, testValueYards * 3, testValueYards * 36);
        System.out.printf("5280 feet is %.2f miles, %.2f yards, %.2f inches%n", testValueFeet / 5280, testValueFeet / 3, testValueFeet * 12);
        System.out.printf("63360 inches is %.2f miles, %.2f yards, %.2f feet%n", testValueInches / 63360, testValueInches / 36, testValueInches / 12);

        // Test bad input
        try {
            System.out.println("Testing bad input...");
            Double.parseDouble("bad input");
        } catch (NumberFormatException e) {
            System.out.println("Caught bad input as expected.");
        }
    }
}
