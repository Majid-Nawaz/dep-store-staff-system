
package staffsystem.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import staffsystem.model.Employee;
import staffsystem.model.StaffFileReader;
import staffsystem.model.StaffList;
import staffsystem.view.MenuOption;
import staffsystem.view.SystemView;


public class StoreController {
    
    private final SystemView view;
    private final StaffList allStaffList;
    private final StaffFileReader reader;
    
    public StoreController(SystemView view, StaffFileReader fileReader, StaffList staffList){
        this.view = view;
        this.reader = fileReader;
        this.allStaffList = staffList;
    }
    
    
    public void run(){
        view.displayWelcome();
        loadAllStaff();
        while(true){
            
            view.displayMenu();
            
            MenuOption userChoice = view.userChoice();
            
            switch(userChoice){
                case SORT_NAMES: view.displayMessage("Sorting available here later \n \n"); break;
                case FIND_EMPLOYEE: view.displayMessage("Finding employee available here later \n \n");break;
                case ADD_EMPLOYEE: view.displayMessage("Adding employee available here later \n \n");break;
                case BUILD_HIERARCHY: view.displayMessage("Hierarchy available here later\n \n");break;
                case QUIT: {view.displayMessage("See You Next Time");
                            return;
                }
                
            }
        }
    }
    
    private void loadAllStaff(){
        while(true){
            String fileName = view.askFileName();
            if(fileName.trim().isEmpty()){
                view.displayMessage("The file name can't be empty.");
                continue;
            }
        
        try{
            List<Employee> staffListFromReader = reader.readAndAddEmployees(fileName);
            int skippedRows = reader.getSkippedRows();
            if(staffListFromReader.isEmpty()){
                view.displayMessage("'" + fileName + "' has no valid staff records. Try another file.");
                continue;
            } 
            allStaffList.addAllEmployeesToList(staffListFromReader);
            
            String records = allStaffList.staffListSize() == 1 ? " staff record" : " staff records";
            
            view.displayMessage(allStaffList.staffListSize() + records + " loaded from " + fileName + ".");

                if (skippedRows > 0) {                                       // only mention skipped rows if there were any
                    view.displayMessage(skippedRows + " row(s) skipped because of missing or invalid details.");
                }

            return; 
            
        }catch(FileNotFoundException e){
        
                view.displayMessage("No file called '" + fileName + "' was found. Check the name and try again.");

        }catch(IOException e){
            view.displayMessage("'" + fileName + "' couldn't be used: " + e.getMessage() + ".");

        }
        }
        
    }
    
}
