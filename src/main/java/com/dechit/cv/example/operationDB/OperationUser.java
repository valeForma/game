package com.dechit.cv.example.operationDB;

import com.dechit.cv.example.user.Utente;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;


@NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "OperationUser.add",
                query = "INSERT INTO Utente u VALUES(" +
                        "u.nome= :nome," +
                        "u.cognome= :cognome," +
                        "u.sesso= :sesso," +
                        "u.datanascita= :data," +
                        " luogonascita= :luogo," +
                        "u.paese= :paese," +
                        " u.codicefiscale= :cf," +
                        " u.nickutente= :nick," +
                        "u.password= :pass)",
                timeout = 1,
                fetchSize = 10),
        @org.hibernate.annotations.NamedQuery(
                name = "OperationUser.search",
                query = "FROM Utente u WHERE u.nickutente= :nick ",
                timeout = 1,
                fetchSize = 10),
        @org.hibernate.annotations.NamedQuery(
                name = "OperationUser.show",
                query = "FROM Utente",
                timeout = 1,
                fetchSize = 10)
})
public class OperationUser extends OperationDB {


    private void add(String nome, String cognome, char sesso, Date dataNascita, String luogoDiNascita,
                     String paese, String codiceFiscale, String nickUtente, String password) {

        Query<Utente> query = currentSession.createNamedQuery("OperationUser.add", Utente.class);
        query.setParameter("nome", nome);
        query.setParameter("cognome", cognome);
        query.setParameter("sesso", sesso);
        query.setParameter("data", dataNascita);
        query.setParameter("luogo", luogoDiNascita);
        query.setParameter("paese", paese);
        query.setParameter("cf", codiceFiscale);
        query.setParameter("nick", nickUtente);
        query.setParameter("pass", password);

        query.getSingleResult();
    }

    public Utente search(String nickUtente) {
        Query<Utente> query = currentSession.createNamedQuery("OperationUser.search", Utente.class);
        query.setParameter("nick", nickUtente);
        Utente result = query.getSingleResult();

        return result;
    }

    public Utente show() {
        Query<Utente> query = currentSession.createNamedQuery("OperationUser.show", Utente.class);
        List<Utente> result = query.getResultList();
//TODO aggiusta sta cosa
        return (Utente) result;
    }


}
