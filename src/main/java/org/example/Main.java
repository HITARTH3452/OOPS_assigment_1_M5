package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static ArrayList subarray(int[] arr){
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        al.add(arr[i]);
                        al.add(arr[j]);
                        al.add(arr[k]);
                        return al;
                    }
                }
            }
        }
        return al;
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];

      int i = 0;

      while(i<n){
          arr[i] = sc.nextInt();
          if(arr[i] == 0){
              System.out.println("please provide valid input");
             return;
          }else{
              i++;
          }
      }

      ArrayList new_arr = subarray(arr);


      if(new_arr.size() == 0){
          System.out.println("No Elements found");
      }else{
          System.out.println(new_arr);
      }

        }
    }
