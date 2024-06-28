/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.managmentsystem;
import java.util.* ;
/**
 *
 * @author sigma
 */
public class ClinicLife {
     public static void chooseMode()
    {
        Scanner input = new Scanner(System.in) ; 
        System.out.println("--------------WELCOME TO LIFE CLINIC--------------");
        System.out.println("--------------------------------------------------");
        while(true)
        {System.out.println("1 -> Admin mode");
        System.out.println("2 -> User mode");
        System.out.println("3 -> Exit");
        System.out.print("Enter your mode : ");
        switch (input.nextInt()) {
            case 1:
                AdminMode.startAdmin();
                break;
            case 2 :
                UserMode.startUser();
                break;
            case 3 :
                System.exit(0 );
            default:
                System.out.println("Invalid choice...!");
                
        }}
        
    }
}
