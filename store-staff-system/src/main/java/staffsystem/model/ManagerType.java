
package staffsystem.model;

public enum ManagerType {
    
    STORE_MANAGER("Store Manager"),
    SENIOR_MANAGER("Senior Manager"),
    DEPARTMENT_MANAGER("Department Manager"),
    ASSISTANT_MANAGER("Assistant Manager"),
    TEAM_LEAD("Team Lead"),
    STAFF("Staff");
    
    private final String positionTitle;
    
    ManagerType(String positionText){
        this.positionTitle = positionText;
    }
    
    public String getPosition(){
        return positionTitle;
    }
    
    //method to find if a position exists in enum
    public static ManagerType fromPosition(String positionText){
        if(positionText==null){
            return null;
        }
        String positionInput = positionText.trim().replaceAll("\\s+", " ");
        for(ManagerType availablePosition: values()){
            if(availablePosition.positionTitle.equalsIgnoreCase(positionInput)){
                return availablePosition;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return positionTitle;
    }
}
