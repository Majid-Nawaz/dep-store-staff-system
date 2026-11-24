
package staffsystem.view;

import java.util.Scanner;


public class SystemView {
    
    public void displayWelcome(){
        System.out.println("========Northgate Department Store -  Staff Hub=======\n");
        
    }
    
    public void displayMenu(){
        System.out.println("What would you like to do this time?");
        for(MenuOption option : MenuOption.values()){
            System.out.println(" "+ option.getOptionNumber() + " "+ option.getOptionValue()+"\n");
        }
        
    }
    public MenuOption userChoice(){
        System.out.println("Enter a number of your choice from menu: ");
        Scanner scanner = new Scanner(System.in);
        
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
                System.out.println("Invalid input. Please enter a number\n \n See the exception message: \n"+ e.getMessage());
            }
        }
        
        
    }
    
    
}
