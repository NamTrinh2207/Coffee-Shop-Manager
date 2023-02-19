package controller.command;

import model.classModel.Person;

public interface CommandAddEmployee {
    void execute(Person employee);
}
