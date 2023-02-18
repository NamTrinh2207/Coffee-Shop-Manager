package controller.concreteCommand;

import controller.command.CommandAddClients;
import controller.managerController.Manager;
import model.modelClass.Client;

public class AddNewClient implements CommandAddClients {
    Manager controllerManager;

    public AddNewClient(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute(Client client) {
        controllerManager.addNewClient(client);
    }
}
