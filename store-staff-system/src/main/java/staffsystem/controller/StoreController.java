
package staffsystem.controller;

import staffsystem.view.MenuOption;
import staffsystem.view.SystemView;


public class StoreController {
    
    SystemView view;
    
    public StoreController(SystemView view){
        this.view = view;
    }
    
    public void run(){
        view.displayWelcome();
        while(true){
            view.displayMenu();
            
            MenuOption userChoice = view.userChoice();
            
            switch(userChoice){
                case Sort_Names: System.out.println("Sorting available here later \n \n"); break;
                case FIND_EMPLOYEE: System.out.println("Finding employee available here later \n \n");break;
                case ADD_EMPLOYEE: System.out.println("Adding employee available here later \n \n");break;
                case BUILD_HIERARCHY: System.out.println("\bHierarchy available here later\b \n \n");break;
                case QUIT: {System.out.println("available here later");
                            return;
                }
                
            }
        }
    }
    
}
