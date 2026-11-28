
package staffsystem.model;

import java.util.List;

public class BinarySearcher {
    private BinarySearcher() {
    }

    // Entry point the controller calls. Returns the matching StaffMember, or null if nobody has that name.
    public static Employee findByName(List<Employee> sortedStaff, String name) {   
        String target = name.trim();          
        return binarySearch(sortedStaff, target, 0, sortedStaff.size() - 1);   // search the whole list first
    }

    // Recursive part. si..ei = the part of the list still being searched.
    private static Employee binarySearch(List<Employee> list, String target, int si, int ei) {
        if (si > ei) {                                        // base case: range is empty -> target is not in the list
            return null;                                      
        }
        int mid = si + (ei - si) / 2;                         // middle index of si..ei

       int result = list.get(mid).getEmployeeName().compareToIgnoreCase(target);   

        if (result == 0) {
            return list.get(mid);                             // found: return the whole StaffMember
        } else if (result < 0) {
            return binarySearch(list, target, mid + 1, ei);   // keep the right half, skip mid
        } else {
            return binarySearch(list, target, si, mid - 1);   // keep the left half, skip mid
        }
    }
    
    
}
