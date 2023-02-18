package controller.concreteCommand;

import controller.command.CommandStringDataType;
import controller.managerController.Manager;

public class FullTimeEmployeeSalary implements CommandStringDataType {
    Manager controllerManager;

    public FullTimeEmployeeSalary(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.salaryFullTime(id);
    }
}
