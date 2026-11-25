
package staffsystem.view;

public enum MenuOption {
    SORT_NAMES(1, "Sort staff names (A-Z)"),
    FIND_EMPLOYEE(2, "Find an employee"),
    ADD_EMPLOYEE(3, "Add a new employee"),
    BUILD_HIERARCHY(4, "Build the staff hierarchy tree"),
    QUIT(5, "Quit");
    
    private final int number;
    private final String value;
    
    MenuOption(int number, String value){
        this.number = number;
        this.value = value;
        
    }
    
    public int getOptionNumber(){
        return number;
    }
    public String getOptionValue(){
        return value;
    }
    
    
    public static MenuOption optionForInput(int number){
        for(MenuOption option : values()){
            if(number==option.getOptionNumber()){
                return option;
            }
            
        }
        return null;
    }
    
}
