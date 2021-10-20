package util;

import java.util.HashMap;
import java.util.Map;

public class Util {

    public static Map<Character, Integer> alphabet;
    public static Map<Character, Character> lowerAlphabet;

    static {
        //A aB bC cD dE eF fG gH hI iJ jK kL lM mN nO oP pQ qR rS sT tU uV vW wX xY yZ z
        lowerAlphabet = new HashMap<>();
        lowerAlphabet.put('A', 'a');
        lowerAlphabet.put('B', 'b');
        lowerAlphabet.put('C', 'c');
        lowerAlphabet.put('D', 'd');
        lowerAlphabet.put('E', 'e');
        lowerAlphabet.put('F', 'f');
        lowerAlphabet.put('G', 'g');
        lowerAlphabet.put('H', 'h');
        lowerAlphabet.put('I', 'i');
        lowerAlphabet.put('J', 'j');
        lowerAlphabet.put('K', 'k');
        lowerAlphabet.put('L', 'l');
        lowerAlphabet.put('M', 'm');
        lowerAlphabet.put('N', 'n');
        lowerAlphabet.put('O', 'o');
        lowerAlphabet.put('P', 'p');
        lowerAlphabet.put('Q', 'q');
        lowerAlphabet.put('R', 'r');
        lowerAlphabet.put('S', 's');
        lowerAlphabet.put('T', 't');
        lowerAlphabet.put('U', 'u');
        lowerAlphabet.put('V', 'v');
        lowerAlphabet.put('W', 'w');
        lowerAlphabet.put('X', 'x');
        lowerAlphabet.put('Y', 'y');
        lowerAlphabet.put('Z', 'z');
    }

    static {
        //A aB bC cD dE eF fG gH hI iJ jK kL lM mN nO oP pQ qR rS sT tU uV vW wX xY yZ z
        alphabet = new HashMap<>();
        alphabet.put('a', 0);
        alphabet.put('b', 1);
        alphabet.put('c', 2);
        alphabet.put('d', 3);
        alphabet.put('e', 4);
        alphabet.put('f', 5);
        alphabet.put('g', 6);
        alphabet.put('h', 7);
        alphabet.put('i', 8);
        alphabet.put('j', 9);
        alphabet.put('k', 10);
        alphabet.put('l', 11);
        alphabet.put('m', 12);
        alphabet.put('n', 13);
        alphabet.put('o', 14);
        alphabet.put('p', 15);
        alphabet.put('q', 16);
        alphabet.put('r', 17);
        alphabet.put('s', 18);
        alphabet.put('t', 19);
        alphabet.put('u', 20);
        alphabet.put('v', 21);
        alphabet.put('w', 22);
        alphabet.put('x', 23);
        alphabet.put('y', 24);
        alphabet.put('z', 25);
    }

    public static char lowerCase(char c) {
        if (c != ' ') {
            if (lowerAlphabet.containsKey(c)) {
                return lowerAlphabet.get(c);
            }
        }
        return c;
    }

    public static String removeSpacesAndLowerCase(String data) {
        StringBuilder result = new StringBuilder();
        for (char i = 0; i < data.length(); i++) {
            if (data.charAt(i) != ' ') {
                result.append(lowerCase(data.charAt(i)));
            }
        }
        return result.toString();
    }

    public static void validateStringArr(int arrLen) {
        if (arrLen > 100) {
            throw new RuntimeException("String array size must be max 100");
        }
    }

    public static void validateString(String s) {
        if (s.length() > 50) {
            throw new RuntimeException("String length must be max 50");
        }
    }
}
