
package staffsystem.controller;

import java.io.IOException;
import java.util.List;
import staffsystem.model.Employee;
import staffsystem.model.StaffFileReader;
import staffsystem.model.StaffList;
import staffsystem.view.MenuOption;
import staffsystem.view.SystemView;


public class StoreController {
    
    SystemView view;
    StaffList allStaffList;
    StaffFileReader reader;
    
    public StoreController(SystemView view, StaffFileReader fileReader, StaffList staffList){
        this.view = view;
        this.reader = fileReader;
        this.allStaffList = staffList;
    }
    
    public void run(){
        view.displayWelcome();
        while(true){
            loadAllStaff();
            view.displayMenu();
            
            MenuOption userChoice = view.userChoice();
            
            switch(userChoice){
                case SORT_NAMES: System.out.println("Sorting available here later \n \n"); break;
                case FIND_EMPLOYEE: System.out.println("Finding employee available here later \n \n");break;
                case ADD_EMPLOYEE: System.out.println("Adding employee available here later \n \n");break;
                case BUILD_HIERARCHY: System.out.println("Hierarchy available here later\n \n");break;
                case QUIT: {System.out.println("See You Next Time");
                            return;
                }
                
            }
        }
    }
    
    private void loadAllStaff(){
        String fileName = view.askFileName();
        
        List<Employee> staffListFromReader = reader.readAndAddEmployees(fileName);
        
        allStaffList.addAllEmployeesToList(staffListFromReader);
        
    }
    
}
