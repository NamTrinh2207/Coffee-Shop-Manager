package conCreteCommand;

import command.CommandVoidDataType;
import controller.ControllerManager;

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
