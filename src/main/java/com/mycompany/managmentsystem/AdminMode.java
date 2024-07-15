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
public class AdminMode extends PatientService {
    
    public static void startAdmin()
    {
//        int n = 0 ;
        Scanner in = new Scanner(System.in) ;
        System.out.println("--------------------------------------------------");
        verfication();
        while(true)
        {
//            n++ ;
        switch (AdminService.getChoice()) {
            case 1:
                AddNewPatient();
                break;
            case 2:
                EditPatientRec();
                break;
            case 3:
                reverseSlot();
                break;
            case 4:
                CancelReserv() ;
                break;
            case 5:
                try {
                    if(PatientService.noPatients()) {continue;}
                    System.out.println("--------------------------------------------------");
                System.out.println("Enter Patient ID : ");
                printPatient(PatientId.indexOf(in.nextInt())) ;
                } catch (Exception e) {
                    System.out.println("Invalid Id...!");
                    System.out.println("--------------------------------------------------");
                }
                break;
            case 6:
                return ;
            default:
                System.out.println("Invalid choice ...!");        }
        }
    }
    
    private static boolean verfication()
    {
        int id , pass , c = 0 ;
        try
        {while(c <= 3){ Scanner input = new Scanner(System.in) ;
        System.out.print("Enter your id : ");
        id = input.nextInt() ;
        System.out.print("Enter the password : ");
        pass = input.nextInt() ;
        if(AdminService.validAdminId(id) && AdminService.validAddminPass(pass)) 
        {
            System.out.println("ADMIN MODE ACCESSED.........");
            break ;
        }
        else 
        {c++ ;
            System.out.println("Invalid id or password...!");
            System.out.println("--------------------------------------------------");
        }
                    }
        if(c > 3) throw new InvalidAdminException() ; }
        catch(InvalidAdminException e)
        {
            System.out.println("You entered invalid data 3 times , your session killed.....");
            System.exit(0);
        }
        return  true ;
        
    }
}