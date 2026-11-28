
package staffsystem.view;

import java.util.List;
import java.util.Scanner;
import staffsystem.model.Employee;


public class SystemView {
    
    private final Scanner scanner = new Scanner(System.in);
    public void displayWelcome(){
        System.out.println("========Northgate Department Store -  Staff Hub=======\n");
        
    }
    
    public void displayMenu(){
        System.out.println("What would you like to do this time?");
        for(MenuOption option : MenuOption.values()){
            System.out.println(" "+ option.getOptionNumber() + " "+ option.getOptionValue());
        }
        
    }
    public MenuOption userChoice(){
        System.out.println("Enter a number of your choice from menu: ");
        
        
        while(true){
            String userInput = scanner.nextLine();
            try{
            int number = Integer.parseInt(userInput);
            MenuOption choice = MenuOption.optionForInput(number);
            
            if(choice != null){
                return choice;
            }else{
                    System.out.println("Invalid Input. Please select a number from "+ MenuOption.values()[0].getOptionNumber() +" to "+ MenuOption.values()[MenuOption.values().length-1].getOptionNumber());
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a number\n");
            }
        }
        
        
    }
    public String askFileName(){
        System.out.println("Enter a valid file name:");
        String fileName = scanner.nextLine();
        return fileName;
    }
    
    public void displayMessage(String message){
        System.out.println(message);
    }
    public void displayList(List<Employee> staffList){
        for(Employee staff: staffList){
            System.out.println(staff.getEmployeeName()+ " | "+ staff.getEmployeeDepartment()+" | "+ staff.getEmployeePosition());
        }
        
    }
    public String askUserName() {                      
         System.out.println("Enter a user name to search with binary searcher");                           // print (not println) so the user types on the same line
        return scanner.nextLine().trim();                    // read the typed line with the ONE shared Scanner, remove outer spaces, give it back
    }
    public void displayBinarySearchedMember(Employee staffMember){
        if(staffMember==null){
            System.out.println(staffMember+" doesnot exist.");
        }
        System.out.println(staffMember.getEmployeeName()+ " | "+ staffMember.getEmployeeDepartment()+" | "+ staffMember.getEmployeePosition());
    }
    
    
    
    
    
}
