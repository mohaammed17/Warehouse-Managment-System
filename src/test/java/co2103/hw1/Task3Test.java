package co2103.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Task3Test {

    @Test
    public void classesCreated() throws Exception {
        checkExists("src/main/java/co2103/hw1/controller/MainController.java");
    }

    private void checkExists(String path) {
        assertTrue(path + " is missing", Files.exists(Paths.get(path)));
    }

    @Autowired
    private MockMvc mockMvc; //if there is an error in this line, please ignore it as it is a glitch

    @Test
    public void greetingGETShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("start"));
    }
    @Test
    public void greetingPOSTShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("start"));
    }

}
