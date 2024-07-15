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
public class DataBase {
    protected static String slots[] = {"2:00 Pm" , "3:00 Pm" , "4:00 Pm" , "5:00 Pm" , "6:00 Pm" , "7:00 Pm" , "8:00 Pm" , "9:00 Pm"} ;
    protected static boolean reserved[] = new boolean[8] ;
    protected static ArrayList<Integer> reservedSlot = new ArrayList<Integer>(101) ;
    protected static ArrayList<Integer>Ids = new ArrayList<>(Arrays.asList(3652 , 6597 , 5214)) ;
    protected static ArrayList<String> PatientName = new ArrayList<>() ;
    protected static ArrayList<Boolean> Patientresevre = new ArrayList<>() ;
    protected static ArrayList<Integer> Age = new ArrayList<>();
    protected static ArrayList<String> PatientG = new ArrayList<>();
    protected static ArrayList<Integer> PatientId = new ArrayList<>();
}
