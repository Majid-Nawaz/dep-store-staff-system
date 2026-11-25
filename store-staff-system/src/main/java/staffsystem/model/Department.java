
package staffsystem.model;

public enum Department {
   
    WOMENSWEAR("Womenswear"),
    MENSWEAR("Menswear"),
    KIDSWEAR("Kidswear"),
    BEAUTY("Beauty"),
    ELECTRONICS("Electronics"),
    HOME_AND_FURNITURE("Home & Furniture"),
    FOOD_HALL("Food Hall"),
    CUSTOMER_SERVICE("Customer Service"),
    HR("HR"),
    FINANCE("Finance"),
    OPERATIONS("Operations");
    
    private final String departmentLabel;
    
    Department(String label){
        this.departmentLabel = label;
    }
    
    public String getDepartmentLabel(){
        return departmentLabel;
    }
    
    
    //for finding a department wether it exists in enum constants or not
    public Department fromDepartment(String depName){
        if(depName==null){
            return null;
        }
        for(Department department : values()){
            if(depName == department.departmentLabel){
                return department;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return departmentLabel;
    }
}
