package controller.command;

import model.modelClass.Person;

public interface CommandAddEmployee {
    void execute(Person employee);
}
