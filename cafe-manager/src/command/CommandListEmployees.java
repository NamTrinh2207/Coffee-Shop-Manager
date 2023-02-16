package command;

import model.Person;

import java.util.List;

public interface CommandListEmployees {
    List<Person> execute();
}
