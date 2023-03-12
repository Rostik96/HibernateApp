package com.rost;

import org.hibernate.cfg.Configuration;
import com.rost.model.Person;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        var configuration = new Configuration().addAnnotatedClass(Person.class);
        var sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            var person = session.get(Person.class, 1);
            System.out.println(person);
            session.getTransaction().commit();
        }
    }
}
