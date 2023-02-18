package controller.concreteCommand;

import controller.command.CommandStringDataType;
import controller.managerController.Manager;

public class PartTimeEmployeeSalary implements CommandStringDataType {
    Manager controllerManager ;

    public PartTimeEmployeeSalary(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.salaryPartTime(id);
    }
}
