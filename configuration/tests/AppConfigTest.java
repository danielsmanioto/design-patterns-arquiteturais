import org.example.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppConfigTest {

    @Test
    void valida_metodos_default_sucesso() {
        Assertions.assertEquals("MinhaAplicacao", AppConfig.getAppName());
        Assertions.assertEquals("dev", AppConfig.getAppEnv());
        Assertions.assertEquals("1.0.0", AppConfig.getAppVersion());
    }

    @Test
    void valida_metodos_sucesso() {
        String key = "Language";
        System.setProperty(key, "JAVA");
        Assertions.assertEquals("JAVA", AppConfig.get(key));
    }

}
