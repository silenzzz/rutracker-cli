package dev.silenzzz.command;

import dev.silenzzz.RuTracker;
import dev.silenzzz.rutracker4j.RuTracker4jDefaultClient;
import dev.silenzzz.rutracker4j.scrapper.exception.RuTracker4jException;
import dev.silenzzz.rutracker4j.scrapper.net.AccountCredentials;
import dev.silenzzz.rutracker4j.scrapper.net.exception.AuthenticationException;
import dev.silenzzz.rutracker4j.scrapper.net.exception.IncorrectCaptchaException;
import dev.silenzzz.terminal.ConsolePrinter;
import picocli.CommandLine.*;

import javax.net.ssl.SSLHandshakeException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

@Command(name = "auth")
public class AuthCommand implements Callable<Integer> {

    @Option(names = {"-u", "--username"}, required = true)
    private String username;

    @Option(names = {"-p", "--password"}, required = true)
    private String password;

    @Option(names = {"-o", "--override"})
    private boolean override = false;

    @Override
    public Integer call() throws Exception {
        try {
            ConsolePrinter.printInfo("Authenticating...\n");
            new RuTracker4jDefaultClient(new AccountCredentials(username, password));
            if (!override) {
                ConsolePrinter.printSuccess("Already authenticated");
                return 0;
            }
        } catch (IncorrectCaptchaException e) {
            ConsolePrinter.printError("RuTracker captcha request");
            return 1;
        } catch (AuthenticationException e) {
            if (e.getCause() instanceof SocketException ||
                    e.getCause() instanceof UnknownHostException ||
                    e.getCause() instanceof SocketTimeoutException ||
                    e.getCause() instanceof SSLHandshakeException) {

                if (e.getCause() instanceof SSLHandshakeException) {
                    ConsolePrinter.printError("SSL handshake failed. Try to use different VPN or proxy");
                    return 2;
                }

                ConsolePrinter.printError("Connection error. You can try again with enabled VPN or proxy");
                return 2;
            }

            ConsolePrinter.printError(e.getMessage());
            return 3;
        } catch (RuTracker4jException e) {
            ConsolePrinter.printError(e.getMessage());
            return 4;
        }

        ConsolePrinter.printSuccess("Authentication successful");

        return 0;
    }
}
