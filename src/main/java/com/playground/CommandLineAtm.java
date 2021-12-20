package com.playground;

import java.util.Scanner;

public class CommandLineAtm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CommandRouter commandRouter = new CommandRouter();

        commandRouter.route(scanner.nextLine());

    }
}
