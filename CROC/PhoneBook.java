package CROC;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeSet<String>> phoneBook = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                break;
            }

            String number = scanner.nextLine().trim();

            String standardizedNumber = standardizePhoneNumber(number);

            if (standardizedNumber != null) {
                TreeSet<String> numbers = phoneBook.getOrDefault(name, new TreeSet<>());
                numbers.add(standardizedNumber);
                phoneBook.put(name, numbers);
            }
        }

        for (Map.Entry<String, TreeSet<String>> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            TreeSet<String> numbers = entry.getValue();

            System.out.println(name);
            for (String number : numbers) {
                System.out.println(number);
            }
        }
    }

    private static String standardizePhoneNumber(String number) {
        number = number.replaceAll("[^0-9]", "");

        if (number.length() == 11) {
            if (number.startsWith("7")) {
                return "+7" + number.substring(1);
            } else if (number.startsWith("8")) {
                return "+7" + number.substring(1);
            }
        } else if (number.length() == 7) {
            return "+7495" + number;
        }

        return null;
    }
}
