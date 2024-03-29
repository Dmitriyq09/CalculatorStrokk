package CalculatorStrok;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String str = scanner.nextLine();
        char action;
        String[] data;
        extracted(str);
    }

    private static void extracted(String str) throws Exception {
        char action;
        String[] data;
        if (str.contains(" + ")) {
            data = str.split(" \\+ ");
            action = '+';
        } else if (str.contains(" - ")) {
            data = str.split(" - ");
            action = '-';
        } else if (str.contains(" * ")) {
            data = str.split(" \\* ");
            action = '*';
        } else if (str.contains("/")) {
            data = str.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия.");
        }
        if (action == '*' || action == '/'){
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число.");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            printInQuotes(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printInQuotes(result);
            }
        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, newLen);
            printInQuotes(result);
        }
    }

    static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
        if (text.length()>40){
            System.out.println("\""+text.substring(0,40)+"..."+"\"");
        }
    }
}
