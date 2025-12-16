import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Roman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    /* PROBLEM: Convert digits into roman numerals
    Input: num = 3
    Output: III

    Input: num = 4
    Output: IV

    Input: num = 9
    Output: IX

    Input: num = 58
    Output: LVIII
    Explanation: L = 50, V = 5, III = 3.


    Input: num = 1994
    Output: MCMXCIV
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    CONVERSION RULES:
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
     */
    public static String intToRoman(int value) {
        TreeMap<Integer, String> conversionMap = new TreeMap<>();
        conversionMap.put(1, "I");
        conversionMap.put(4, "IV");
        conversionMap.put(5, "V");
        conversionMap.put(9, "IX");
        conversionMap.put(10, "X");
        conversionMap.put(40, "XL");
        conversionMap.put(50, "L");
        conversionMap.put(90, "XC");
        conversionMap.put(100, "C");
        conversionMap.put(400, "CD");
        conversionMap.put(500, "D");
        conversionMap.put(900, "CM");
        conversionMap.put(1000, "M");

        /*
        StringBuilder result = new StringBuilder();
        Iterator<Integer> iteratorKeys = conversionMap.keySet().iterator();

        while (iteratorKeys.hasNext()) {
            Integer currentKey = iteratorKeys.next();
            while (value >= currentKey) {
                result.append(conversionMap.get(currentKey));
                value -= currentKey;
            }
        }
         */

        /*
        for (int _i = 0; _i < Integer.toString(value).length(); _i++) {
            int digit = conversionMap.floorKey(value);

            if (value == digit) {
                result.append(conversionMap.get(value));
                value -= digit;
            }
        }

         */

        /*
        while (iteratorKeys.hasNext()) {
            Integer currentKey = iteratorKeys.next();
            System.out.println("current key: " + currentKey);
            System.out.println("current value: " + value);
            if (value == currentKey) {
                result.append(conversionMap.get(currentKey));
                value -= currentKey;
            }
        }

        return result.toString();
         */

        int character =  conversionMap.floorKey(value);
        if ( value == character ) { // final digit
            return conversionMap.get(value);
        }

        // repeat recursion minus last operated digit
        return conversionMap.get(character) + intToRoman(value-character);
    }
}