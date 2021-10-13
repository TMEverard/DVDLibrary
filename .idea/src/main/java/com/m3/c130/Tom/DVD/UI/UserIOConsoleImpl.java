package com.m3.c130.Tom.DVD.UI;

import com.m3.c130.Tom.DVD.UI.UserIO;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    Scanner sc = new Scanner(System.in);
    public void print(String str){
        System.out.println(str);
    }
    public String readString(String prompt){
        System.out.println(prompt);
        Scanner sca = new Scanner(System.in);
        String stringInput = sca.nextLine();
        return stringInput;
    }
    public int readInt(String prompt){
        System.out.println(prompt);
        int intInput = sc.nextInt();
        return intInput;
    }

    public int readInt(String prompt, int min, int max){
        boolean condition = true;
        int intInput = 0;
        do {
            System.out.println(prompt);
            intInput = sc.nextInt();
            if(intInput<=max && intInput>=min){
                condition = false;
            }
        } while(condition);
        System.out.println(intInput);
        return intInput;
    }
    public double readDouble(String prompt){
        System.out.println(prompt);
        double doubleInput = sc.nextInt();
        return doubleInput;
    }

    public double readDouble(String prompt, double min, double max){
        boolean condition = true;
        double doubleInput = 0.0;
        do {
            System.out.println(prompt);
            doubleInput = sc.nextInt();
            if(doubleInput<=max && doubleInput>=min){
                condition = false;
            }
        } while(condition);
        System.out.println(doubleInput);
        return doubleInput;
    }
    public float readFloat(String prompt){
        System.out.println(prompt);
        float floatInput = sc.nextInt();
        return floatInput;
    }

    public float readFloat(String prompt, float min, float max){
        boolean condition = true;
        float floatInput = 0.0f;
        do {
            System.out.println(prompt);
            floatInput = sc.nextInt();
            if(floatInput<=max && floatInput>=min){
                condition = false;
            }
        } while(condition);
        System.out.println(floatInput);
        return floatInput;
    }
    public long readLong(String prompt){
        System.out.println(prompt);
        long longInput = sc.nextInt();
        return longInput;
    }

    public long readLong(String prompt, long min, long max){
        boolean condition = true;
        long longInput = 0;
        do {
            System.out.println(prompt);
            longInput = sc.nextInt();
            if(longInput<=max && longInput>=min){
                condition = false;
            }
        } while(condition);
        System.out.println(longInput);
        return longInput;
    }
}