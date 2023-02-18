package controller.command;

import model.Person;

public interface CommandAddEmployee {
    void execute(Person employee);
}
