package controller.conCreteCommand;

import controller.command.CommandVoidDataType;
import controller.manager.ControllerManager;

public class DisplayClients implements CommandVoidDataType {
    ControllerManager controllerManager ;

    public DisplayClients(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.displayClients();
    }
}
