package test;

import java.util.Date;

import com.dechit.cv.example.games.ClassificaGenerale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dechit.cv.example.match.Partita;
import com.dechit.cv.example.user.Utente;

public class Test {

    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Date data = new Date();
        Partita p = new Partita(110, "Carmine", data);
        Utente u = new Utente("carmine", "carmine", "U meghj", "root", "italy");
        ClassificaGenerale c = new ClassificaGenerale(u,p,"miao");


        session.save(c);
        session.save(p);
        session.save(u);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();

    }

}
