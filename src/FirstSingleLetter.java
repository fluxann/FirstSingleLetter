import java.util.Arrays;
import java.util.Scanner;

/**
 * The program accepts an arbitrary text as input and finds in each word of this text
 * the first symbol that is NOT repeated in the analyzed word
 * then the program selects the first unique letter from the received set of letters and returns it.
 */

public class FirstSingleLetter {
    public static void main(String[] args) {

        String input = String.valueOf(scanInput());

        String first_single_letter = parser(input);

        if (!first_single_letter.equals("")) {
            System.out.println(" First single letter is: " + first_single_letter);
        } else System.out.println("First single letter not found!");

    }

    /**
     * Method for taking input
     * @return the entire line of the text
     */
    private static StringBuilder scanInput() {
        System.out.println(" Hello! Please, type your input: ");
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());

        while (!scanner.nextLine().isEmpty()) {
            input.append(scanner.nextLine());
        }
        return input;
    }

    /**
     * Method accepts text and removes all characters except alphabetic expressions.
     * Then words are broken into an arrays of letters and search unique letters by using findFirstLetter(word) method
     * @param input line of the text
     * @return first unique letter from the text
     */
    private static String parser(String input) {

        input = input.replaceAll("[^a-zA-Zà-ÿÀ-ß]", "#");
        String[] words_arr = input.split("[^a-zA-Zà-ÿÀ-ß]+");

        String[] single_letters_list = new String[words_arr.length];
        String result;

        for (int i = 0; i < words_arr.length; i++) {
            String[] letters_arr = words_arr[i].split("");// split each individual element
            single_letters_list[i] = findFirstLetter(letters_arr);
        }
        result = findFirstLetter(single_letters_list);

        return result;
    }

    /**
     * Method find first unique letter from input array of letters
     * @param word array of letters
     * @return  first unique letter
     */
    public static String findFirstLetter(String[] word) {
        int index_of_cur_letter = 0; //zero element
        String current_letter = word[index_of_cur_letter];

        for (int i = 1; i < word.length; i++) {
            if (index_of_cur_letter == i) {
                continue;
            }

            if (current_letter.equals(word[i])) {
                index_of_cur_letter++;
                try {
                    current_letter = word[index_of_cur_letter];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return "";
                }

                i = -1;//to start searching from zero element
            }
        }
        return current_letter;
    }

}

