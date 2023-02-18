package controller.conCreteCommand;

import controller.command.CommandVoidDataType;
import controller.manager.ControllerManager;

public class DisplayEmployees implements CommandVoidDataType {
    ControllerManager controllerManager;

    public DisplayEmployees(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.displayEmployees();
    }
}
