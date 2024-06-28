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
public class UserMode extends AdminMode {
    public static void  startUser()
    {
        System.out.println("--------------------------------------------------");
        System.out.println("---------USER MODE ACCESSED-----------------------");
        Scanner in = new Scanner(System.in) ;
        System.out.println("--------------------------------------------------");
        while(true)
        {
//            n++ ;
        switch (getchoice()) {
            case 1:
                if(!added) {System.out.println("No patient added currently..!"); continue;}
                try {
                    System.out.println("--------------------------------------------------");
                System.out.println("Enter Patient ID : ");
                printPatient(PatientId.indexOf(in.nextInt())) ;
                } catch (Exception e) {
                    System.out.println("Invalid Id...!");
                    System.out.println("--------------------------------------------------");
                }
                break;
            case 2:
                displayReser();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice ...!");        }
        System.out.println("--------------------------------------------------");
        }
    }
    
    
    private static int getchoice()
    {
        int n ;  Scanner in = new Scanner(System.in) ;
        System.out.println("1 -> Display patient record ");
        System.out.println("2 -> View avaliable slots today ");
        System.out.println("3 -> Exit user mode ");
        System.out.println("--------------------------------------------------");
        System.out.print("Choose your choice : "); n = in.nextInt() ;
        return n ;
    }
}
