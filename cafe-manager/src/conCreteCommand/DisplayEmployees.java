package conCreteCommand;

import command.CommandVoid;
import controller.ControllerManager;

public class DisplayEmployees implements CommandVoid {
    ControllerManager controllerManager;

    public DisplayEmployees(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.displayEmployees();
    }
}
