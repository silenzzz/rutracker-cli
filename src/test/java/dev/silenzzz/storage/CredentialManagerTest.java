package dev.silenzzz.storage;

import dev.silenzzz.rutracker4j.scrapper.net.AccountCredentials;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CredentialManagerTest {

    private static final String FILE_NAME = System.getenv("APPDATA") + "rutracker-cli.csv";

    @Test
    void storeCredentials_Credentials_CreateFile() throws IOException {
        // Given
        AccountCredentials credentials = new AccountCredentials("123", "456");

        CredentialManager.storeCredentials(credentials);
        assertThat(Paths.get(FILE_NAME))
                .exists();
    }
}