package controller.command;

import model.classModel.Person;

public interface CommandEditEmployees {
    void execute(Person employee, String id);
}
