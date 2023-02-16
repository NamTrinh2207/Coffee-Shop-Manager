package conCreteCommand;

import command.TotalSalaryEmployees;
import controller.ControllerManager;

public class TotalSalaryAllEmployees implements TotalSalaryEmployees {
    ControllerManager controllerManager ;

    public TotalSalaryAllEmployees(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute() {
        return controllerManager.totalSalaryAllEmployees();
    }
}
