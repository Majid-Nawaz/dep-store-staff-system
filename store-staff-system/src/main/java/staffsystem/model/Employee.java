
package staffsystem.model;

/*
   a member of staff in the store
   only for the details that the program actually needs
*/
public class Employee {
    
    private String name;
    private Department department;
    private ManagerType position;
    
    public Employee(String name, Department department, ManagerType position){
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid input for name");
        }
        if(department==null){
            throw new IllegalArgumentException("Invalid input for department");
        }
        if(position==null){
            throw new IllegalArgumentException("Invalid input for position");
        }
        
        this.name= name.trim().replaceAll("\\s+", " ");
        this.department=department;
        this.position = position;
    }
    
    public String getEmployeeName(){
        return name;
    }
    public Department getEmployeeDepartment(){
        return department;
    }
    public ManagerType getEmployeePosition(){
        return position;
    }
    
    @Override
    
    public String toString(){
        return name + " | "+position + "| "+ department;
    } 
    
    
    
}
