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
public class AdminMode {
    protected static boolean added ;
    private static String slots[] = {"2:00 Pm" , "3:00 Pm" , "4:00 Pm" , "5:00 Pm" , "6:00 Pm" , "7:00 Pm" , "8:00 Pm" , "9:00 Pm"} ;
    private static boolean reserved[] = new boolean[8] ;
    private static ArrayList<Integer> reservedSlot = new ArrayList<Integer>(101) ;
    private static ArrayList<Integer>Ids = new ArrayList<>(Arrays.asList(3652 , 6597 , 5214)) ;
    private static ArrayList<String> PatientName = new ArrayList<>() ;
    private static ArrayList<Boolean> Patientresevre = new ArrayList<>() ;
    private static ArrayList<Integer> Age = new ArrayList<>();
    private static ArrayList<String> PatientG = new ArrayList<>();
    protected static ArrayList<Integer> PatientId = new ArrayList<>();
    
    public static void startAdmin()
    {
//        int n = 0 ;
        Scanner in = new Scanner(System.in) ;
        System.out.println("--------------------------------------------------");
        verfication();
        while(true)
        {
//            n++ ;
        switch (getChoice()) {
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
        if(validAdminId(id) && validAddminPass(pass)) 
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
    
    private static boolean validAdminId(int id)
    {
        return Ids.contains(id) ;
    }
    
    private static boolean validAddminPass(int pass)
    {
        return pass == 1234 ;
    }
    
    private static boolean existPatID(int id)
    {
        return PatientId.contains(id) ;
    }
    private static int getChoice()
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

    
    private static void AddNewPatient()
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
        if(id > 9999) throw new NumberFormatException() ;}
        catch(Exception e)
        {
            System.out.println("Invalid patient ID *PATIENT ID MUST CONTAIN ONLY FOUR DIGITS* ..!") ;
            System.out.println("Enter the patient record again please...");
            input.nextLine();
            continue;
        }
        break ;
        }
        if(c > 3) { System.out.println("You entered invalid data more than 3 times , your session killed.....");
                System.out.println("--------------------------------------------------");
            return;}
        else
        {
            reservedSlot.add(-1);
            added = true ;
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
        if(!added) {System.out.println("No patient added currently..!"); return;}
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
    
    private static void EditPatientRec()
    {
        if(!added) {System.out.println("No patient added currently..!"); return;}
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
//            try{
//                System.out.print("Edit the patient Id");
//                id = input.nextInt() ;
//                if(id > 9999) throw new NumberFormatException() ;}
//            catch(Exception e)
//                {
//                System.out.println("Invalid patient ID *PATIENT ID MUST CONTAIN ONLY FOUR DIGITS* ..!") ;
//                System.out.println("Enter the patient record again please...");
//                input.nextLine() ;
//                continue;
//                }
                }
                if(c >= 3) { System.out.println("You entered invalid data 3 times , your session killed.....");
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
    
    private static void printAvaliableSlots()
    {
        System.out.println("--------------------------------------------------");
        System.out.println("The avaliable slots today are : ");
        for(int i = 0 ; i < slots.length ; i++)
        {
            if(!reserved[i])
                System.out.println("Slot at " + slots[i] + " is avaliable now - > " + (i+1)) ; 
        }
    }
            
   
    private static void reverseSlot()
    {
        if(!added) {System.out.println("No patient added currently..!"); return;}
        int n , search , index , c = 0 ;
        Scanner input = new Scanner(System.in) ;
        while(c <= 3)
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
    System.out.println("You entered invalid data 3 times , your session killed.....") ;
    }
    
    static boolean avaliableSlot(int n)
    {
        n--;
        if(n<0 || n>=8) return false ;
        else if(reserved[n]) return false;
        else return true ;
    }
            


 private static void CancelReserv()
{
if(!added) {System.out.println("No patient added currently..!"); return;}
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
}