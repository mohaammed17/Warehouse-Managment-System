package co2103.hw1;

import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class PreparationTest {

    @Test
    public void userDefined() throws Exception {
        assertNotNull("No username was specified in application.properties.", GenerateTasks.getUser());
    }
}