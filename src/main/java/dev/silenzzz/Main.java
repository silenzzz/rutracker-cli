package dev.silenzzz;

import dev.silenzzz.command.AuthCommand;
import dev.silenzzz.command.MainCommand;
import picocli.CommandLine;

public class Main {

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new MainCommand())
                .addSubcommand(new AuthCommand());

        System.exit(cmd.execute(args));
    }
}