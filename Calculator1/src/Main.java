import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your expression:");
        System.out.println(calc(scan.nextLine()));
    }
    public static String calc (String input) throws Exception {

        int number1, number2;
        String operation;
        String result;
        boolean isRoman;

        String[] operands = input.split("[+\\-*/]");
        operation = detectOperation(input);

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

