package com.example.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.example.pojo.Comment;
import com.example.pojo.Image;
import com.example.pojo.Listing;
import com.example.pojo.ListingDetails;
import com.example.pojo.Reservation;
import com.example.pojo.User;

import java.util.Properties;

@Component
public class HibernateConfig {
	private static SessionFactory sessionFactory;

	public static SessionFactory SessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/hostedhomes");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "postgres");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Listing.class);
				configuration.addAnnotatedClass(ListingDetails.class);
				configuration.addAnnotatedClass(Image.class);
				configuration.addAnnotatedClass(Comment.class);
				configuration.addAnnotatedClass(Reservation.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
