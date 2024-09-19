package dev.silenzzz.command;

import picocli.CommandLine.*;

import java.util.concurrent.Callable;

@Command(name = "search")
public class SearchCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
