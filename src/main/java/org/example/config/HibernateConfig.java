package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Laptop;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    public static EntityManagerFactory entityManagerFactory() {
        Properties prop = new Properties();
        prop.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        prop.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty(Environment.USER, "postgres");
        prop.setProperty(Environment.PASS, "syimyk");
        prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty(Environment.SHOW_SQL, "true");
        prop.setProperty(Environment.HBM2DDL_AUTO, "update");
        prop.setProperty(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(prop);
        configuration.addAnnotatedClass(Laptop.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
