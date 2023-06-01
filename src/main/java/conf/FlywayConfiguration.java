package conf;

import org.flywaydb.core.Flyway;

public class FlywayConfiguration {

    public static void migrate(String url) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(url, "", "")
                .load();
        flyway.migrate();
    }
}
