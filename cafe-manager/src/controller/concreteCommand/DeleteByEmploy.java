package controller.concreteCommand;

import controller.command.CommandStringDataType;
import controller.managerController.Manager;

public class DeleteByEmploy implements CommandStringDataType {
    Manager controllerManager;

    public DeleteByEmploy(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.deleteByEmploy(id);
    }
}
