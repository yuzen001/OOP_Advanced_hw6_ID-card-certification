package com.example.lib;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        char IDcardBeginning[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'X', 'Y', 'W', 'Z', 'I', 'O'};
        char BeginningIDN[] = {'0', '0'};
        int DetectionNumber = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入身分證字號:");
        String IDNumber = scanner.next();
        char[] IDNumberIndividual = new char[11];
        if (IDNumber.length() > 10 || IDNumber.length() < 10) {
            System.out.println("身分證字號數錯誤");
        } else {
            IDNumberIndividual[0] = IDNumber.charAt(0);
            for (int i = 2; i < 11; i++) {
                IDNumberIndividual[i] = IDNumber.charAt(i - 1);
            }
            for (int i = 0; i < 26; i++) {
                if (IDNumberIndividual[0] == IDcardBeginning[i]) {
                    IDNumberIndividual[0] = String.valueOf(1 + (i / 10)).charAt(0);
                    IDNumberIndividual[1] = String.valueOf((i % 10)).charAt(0);
                }
            }

            for (int i = 0; i < 11; i++) {
                if (i == 0 || i == 10) {
                    DetectionNumber += Integer.parseInt(String.valueOf(IDNumberIndividual[i]));
                } else {
                    DetectionNumber += (10 - i) * Integer.parseInt(String.valueOf(IDNumberIndividual[i]));
                }
            }
            if (DetectionNumber % 10 == 0) {
                System.out.println("正確的身分證號");
            }
            else {
                System.out.println("不正確的身分證號");
            }
        }
    }
}