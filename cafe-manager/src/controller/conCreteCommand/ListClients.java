package controller.conCreteCommand;

import controller.command.CommandListClients;
import controller.manager.ControllerManager;
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
