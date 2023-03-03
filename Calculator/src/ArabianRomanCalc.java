import java.util.Scanner;

public class ArabianRomanCalc {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter expression:");
        String expression = scan.nextLine();
        System.out.println(calc(expression));

    }

        public static String calc (String expression) throws Exception {

            int number1, number2;
            String operation;
            String result;
            boolean isRoman;

            String[] operands = expression.split("[+\\-*/]");
            operation = detectOperation(expression);

            if (operation == null)
                throw new Exception("Enter arithmetic sign");

            if (operands.length != 2)
                throw new Exception("Enter only two numbers");

            if (RomanNumbers.isRoman(operands[0]) && RomanNumbers.isRoman(operands[1])) {
                number1 = RomanNumbers.converterToArab(operands[0]);
                number2 = RomanNumbers.converterToArab(operands[1]);
                isRoman = true;
            }

            else if (!RomanNumbers.isRoman(operands[0]) && !RomanNumbers.isRoman(operands[1])) {
                number1 = Integer.parseInt(operands[0]);
                number2 = Integer.parseInt(operands[1]);
                isRoman = false;
            }

            else {
                throw new Exception("The numbers must have the same format");
            }

            if (number1 > 10 || number2 > 10) {
                throw new Exception("The numbers must be between 1 and 10");
            }

            int arabian = calculation(number1, number2, operation);

            if (isRoman) {
                if (arabian <= 0) {
                    throw new Exception("The roman number must be above 0");
                }
                result = RomanNumbers.converterToRoman(arabian);
            }

            else {
                result = String.valueOf(arabian);
            }

            return result;
        }

        static String detectOperation (String expression){

            if (expression.contains("+")) return "+";
            else if (expression.contains("-")) return "-";
            else if (expression.contains("*")) return "*";
            else if (expression.contains("/")) return "/";
            else return null;

        }

        static int calculation (int a, int b, String operation){

            if (operation.equals("+")) return a + b;
            else if (operation.equals("-")) return a - b;
            else if (operation.equals("*")) return a * b;
            else return a / b;
        }



}

class RomanNumbers {

    static String[] romanNumbersArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    static boolean isRoman (String value) {

        for (int i = 0; i < romanNumbersArray.length; i++) {
            if (value.equals(romanNumbersArray[i])) {
                return true;
            }
        }
        return false;
    }

    static int converterToArab (String roman) {

        for (int i = 0; i < romanNumbersArray.length; i++) {
            if (roman.equals(romanNumbersArray[i])){
                return i;
            }
        }
        return -1;
    }

    static String converterToRoman (int arabian) {

        return romanNumbersArray[arabian];
    }
}




