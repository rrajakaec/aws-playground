package com.playground;

import javax.inject.Inject;
import java.util.List;

public class HelloWorldCommand implements Command {

    private final Outputter outputter;

    @Inject
    public HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return "hello";
    }

    @Override
    public Status handleInput(List<String> input) {
        System.out.println("Input is: " + input);
        if (input.isEmpty()) {
            return Status.INVALID;
        }
        outputter.output("world");
        return Status.HANDLED;
    }

}
