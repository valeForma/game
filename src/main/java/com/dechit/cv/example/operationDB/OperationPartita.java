package com.dechit.cv.example.operationDB;

import com.dechit.cv.example.match.Partita;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

@NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "OperationPartita.add",
                query = "INSERT INTO Partita p VALUES(" +
                        "u.nickutente= :nick," +
                        "u.punteggio= :punteggio,"
                        + "u.datanascita= :data",
                timeout = 1,
                fetchSize = 10),
        @org.hibernate.annotations.NamedQuery(
                name = "OperationPartita.search",
                query = "FROM Partita p WHERE p.nickutente= :nick ",
                timeout = 1,
                fetchSize = 10),
        @org.hibernate.annotations.NamedQuery(
                name = "OperationPartita.show",
                query = "FROM Partita",
                timeout = 1,
                fetchSize = 10)
})
public class OperationPartita extends OperationDB {

    public void add(int punteggio, String nickUtente, Date data) {

        Query<Partita> query = currentSession.createNamedQuery("OperationPartita.add", Partita.class);
        query.setParameter("nick", nickUtente);
        query.setParameter("punteggio", punteggio);
        query.setParameter("data", data);

        query.getSingleResult();

    }

    public Partita search(String nick) {

        Query<Partita> query = currentSession.createNamedQuery("OperationPartita.search", Partita.class);
        query.setParameter("nick", nick);

        List<Partita> risultato = query.getResultList();

        return (Partita) risultato;
    }

    @Override
    public Partita show() {
        Query<Partita> query = currentSession.createNamedQuery("OperationPartita.show", Partita.class);
        List<Partita> risultato = query.getResultList();

        return (Partita) risultato;
    }
}
