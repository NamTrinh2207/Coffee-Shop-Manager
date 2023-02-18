package controller.concreteCommand;

import controller.command.CommandVoidDataType;
import controller.managerController.Manager;

public class SortListClients implements CommandVoidDataType {
    Manager controllerManager;

    public SortListClients(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.sortClient();
    }
}
