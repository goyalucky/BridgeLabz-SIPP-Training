package Assignments.JavaArrays.Level1;

import java.util.Scanner;

public class Vote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int arr[] = new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                System.out.println("Invalid age");
            }else if(arr[i]>18){
                System.out.println("Student with age"+ arr[i]+"can vote");
            } else if(arr[i]<18){
                System.out.println("Student with age"+ arr[i]+"cannot vote");
            }
        }
    }
}
