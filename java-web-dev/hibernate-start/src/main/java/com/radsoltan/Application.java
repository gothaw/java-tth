package com.radsoltan;

import com.radsoltan.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class Application {
    // Hold a reusable reference to a SessionFactory (since we need only one)
    private static final SessionFactory sessionFactory = buildSessionFactory();

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
                .withEmail("rama.chris@mail.com")
                .withPhone(1234567890L)
                .build();

        int id = save(contact);

        // Display a list of contacts before the update
        System.out.printf("%n%nBefore the update%n%n");
        fetchAllContacts().forEach(System.out::println);

        // Get the persisted contact
        Contact c = findContactById(id);
        // Update the contact
        c.setFirstName("Jimmy");
        // Persist the changes
        System.out.printf("%n%nUpdating...%n%n");
        update(c);
        System.out.printf("%n%nUpdate complete!%n%n");

        // Display a list of contacts after the update
        System.out.printf("%n%nAfter the update%n%n");
        fetchAllContacts().forEach(System.out::println);
        // Delete contact
        delete(contact);
        System.out.printf("%n%nAfter deletion%n%n");
        fetchAllContacts().forEach(System.out::println);
    }

    private static Contact findContactById(int id) {
        // Open session
        Session session = sessionFactory.openSession();

        // Retrieve the persistent object (or null if not found)
        Contact contact = session.get(Contact.class, id);

        // Close the session
        session.close();
        // Return the object
        return contact;
    }

    private static void update(Contact contact) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Use the session to update the contact
        session.update(contact);

        // Commit the transaction
        session.getTransaction().commit();
        // Close the session
        session.close();
    }

    private static void delete(Contact contact) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Use the session to update the contact
        session.delete(contact);

        // Commit the transaction
        session.getTransaction().commit();
        // Close the session
        session.close();
    }

    private static List<Contact> fetchAllContacts() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Create criteria
        CriteriaQuery<Contact> criteriaQuery = session.getCriteriaBuilder().createQuery(Contact.class);
        criteriaQuery.from(Contact.class);

        List<Contact> contacts = session.createQuery(criteriaQuery).getResultList();

        // Close the session
        session.close();

        return contacts;
    }

    private static int save(Contact contact) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Use the session to save the contact
        // id stores the id of the entity saved to the db
        int id = (int) session.save(contact);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();

        return id;
    }
}