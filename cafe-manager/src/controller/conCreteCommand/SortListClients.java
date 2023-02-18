package controller.conCreteCommand;

import controller.command.CommandVoidDataType;
import controller.manager.ControllerManager;

public class SortListClients implements CommandVoidDataType {
    ControllerManager controllerManager;

    public SortListClients(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.sortClient();
    }
}
