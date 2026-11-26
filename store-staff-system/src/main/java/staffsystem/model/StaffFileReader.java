
package staffsystem.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StaffFileReader {
    private static final String FIRST_NAME_COLUMN = "First name";
    private static final String LAST_NAME_COLUMN = "Last name";
    private static final String DEPARTMENT_COLUMN = "Department";
    private static final String MANAGER_TYPE_COLUMN = "Manager type";
    
    private int skippedRows;
    
    public List<Employee> readAndAddEmployees(String fileName) throws IOException{
        skippedRows = 0;
        List<Employee> staffList = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String headerLineInFile = reader.readLine();
            
            if(headerLineInFile==null){
                throw new  IOException("This file is empty");
            }
            
            String[] firstLineInFile = headerLineInFile.split(",", -1);
            
            int firstNameIndexInHeaderLine = findColumnsIndex(firstLineInFile, FIRST_NAME_COLUMN);
            int lastNameIndexInHeaderLine = findColumnsIndex(firstLineInFile, LAST_NAME_COLUMN);
            int departmentIndexInHeaderLine = findColumnsIndex(firstLineInFile, DEPARTMENT_COLUMN);
            int managerTypeIndexInHeaderLine = findColumnsIndex(firstLineInFile, MANAGER_TYPE_COLUMN);
            
            String line=reader.readLine();
            while(line != null){
                if(!line.trim().isEmpty()){
                try{
                String[] eachLineValues = line.split(",", -1);
                
                String name = eachLineValues[firstNameIndexInHeaderLine] + " " + eachLineValues[lastNameIndexInHeaderLine];
                
                String departmentInLine = eachLineValues[departmentIndexInHeaderLine];
                Department department = Department.fromDepartment(departmentInLine);
                
                String positionInLine = eachLineValues[managerTypeIndexInHeaderLine];
                ManagerType employeePosition = ManagerType.fromPosition(positionInLine);
                
                staffList.add(new Employee(name, department, employeePosition));
                
                
                }catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            
                skippedRows++;
        }
            }
            line=reader.readLine();
            
        }
    return staffList;
        }   
        
    }
    
    public int getSkippedRows(){
        return skippedRows;
    }
    
    private int findColumnsIndex(String[] headersArray, String columnTitle) throws IOException{
        int index=0;
        for(int i=0; i<=headersArray.length-1; i++){
            if(headersArray[i].trim().equalsIgnoreCase(columnTitle)){
                index = i;
                return index;
            }
        }
        throw new IOException("the file has no '" + columnTitle + "' column");
    
    }
}
