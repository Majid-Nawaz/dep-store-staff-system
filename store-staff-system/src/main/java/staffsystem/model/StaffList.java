
package staffsystem.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StaffList {
    
    private List<Employee> allStaff = new ArrayList<>();
    
    public void addAllEmployeesToList(List<Employee> employeeList){
        allStaff.clear();
        allStaff.addAll(employeeList);
    }
    
    public List<Employee> getStaff(){
        return Collections.unmodifiableList(allStaff);
    }
    
    public int staffListSize(){
        return allStaff.size();
    }
}
