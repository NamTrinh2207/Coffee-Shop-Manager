package conCreteCommand;

import command.CommandVoidDataType;
import controller.ControllerManager;

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
