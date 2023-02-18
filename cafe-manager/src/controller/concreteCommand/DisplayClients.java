package controller.concreteCommand;

import controller.command.CommandVoidDataType;
import controller.managerController.Manager;

public class DisplayClients implements CommandVoidDataType {
    Manager controllerManager ;

    public DisplayClients(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.displayClients();
    }
}
