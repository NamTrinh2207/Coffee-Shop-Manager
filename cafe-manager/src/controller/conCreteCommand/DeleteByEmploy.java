package controller.conCreteCommand;

import controller.command.CommandStringDataType;
import controller.manager.ControllerManager;

public class DeleteByEmploy implements CommandStringDataType {
    ControllerManager controllerManager;

    public DeleteByEmploy(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.deleteByEmploy(id);
    }
}
