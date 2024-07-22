package bcu.changeme.phonebook.main;

import bcu.changeme.phonebook.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private final PhoneBook phoneBook;

    public Main() {
        this.phoneBook = new PhoneBook();
    }

    public Main(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String commandString;

        System.out.println("Welcome to the PhoneBook!");

        while (true) {
            System.out.print("> ");
            commandString = reader.readLine();
            if (commandString.equals("exit")) {
                break;
            }
            try {
               parseAndExecute(commandString);
              
            } catch (InvalidCommandException e) {
                System.out.println("Invalid command. Type 'help' for assistance.");
            } catch (AlreadyPresentException e) {
                System.out.println("Entry for '" + e.getName() + "' already exists.");
            } catch (NotPresentException e) {
                System.out.println("Entry for '" + e.getName() + "' does not exist.");
            }
        }
    }

    public void parseAndExecute(String commandString) throws AlreadyPresentException, NotPresentException, InvalidCommandException {
       
            Command command = parse(commandString);
           
            if (command != null) {
            	 command.execute(phoneBook);
            }else {
            	throw new InvalidCommandException();
            }
        
    }

    public Command parse(String commandString) throws InvalidCommandException {
        String[] parts = commandString.split("\\s+");
        if (parts.length == 0) {
            throw new InvalidCommandException();
        }

        String command = parts[0].toLowerCase();
        switch (command) {
            case "add":
                return new AddCommand(parts);
            case "show":
                return new ShowCommand(parts);
            case "update":
                return new UpdateCommand(parts);
            case "remove":
                return new RemoveCommand(parts);
            case "list":
                return new ListCommand(parts);
            case "help":
                return new HelpCommand(); // Change here
            default:
                throw new InvalidCommandException();
        }
    }
}
