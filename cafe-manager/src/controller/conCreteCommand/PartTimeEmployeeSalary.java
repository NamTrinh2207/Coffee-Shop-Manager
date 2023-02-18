package controller.conCreteCommand;

import controller.command.CommandStringDataType;
import controller.manager.ControllerManager;

public class PartTimeEmployeeSalary implements CommandStringDataType {
    ControllerManager controllerManager ;

    public PartTimeEmployeeSalary(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.salaryPartTime(id);
    }
}
