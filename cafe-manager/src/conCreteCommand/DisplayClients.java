package conCreteCommand;

import command.CommandVoid;
import controller.ControllerManager;

public class DisplayClients implements CommandVoid {
    ControllerManager controllerManager ;

    public DisplayClients(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.displayClients();
    }
}
