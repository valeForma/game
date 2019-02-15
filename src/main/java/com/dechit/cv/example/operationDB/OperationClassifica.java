package com.dechit.cv.example.operationDB;

import com.dechit.cv.example.games.ClassificaGenerale;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.query.Query;

import java.util.List;

@NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "OperationClassifica.add",
                query = "INSERT INTO ClassificaGenerale cg " +
                        "VALUES(cg.nickUntente= :nick, " +
                        "cg.punteggio= :punteggio" +
                        "cg.tipodigioco= :tipo" +
                        "cg.nazione= :nazione)",
                timeout = 1),
        @org.hibernate.annotations.NamedQuery(
                name = "OperationClassifica.nazione",
                query = "FROM ClassificaGenerale cg " +
                        "WHERE cg.nazione = :nazione",
                timeout = 1,
                //quanti risultati prendere
                fetchSize = 10),
        @org.hibernate.annotations.NamedQuery(
                name = "OperationClassifica.show",
                query = "FROM ClassificaGenerale",
                timeout = 1,
                //quanti risultati prendere
                fetchSize = 10)
})

public class OperationClassifica extends OperationDB {
    public void add(String nick, String punteggio, String tipo, String nazione) {
        Query<ClassificaGenerale> query = currentSession.createNamedQuery("OperationClassifica.add", ClassificaGenerale.class);
        query.setParameter("nick", nick);
        query.setParameter("punteggio", punteggio);
        query.setParameter("tipo", tipo);
        query.setParameter("nazione", nazione);

        query.getSingleResult();
    }

    //TODO cambiare nazione in checkString
    public ClassificaGenerale nazionalita(String nazione) {
        Query<ClassificaGenerale> query = currentSession.createNamedQuery("OperationClassifica.nazione", ClassificaGenerale.class);
        query.setParameter("nazione", nazione);


        List<ClassificaGenerale> risultato = query.getResultList();

        return (ClassificaGenerale) risultato;
    }

    public ClassificaGenerale show() {
        Query<ClassificaGenerale> query = currentSession.createNamedQuery("OperationClassifica.show", ClassificaGenerale.class);
        List<ClassificaGenerale> risultato = query.getResultList();

        return (ClassificaGenerale) risultato;
    }
}
