
package staffsystem.model;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter {
   

    
    
    public static List<Employee> sortByName(List<Employee> staffList) {  
        
        List<Employee> list = new ArrayList<>(staffList);
        mergeSort(list, 0, list.size() - 1); // sort the whole copy: first index to last index
        List<Employee> twentySortedStaff = list.subList(0, Math.min(20, list.size()));
        return twentySortedStaff;
    }
    private static void  mergeSort(List<Employee> unsortedStaffList, int si, int ei){
        
         if (si >= ei) {                                       // base case: 0 or 1 item is already sorted
            return;                                           // void method, so a plain return; hands control back to the paused caller
        }
        int mid = si + (ei - si) / 2;                         // middle index (this form avoids int overflow)
        mergeSort(unsortedStaffList, si, mid);                             // line A: sort the left half   si..mid
        mergeSort(unsortedStaffList, mid + 1, ei);                         // line B: sort the right half  mid+1..ei
        merge(unsortedStaffList, si, mid, ei); 
        
        
    }
    
    // Merges two sorted halves that sit side by side in the list: si..mid and mid+1..ei
    private static void merge(List<Employee> list, int si, int mid, int ei) {
        Employee[] temp = new Employee[ei - si + 1];    // room for every item in this range
        int i = si;                                           // pointer into the left half
        int j = mid + 1;                                      // pointer into the right half
        int k = 0;                                            // pointer into temp

        // while both halves still have items: take the smaller name
        while (i <= mid && j <= ei) {
            String leftName = list.get(i).getEmployeeName();          
            String rightName = list.get(j).getEmployeeName();
            if (leftName.compareToIgnoreCase(rightName) <= 0) {   // <= : equal names keep their original order (stable)
                temp[k] = list.get(i);
                i++;
            } else {
                temp[k] = list.get(j);
                j++;
            }
            k++;
        }
        while (i <= mid) {                                    // left half has leftovers -> copy them
            temp[k] = list.get(i);
            i++;
            k++;
        }
        while (j <= ei) {                                     // right half has leftovers -> copy them
            temp[k] = list.get(j);
            j++;
            k++;
        }
        // copy temp back into the same spot in the list (positions si..ei)
        for (k = 0, i = si; k < temp.length; k++, i++) {
            list.set(i, temp[k]);
        }
    }
    
    
}
