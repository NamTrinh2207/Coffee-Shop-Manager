package controller.conCreteCommand;

import controller.command.CommandVoidDataType;
import controller.manager.ControllerManager;

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
