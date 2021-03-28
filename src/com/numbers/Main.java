package com.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    static HashMap<Integer, String> hashMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static Long enteredNumber = 0L;
    public static void main(String[] args) {

        boolean quit = false;
        while(!quit){
            System.out.println("Enter a number between 0 and 9999999999: ");
            enteredNumber = scanner.nextLong();
            if(enteredNumber >= 0 && enteredNumber <= 9999999999L){
                quit = true;
            }
        }

        hashMap.put(0, "զրո");
        hashMap.put(1, "մեկ");
        hashMap.put(2, "երկու");
        hashMap.put(3, "երեք");
        hashMap.put(4, "չորս");
        hashMap.put(5, "հինգ");
        hashMap.put(6, "վեց");
        hashMap.put(7, "յոթ");
        hashMap.put(8, "ութ");
        hashMap.put(9, "ինը");
        hashMap.put(10, "տասն");
        hashMap.put(20, "քսան");
        hashMap.put(30, "երեսուն");
        hashMap.put(40, "քառասուն");
        hashMap.put(50, "հիթսուն");
        hashMap.put(60, "վաթսուն");
        hashMap.put(70, "յոթանասուն");
        hashMap.put(80, "ութսուն");
        hashMap.put(90, "իննսուն");

        numberInArmenian(enteredNumber);

    }

    public static void numberInArmenian(Long number) {
        String numberInString = number.toString();
        ArrayList<String> finalStringInList = new ArrayList<>();

        for (int i = numberInString.length() - 1; i >= 0; i--) {
            int oneChar = Integer.parseInt(String.valueOf(numberInString.charAt(i)));
            String position = findPosition(numberInString.length() - 1 - i);

            if(position.equals("միլիոն")){
                int one = Integer.parseInt(String.valueOf(numberInString.charAt(i + 1)));
                int second = Integer.parseInt(String.valueOf(numberInString.charAt(i + 2)));
                int third = Integer.parseInt(String.valueOf(numberInString.charAt(i + 3)));

                if(one == 0 && second == 0 && third == 0){
                    finalStringInList.remove("հազար");

                }
            }
            if(position.equals("միլիարդ")){
                int one = Integer.parseInt(String.valueOf(numberInString.charAt(i + 1)));
                int second = Integer.parseInt(String.valueOf(numberInString.charAt(i + 2)));
                int third = Integer.parseInt(String.valueOf(numberInString.charAt(i + 3)));

                if(one == 0 && second == 0 && third == 0){
                    finalStringInList.remove("միլիոն");

                }
            }


            if (oneChar != 0) {
                if (position.equals("տասնյակ")) {
                    oneChar = Integer.parseInt(String.valueOf(numberInString.charAt(i)) + "0");
                    for (Integer integer : hashMap.keySet()) {
                        if (oneChar == integer) {
                            finalStringInList.add(0, hashMap.get(integer));
                        }
                    }

                } else {
                    finalStringInList.add(0, " ");
                    finalStringInList.add(0, position);
                    if(!((oneChar == 1 && position.equals("հարյուր")) || (i == 0 && position.equals("հազար")))){
                        for (int i1 = 0; i1 < hashMap.keySet().size(); i1++) {
                            if(oneChar == i1){
                                finalStringInList.add(0, " ");
                                finalStringInList.add(0, hashMap.get(i1));

                            }
                        }
                    }
                }

            }
            else {
                if (position.equals("հազար") || position.equals("միլիոն")) {
                    finalStringInList.add(0, " ");
                    finalStringInList.add(0, position);
                    finalStringInList.add(0, " ");

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
    public static void printNumberInArmenian(ArrayList<String> arrayList){
        String finalString = "";

        for (int i = 0; i < arrayList.size(); i++) {
            finalString += arrayList.get(i);
        }
        System.out.println(finalString);
    }


}
