package flyway;


import org.flywaydb.core.Flyway;
import utilities.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * This class is in charge of the database migration process.
 */
public class Migration implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        migrateDatabase();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {}

    private void migrateDatabase() {

        String url = Configuration.getProperty(Configuration.Properties.DB_URL.toString());
        String user = Configuration.getProperty(Configuration.Properties.DB_USER.toString());
        String pass = Configuration.getProperty(Configuration.Properties.DB_PASSWORD.toString());

        try {
            // Create the Flyway instance
            Flyway flyway = new Flyway();

            // Configure to use out of order
            flyway.setOutOfOrder(true);

            // Point it to the database
            flyway.setDataSource(url, user, pass);

            // Start the db.Migration
            flyway.migrate();
        } catch(Exception ignored) {}

    }
}

