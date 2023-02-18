package controller.concreteCommand;

import controller.command.CommandListClients;
import controller.managerController.Manager;
import model.modelClass.Client;

import java.util.List;

public class ListClients implements CommandListClients {
    Manager controllerManager;

    public ListClients(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }
    @Override
    public List<Client> execute() {
        return controllerManager.getClients();
    }
}
