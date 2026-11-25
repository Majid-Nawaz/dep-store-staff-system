
package staffsystem;

import staffsystem.controller.StoreController;
import staffsystem.model.StaffFileReader;
import staffsystem.model.StaffList;
import staffsystem.view.SystemView;

public class StoreStaffSystem {

    public static void main(String[] args) {
        
        SystemView view = new SystemView();
        StaffFileReader reader = new StaffFileReader();
        StaffList staffList = new StaffList();
        StoreController controller = new StoreController(view, reader, staffList);
        controller.run();
    }
}
