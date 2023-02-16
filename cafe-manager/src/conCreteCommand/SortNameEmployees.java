package conCreteCommand;

import command.CommandVoid;
import controller.ControllerManager;

public class SortNameEmployees implements CommandVoid {
    ControllerManager controllerManager ;

    public SortNameEmployees(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }
    @Override
    public void execute() {
        controllerManager.sortNameEmployees();
    }
}
