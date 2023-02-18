package controller.concreteCommand;

import controller.command.CommandVoidDataType;
import controller.managerController.Manager;

public class SortListEmployees implements CommandVoidDataType {
    Manager controllerManager ;

    public SortListEmployees(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }
    @Override
    public void execute() {
        controllerManager.sortNameEmployees();
    }
}
