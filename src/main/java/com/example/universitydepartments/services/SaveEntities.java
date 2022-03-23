package com.example.universitydepartments.services;

import com.example.universitydepartments.model.Degree;
import com.example.universitydepartments.model.Department;
import com.example.universitydepartments.model.Lector;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class SaveEntities {

    public void saveAllModels() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Set<Lector> lectors1 = new HashSet<>();
        Set<Lector> lectors2 = new HashSet<>();
        Set<Lector> lectors3 = new HashSet<>();

        Department department1 = new Department("Faculty of Economics", "Tony Stark");
        Department department2 = new Department("Faculty of Architecture", "Albert Einstein");
        Department department3 = new Department("Faculty of Law", "Aristarchus");

        lectors1.add(new Lector("Aristarchus", 1500, Degree.ASSISTANT));
        lectors1.add(new Lector("Aristotle", 3000, Degree.ASSOCIATE_PROFESSOR));
        lectors2.add(new Lector("Albert Einstein", 5000, Degree.PROFESSOR));
        lectors2.add(new Lector("Aristarch", 1500, Degree.ASSISTANT));
        lectors2.add(new Lector("Ari Surname", 3000, Degree.ASSOCIATE_PROFESSOR));
        lectors3.add(new Lector("Sam Stk", 1200, Degree.ASSISTANT));
        lectors3.add(new Lector("Aria Stark", 1200, Degree.ASSISTANT));
        lectors3.add(new Lector("Tony Stark", 500, Degree.ASSISTANT));

        department1.setLectors(lectors1);
        department2.setLectors(lectors2);
        department3.setLectors(lectors3);


        session.persist(department1);
        session.persist(department2);
        session.persist(department3);

        session.getTransaction().commit();
        session.close();
    }
}
