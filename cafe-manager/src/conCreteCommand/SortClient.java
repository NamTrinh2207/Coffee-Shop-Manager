package conCreteCommand;

import command.CommandVoid;
import controller.ControllerManager;

public class SortClient implements CommandVoid {
    ControllerManager controllerManager;

    public SortClient(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute() {
        controllerManager.sortClient();
    }
}
