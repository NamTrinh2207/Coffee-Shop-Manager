package conCreteCommand;

import command.CommandListClients;
import controller.ControllerManager;
import model.Client;

import java.util.List;

public class ListClients implements CommandListClients {
    ControllerManager controllerManager;

    public ListClients(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }
    @Override
    public List<Client> execute() {
        return controllerManager.getClients();
    }
}
