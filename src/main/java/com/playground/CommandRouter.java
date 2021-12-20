package com.playground;

import com.playground.Command.Status;

import javax.inject.Inject;
import java.util.*;

public class CommandRouter {

    private final Map<String, Command> commands = new HashMap<>();

    @Inject
    public CommandRouter(Command command) {
        commands.put(command.key(), command);
    }

    public CommandRouter(){

    }

    public Status route(String input) {
        System.out.println("Input: " + input);
        List<String> splitInput = split(input);

        if (splitInput.isEmpty()) {
            return invalidCommand("Empty input");
        }

        String commandKey = splitInput.get(0);

        Command command = commands.get(commandKey);

        if(command == null) {
            return invalidCommand("No Key present");
        }

        Status status = command.handleInput(splitInput.subList(0, splitInput.size()));
        if (status == Status.INVALID) {
            System.out.println(commandKey + ": invalid arguments");
        }
        return status;
    }

    private static List<String> split(String input) {
        return Arrays.asList(input.split(" "));
    }

    private Status invalidCommand(String input) {
        System.out.println(String.format("couldn't understand \"%s\". please try again.", input));
        return Status.INVALID;
    }

}
