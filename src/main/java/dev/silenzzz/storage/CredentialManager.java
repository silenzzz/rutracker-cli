package dev.silenzzz.storage;

import dev.silenzzz.rutracker4j.scrapper.net.AccountCredentials;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@UtilityClass
public class CredentialManager {

    private static final String FILE_NAME = String.format("/%s/%s", System.getenv("APPDATA"), "rutracker-cli.csv");

    public static void storeCredentials(AccountCredentials credentials) throws IOException {
        File appData = new File(FILE_NAME);

        if (!appData.exists()) {
            appData.createNewFile();
            System.out.println(appData.toPath());
        }

        Files.writeString(appData.toPath(), String.format("%s;%s", credentials.getUsername(), credentials.getPassword()));
    }

    public static AccountCredentials loadCredentialsFromFile() throws IOException {
        File appData = new File(FILE_NAME);
        if (!appData.exists()) {
            return null;
        }

        return null;
    }
}
