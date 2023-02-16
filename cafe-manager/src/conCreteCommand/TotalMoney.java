package conCreteCommand;

import command.CommandString;
import controller.ControllerManager;

public class TotalMoney implements CommandString {
    ControllerManager controllerManager;

    public TotalMoney(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.totalMoney(id);
    }
}
