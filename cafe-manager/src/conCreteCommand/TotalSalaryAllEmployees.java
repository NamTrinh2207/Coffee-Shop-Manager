package conCreteCommand;
import command.CommandTotalEmployeeSalary;
import controller.ControllerManager;

public class TotalSalaryAllEmployees implements CommandTotalEmployeeSalary {
    ControllerManager controllerManager ;

    public TotalSalaryAllEmployees(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute() {
        return controllerManager.totalSalaryAllEmployees();
    }
}