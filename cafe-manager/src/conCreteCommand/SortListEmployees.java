package conCreteCommand;

import command.CommandVoidDataType;
import controller.ControllerManager;

public class SortListEmployees implements CommandVoidDataType {
    ControllerManager controllerManager ;

    public SortListEmployees(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }
    @Override
    public void execute() {
        controllerManager.sortNameEmployees();
    }
}
