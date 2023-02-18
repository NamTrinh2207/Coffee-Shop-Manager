package controller.concreteCommand;

import controller.command.CommandStringDataType;
import controller.managerController.Manager;

public class TotalBillAmount implements CommandStringDataType {
    Manager controllerManager;

    public TotalBillAmount(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.totalBillAmount(id);
    }
}
