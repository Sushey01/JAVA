package bcu.changeme.phonebook.main;

import bcu.changeme.phonebook.model.PhoneBook;

public class HelpCommand implements Command {
 
    @Override
    public void execute(PhoneBook phoneBook) {
        System.out.println(HELP_MESSAGE);
    }
}
