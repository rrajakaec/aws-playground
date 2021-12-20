package com.playground;

import com.playground.dagger.CommandRouterFactory;
import com.playground.dagger.DaggerCommandRouterFactory;

import java.util.Scanner;

public class CommandLineAtmDagger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CommandRouterFactory commandRouterFactory = DaggerCommandRouterFactory.builder()
                .build();

        CommandRouter commandRouter = commandRouterFactory.router();
        while (scanner.hasNextLine()) {
            commandRouter.route(scanner.nextLine());
        }



    }
}
