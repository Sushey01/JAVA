package bcu.changeme.phonebook.main;
import bcu.changeme.phonebook.model.*;
import bcu.changeme.phonebook.model.PhoneBook;
/**
 * @author id124659
 *
 */ 
public interface Command {
	   public static final String HELP_MESSAGE = "Commands:\n" +
		        "    add [name] [phoneNumber]        add a new entry\n" +
		        "    show [name]                     show an entry\n" +
		        "    update [name] [phoneNumber]     update an entry\n" +
		        "    remove [name]                   remove an entry\n" +
		        "    list                            show all names\n" +
		        "    help                            show this help message\n" +
		        "    exit                            exit the program";

	public void execute (PhoneBook phoneBook) 
			throws AlreadyPresentException, NotPresentException;
	
}
