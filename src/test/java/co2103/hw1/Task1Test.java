
package co2103.hw1;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class Task1Test {

    @Test
    public void checkProperties() throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("src/main/resources/application.properties"));
        assertTrue("Folder for JSPs not defined.", "/WEB-INF/views/".equals(p.getProperty("spring.mvc.view.prefix")));
        assertTrue("JSP extension not defined.", ".jsp".equals(p.getProperty("spring.mvc.view.suffix")));
    }

    @Test
    public void dependencies() throws Exception {
        String content = Files.readString(Paths.get("build.gradle"));
        assertTrue("Jasper libraries not loaded for JSPs.", content.contains("tomcat-embed-jasper"));
    }
}