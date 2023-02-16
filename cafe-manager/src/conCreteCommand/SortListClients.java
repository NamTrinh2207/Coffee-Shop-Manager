package conCreteCommand;

import command.CommandVoidDataType;
import controller.ControllerManager;

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
