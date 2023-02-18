package controller.command;

import model.modelClass.Person;

public interface CommandEditEmployees {
    void execute(Person employee, String id);
}
