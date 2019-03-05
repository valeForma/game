package com.dechit.cv.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;


public final class ConnectionUtil {

    private static ConnectionUtil connectionUtil;
    public SessionFactory sessionFactory;
    public EntityManagerFactory emf;
    public Configuration configuration;

    private ConnectionUtil(){
        emf = Persistence.createEntityManagerFactory("manager1");
        configuration = new Configuration()
                .configure("hibernate.cfg.xml");
    }

    public static ConnectionUtil getInstance(){
        if (Objects.isNull(connectionUtil))
            connectionUtil = new ConnectionUtil();
        return connectionUtil;
    }
    //metodo che apre la connessione

    public <T> void openConnection(Class<T> entityClass){
         sessionFactory = configuration.addAnnotatedClass((entityClass)).buildSessionFactory();

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    //gestisce connessione


    //chiude la connessione

}
