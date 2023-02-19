package controller.command;

import model.classModel.Person;

import java.util.List;

public interface CommandListEmployees {
    List<Person> execute();
}
