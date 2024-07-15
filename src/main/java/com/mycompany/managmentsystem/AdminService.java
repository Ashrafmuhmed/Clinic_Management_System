/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.managmentsystem;
import java.util.*;
/**
 *
 * @author sigma
 */
public class AdminService extends DataBase {
    protected static boolean validAdminId(int id)
    {
        return Ids.contains(id) ;
    }
    
    protected static boolean validAddminPass(int pass)
    {
        return pass == 1234 ;
    }
    
    
    protected static int getChoice()
    {
        Scanner input = new Scanner(System.in) ;
        System.out.println("--------------------------------------------------");
        System.out.println("1 -> Add new patient record ");
        System.out.println("2 -> Edit patient record ");
        System.out.println("3 -> Reverse a slot with te doctor ");
        System.out.println("4 -> Cancel reservation");
        System.out.println("5 -> Display patient record");
        System.out.println("6 -> Exit Admin mode");
        System.out.println("--------------------------------------------------");
        System.out.print("Enter your choice please : ");
        return input.nextInt() ;
        
    }
}
