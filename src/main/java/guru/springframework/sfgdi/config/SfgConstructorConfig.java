package guru.springframework.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("usr")
@ConstructorBinding
public class SfgConstructorConfig {
    private final String name;
    private final String password;
    private final String jdbcUrl;

    public SfgConstructorConfig(String name, String password, String jdbcUrl) {
        this.name = name;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
