package CalculatorTest;

import java.util.Scanner;

public class CalculatorD {
    public static void main(String[] args) {
        ConverterR rim = new ConverterR();
        String [] st1 = {"+","-","*","/"};
        String [] st2 = {"\\+","-","\\*","/"};
        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите вырожение:");
        String string = scaner.nextLine();
        int actionsIndex = -1;
        for (int i = 0; i< st1.length; i++){
             if(string.contains(st1[i])) {
                 actionsIndex = i;
                 break;
             }
        }
        if (actionsIndex==-1){
            System.out.println("Некорректное выражение.");
            return;
        }
        String[]data = string.split(st2[actionsIndex]);
        if(rim.isRim(data[0]) == rim.isRim(data[1])) {
            int a, b;
            boolean isRim = rim.isRim(data[0]);
            if (isRim) {
                a = rim.rimToInt(data[0]);
                b = rim.rimToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (st1[actionsIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRim) {
                System.out.println(rim.intToRim(result));
        }else {
                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате.");
        }

    }
}
