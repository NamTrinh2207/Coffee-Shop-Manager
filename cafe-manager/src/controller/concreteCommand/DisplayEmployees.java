package controller.concreteCommand;

import controller.command.CommandVoidDataType;
import controller.managerController.Manager;

public class DisplayEmployees implements CommandVoidDataType {
    Manager controllerManager;

    public DisplayEmployees(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.displayEmployees();
    }
}
