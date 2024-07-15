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
public class PatientService extends DataBase {
    protected static boolean noPatients()
    {
        if(PatientName.isEmpty()) 
        {
            System.out.println("No Patients added curenntly !!!");
            return true ;
        }
        return false ;
    }
    
    protected static void AddNewPatient()
    {   String name = "" , gender = "" ; int age = 0 , id = 0 , c = 0 ;
        Scanner input = new Scanner(System.in) ;
        System.out.println("--------------------------------------------------");
        System.out.println("------ADDING NEW PATIENT RECORED------------------");
        while(c <= 3)
        {    
            c++;
        System.out.println("--------------------------------------------------");
        System.out.print("Enter the patient's name : "); name = input.nextLine() ;if(!validName(name)) continue ;
        System.out.println("--------------------------------------------------");
        try{
            System.out.print("Enter the patient's age : ");
            age = input.nextInt() ;
            if(age >=110) throw new NumberFormatException() ;
            }
        catch(Exception e)
        {
            System.out.println("Invalid patient age ..!") ;
            System.out.println("Enter the patient record again please...");
            input.nextLine();
            continue;
        }
        System.out.println("--------------------------------------------------");
        System.out.print("Enter the patient gender : ");
        gender = input.next() ; if(!validGender(gender)) {input.nextLine(); continue;}
        System.out.println("--------------------------------------------------");
        try{
        System.out.print("Enter the patient Id : ");
        id = input.nextInt() ;
        if(id > 9999 || tokenId(id)) throw new NumberFormatException() ;}
        catch(Exception e)
        {
            System.out.println("Invalid patient ID  ..!") ;
            System.out.println("Enter the patient record again please...");
            input.nextLine();
            continue;
        }
        break ;
        }
        if(!continueSession(c)) {
                System.out.println("--------------------------------------------------");
            return;}
        else
        {
            reservedSlot.add(-1);
            Patientresevre.add(false);
            Age.add(age) ;
            PatientName.add(name);
            PatientId.add(id) ;
            PatientG.add(gender) ;
            System.out.println("--------------------------------------------------");
            System.out.println("----NEW PATIENT ADDED-----------------------------");
            printPatient(PatientId.indexOf(id)) ;
        }
    }
    
    
     protected static void printPatient(int index)
    {
        if(PatientService.noPatients()) {return;}
        System.out.printf(" %S's data : \n",PatientName.get(index));
        System.out.println("Age : " + Age.get(index));
        System.out.println("Gender : " + PatientG.get(index));
        System.out.println("ID : "+PatientId.get(index));
        try{
        if(reservedSlot.get(index) != 0) System.out.println("Reserved Slot "+ slots[reservedSlot.get(index)-1]);}
        catch(Exception e)
        {System.out.println("No reserved slots.....!");}
        System.out.println("--------------------------------------------------");
    }
     
     
     
     private static boolean validName(String name)
    {
        if(name.contains("0") ||name.contains("1") ||name.contains("2") ||name.contains("3") ||name.contains("4")
                || name.contains("5") || name.contains("6") || name.contains("7") || name.contains("8") || name.contains("9"))
        {System.out.println("Invalid patient name ..!") ;
        System.out.println("Enter the patient record again please..."); return false ;}
        else {
            return true ;
        }  
    }
     
        private static boolean validGender(String gen)
    {
        if(!gen.equalsIgnoreCase("male")  && !gen.equalsIgnoreCase("female"))
        {
            System.out.println("Invalid patient gender ..!") ;
        System.out.println("Enter the patient record again please..."); return false ;
        }
        return true ;
    }
        
        protected static void EditPatientRec()
    {
        if(PatientService.noPatients()) {return;}
        else
        {
        Scanner input = new Scanner(System.in) ; String name = "" , gender = "" ; int index = 0 , age = 0  , search = 0 , id = 0 , c = 0 ;
        while(c <= 3)
        {
             c++ ;
            try{

                System.out.println("--------------------------------------------------");
                System.out.print("Enter the patient ID : "); 
                search = input.nextInt() ;
                if(!existPatID(search)) throw new NumberFormatException() ;
                index = PatientId.indexOf(search);}
            catch(Exception e)
            {
                System.out.println("Invalid ID...");  
                continue;
            }
            printPatient(index) ;
                System.out.println("--------------------------------------------------");
                input.nextLine();
                           
                            System.out.println("--------------------------------------------------");
                System.out.print("Edit the patient's name : "); name = input.nextLine() ; if(!validName(name))  continue ;
                System.out.println("--------------------------------------------------");
            try{
                System.out.print("Edit the patient's age : ");
                age = input.nextInt() ;
                if(age >=110) throw new NumberFormatException() ;
                }
            catch(Exception e)
            {
                System.out.println("Invalid patient age ..!") ;
                System.out.println("Edit the patient record again please...");
                        input.nextLine();
                continue;
            }
            System.out.println("--------------------------------------------------");
            System.out.print("Edit the patient gender");
            gender = input.next() ; if(!validGender(gender)) {input.nextLine() ; continue;}
        System.out.println("--------------------------------------------------"); break ;
                }
                if(!continueSession(c)) {
                return;}
                else
                {
                    Age.set(index, age) ;
                    PatientName.set(index, name);
//                    PatientId.set(index, id) ;
                    PatientG.set(index, gender) ;
                    System.out.println("--------------------------------------------------");
                    System.out.println("----PATIENT DATA EDITED-----------------------------");
                    printPatient(PatientName.indexOf(name)) ;
                }
        } 
            }
        
        
        private static boolean existPatID(int id)
    {
        return PatientId.contains(id) ;
    }
    
    protected static void printAvaliableSlots()
    {
        System.out.println("--------------------------------------------------");
        System.out.println("The avaliable slots today are : ");
        for(int i = 0 ; i < slots.length ; i++)
        {
            if(!reserved[i])
                System.out.println("Slot at " + slots[i] + " is avaliable now - > " + (i+1)) ; 
        }
    }
            
   
    protected static void reverseSlot()
    {
        if(PatientService.noPatients()) {return;}
        int n , search , index , c = 0 ;
        Scanner input = new Scanner(System.in) ;
        while(continueSession(c))
        {c++;
        System.out.println("--------------------------------------------------");
        try
        {System.out.print("Enter the patient ID : "); 
                search = input.nextInt();
                if(!existPatID(search)) throw new NumberFormatException() ;
                index = PatientId.indexOf(search);}
            catch(Exception e)
            {
                System.out.println("Invalid ID...");   
                input.nextLine() ;
                continue;
            }
        System.out.println("--------------------------------------------------");
        try {
                    if(Patientresevre.get(index) == true)  throw new Exception() ;
                } catch (Exception e) {
                    System.out.println("The patient reserved slot " +slots[reservedSlot.get(index)-1] + " ....!");
                    return;
                }
        printAvaliableSlots();
        System.out.print("Enter the number of the slot you wnat to reserve : ");
        n = input.nextInt() ;
        if(avaliableSlot(n)) 
        {
            n-- ;
            reserved[n] = true ; 
            reservedSlot.set(index, n+1);
            Patientresevre.set(index, true) ;
            System.out.println("Slot reserved for " + PatientName.get(index) + " successfully..!");
            System.out.println("--------------------------------------------------");
            return;
        }
        else 
        {
            System.out.println("Invalid Slot..!");
            System.out.println("Enter valid number please....");
            input.nextLine() ;
            continue;
        }   
    }
    }
    
    static boolean avaliableSlot(int n)
    {
        n--;
        if(n<0 || n>=8) return false ;
        else if(reserved[n]) return false;
        else return true ;
    }
            


 protected static void CancelReserv()
{
if(PatientService.noPatients()) {return;}
        int n , search , index , c = 0 ;
        Scanner input = new Scanner(System.in) ;
        while(c <= 3)
        {c++;
        System.out.println("--------------------------------------------------");
        try
        {System.out.print("Enter the patient ID : "); 
                search = input.nextInt();
                if(!existPatID(search)) throw new NumberFormatException() ;
                index = PatientId.indexOf(search);
        if(Patientresevre.get(index) == false) 
        {
            System.out.println("The patient has no reservations...!");
            return;
        }}
            catch(Exception e)
            {
                System.out.println("Invalid ID...");   
                input.nextLine() ;
                continue;
            }
       
        reserved[reservedSlot.get(index)-1] = false ;
        Patientresevre.set(index, false);
        reservedSlot.set(index, null) ;
            System.out.println("The reservation for " + PatientName.get(index) + "is cancelled");
            return ;
}

}

        protected static void displayReser()
        {
            boolean is = false ;
            for(int i = 0 ; i < 8 ; i++)
            {
                if(!reserved[i]) {is = true ; System.out.println("Slot at "+ slots[i]);}
            }
            if(!is) System.out.println("Currently no reserved slots ...!");
        }
        
        protected static boolean continueSession(int c)
        {
             if(c > 3) { System.out.println("You entered invalid data more than 3 times , your session killed....."); return false ;}
             return true ;
        }
        
        protected static boolean tokenId(int id)
        {
            return DataBase.PatientId.contains(id );
        }
        
                
}
