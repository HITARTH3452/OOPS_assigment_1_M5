package org.example.OOPS_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CarService service = new CarService();

        System.out.println("Enter you car Type : ");
//        You can choose any from these 1.Hatchback , 2.Sedan, 3.SUV.
        String carType = sc.next();


        List<String> Codes = new ArrayList<>();
        System.out.println("Enter total codes you want to proceed with");
        int totalCodes = sc.nextInt();

        System.out.println("Enter service code that you want");
        int i = 0;
        while(i<totalCodes){
//            You can choose these only BS01 , EF01 , CF01, BF01, GF01.
            Codes.add(sc.next());
            i++;
        }

        service.billGeneration(carType,Codes);
    }
}
