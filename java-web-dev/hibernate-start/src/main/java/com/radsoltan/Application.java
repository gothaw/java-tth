package com.radsoltan;

import com.radsoltan.model.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class Application {
    // Hold a reusable reference to a SessionFactory (since we need only one)
    //private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // Create a StandardServiceRegistry
        // StandardServiceRegistryBuilder() - builder object
        // configure - loads hibernate configuration file from its default location
        // build - builds standard service registry object
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        // MetadataSources encapsulates all the ORM mappings loaded from annotated entities
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        Contact contact = new Contact.ContactBuilder("Chris", "Ramacciotti")
                .withEmail("rama@mail.com")
                .withPhone(1234567890L)
                .build();

        System.out.println(contact);
    }
}