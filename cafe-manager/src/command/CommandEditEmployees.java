package command;

import model.Person;

public interface CommandEditEmployees {
    void execute(Person employee, String id);
}
