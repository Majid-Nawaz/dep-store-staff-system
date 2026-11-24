
package staffsystem;

import staffsystem.controller.StoreController;
import staffsystem.view.SystemView;

public class StoreStaffSystem {

    public static void main(String[] args) {
        
        SystemView view = new SystemView();
        StoreController controller = new StoreController(view);
        controller.run();
    }
}
