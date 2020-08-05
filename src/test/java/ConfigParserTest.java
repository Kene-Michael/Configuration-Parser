import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ConfigParserTest {

    @Test
    void testingConfigParserProduction() {
        ConfigParser newConfig = new ConfigParser("config.txt");

        assertAll(
                () -> assertEquals("sq04_db",newConfig.get("dbname")),
                () -> assertEquals("127.0.0.1",newConfig.get("host")),
                () -> assertEquals("fintek",newConfig.get("application.name")),
                () -> assertEquals("8080",newConfig.get("application.port")),
                () -> assertEquals("/api/v1",newConfig.get("application.context-url")),
                () -> assertEquals("production",newConfig.get("mode")),
                () -> assertEquals("green",newConfig.get("theme")),
                () -> assertEquals("fast",newConfig.get("pipeline"))

        );

    }

    @Test
    void testingConfigParserStaging() {
        ConfigParser newConfig = new ConfigParser("config-staging.txt");

        assertAll(
                () -> assertEquals("sq04_db",newConfig.get("dbname")),
                () -> assertEquals("127.0.0.1",newConfig.get("host")),
                () -> assertEquals("fintek-staging",newConfig.get("application.name")),
                () -> assertEquals("8081",newConfig.get("application.port")),
                () -> assertEquals("/api/v1",newConfig.get("application.context-url")),
                () -> assertEquals("staging",newConfig.get("mode")),
                () -> assertEquals("blue",newConfig.get("theme")),
                () -> assertEquals("fast-staging",newConfig.get("pipeline"))

        );
    }

    @Test
    void testingConfigParserDevelopment() {
        ConfigParser newConfig = new ConfigParser("config-dev.txt");

        assertAll(
                () -> assertEquals("sq04_db-development",newConfig.get("dbname")),
                () -> assertEquals("127.0.0.1",newConfig.get("host")),
                () -> assertEquals("fintek-development",newConfig.get("application.name")),
                () -> assertEquals("8082",newConfig.get("application.port")),
                () -> assertEquals("/api/v1",newConfig.get("application.context-url")),
                () -> assertEquals("development",newConfig.get("mode")),
                () -> assertEquals("yellow",newConfig.get("theme")),
                () -> assertEquals("fast-development",newConfig.get("pipeline"))

        );
    }

}
