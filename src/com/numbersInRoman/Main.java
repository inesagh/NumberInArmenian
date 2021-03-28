package com.numbersInRoman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<Integer, String> hashMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static Integer enteredNumber = 0;

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter a number between 1 and 3999: ");
            enteredNumber = scanner.nextInt();
            if (enteredNumber > 0 && enteredNumber <= 3999) {
                quit = true;
            }
        }

        hashMap.put(1, "I");
        hashMap.put(2, "II");
        hashMap.put(3, "III");
        hashMap.put(4, "IV");
        hashMap.put(5, "V");
        hashMap.put(6, "VI");
        hashMap.put(7, "VII");
        hashMap.put(8, "VIII");
        hashMap.put(9, "IX");
        hashMap.put(10, "X");
        hashMap.put(20, "XX");
        hashMap.put(30, "XXX");
        hashMap.put(40, "XL");
        hashMap.put(50, "L");
        hashMap.put(60, "LX");
        hashMap.put(70, "LXX");
        hashMap.put(80, "LXXX");
        hashMap.put(90, "XC");
        hashMap.put(100, "C");
        hashMap.put(200, "CC");
        hashMap.put(300, "CCC");
        hashMap.put(400, "CD");
        hashMap.put(500, "D");
        hashMap.put(600, "DC");
        hashMap.put(700, "DCC");
        hashMap.put(800, "DCCC");
        hashMap.put(900, "CM");
        hashMap.put(1000, "M");
        hashMap.put(2000, "MM");
        hashMap.put(3000, "MMM");

        numbersInRoman(enteredNumber);
    }

    public static void numbersInRoman(Integer number) {
        String numberInString = number.toString();
        ArrayList<String> finalStringInList = new ArrayList<>();
        for (int i = numberInString.length() - 1; i >= 0; i--) {
            int oneChar = Integer.parseInt(String.valueOf(numberInString.charAt(i)));
            String position = findPosition(numberInString.length() - 1 - i);

            if (oneChar != 0) {
                if (position.equals("տասնյակ")) {
                    oneChar = Integer.parseInt(String.valueOf(numberInString.charAt(i)) + "0");
                    for (Integer integer : hashMap.keySet()) {
                        if (oneChar == integer) {
                            finalStringInList.add(0, hashMap.get(integer));
                        }
                    }
                }else if (position.equals("հարյուր")) {
                    oneChar = Integer.parseInt(String.valueOf(numberInString.charAt(i)) + "00");
                    for (Integer integer : hashMap.keySet()) {
                        if (oneChar == integer) {
                            finalStringInList.add(0, hashMap.get(integer));
                        }
                    }
                }else if (position.equals("հազար")) {
                    oneChar = Integer.parseInt(String.valueOf(numberInString.charAt(i)) + "000");
                    for (Integer integer : hashMap.keySet()) {
                        if (oneChar == integer) {
                            finalStringInList.add(0, hashMap.get(integer));
                        }
                    }
                }


                else{
                    for (int i1 = 0; i1 < hashMap.keySet().size(); i1++) {
                        if(oneChar == i1){
                            finalStringInList.add(0, hashMap.get(i1));
                        }
                    }
                }
            }

        }

        printNumberInArmenian(finalStringInList);
    }


    public static String findPosition(int i) {
        String position = "";
        switch (i) {
            case 1:
            case 4:
            case 7:
                position = "տասնյակ";
                break;
            case 2:
            case 5:
            case 8:
                position = "հարյուր";
                break;
            case 3:
                position = "հազար";
                break;
            case 6:
                position = "միլիոն";
                break;
            case 9:
                position = "միլիարդ";
                break;

        }
        return position;
    }

    public static void printNumberInArmenian(ArrayList<String> arrayList) {
        String finalString = "";

        for (int i = 0; i < arrayList.size(); i++) {
            finalString += arrayList.get(i);
        }
        System.out.println(finalString);
    }
}
