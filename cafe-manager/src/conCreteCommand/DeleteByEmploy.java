package conCreteCommand;

import command.CommandString;
import controller.ControllerManager;

public class DeleteByEmploy implements CommandString {
    ControllerManager controllerManager;

    public DeleteByEmploy(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.deleteByEmploy(id);
    }
}
