package controller.command;

import model.modelClass.Person;

import java.util.List;

public interface CommandListEmployees {
    List<Person> execute();
}
