package controller.conCreteCommand;

import controller.command.CommandStringDataType;
import controller.manager.ControllerManager;

public class FullTimeEmployeeSalary implements CommandStringDataType {
    ControllerManager controllerManager;

    public FullTimeEmployeeSalary(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.salaryFullTime(id);
    }
}
