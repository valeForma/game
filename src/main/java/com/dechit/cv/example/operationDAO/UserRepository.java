package com.dechit.cv.example.operationDAO;

import com.dechit.cv.example.user.Utente;
import com.dechit.cv.example.util.ConnectionUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends OperationDaoImp<Utente> implements UtenteDAO {
    public UserRepository() {
        super(Utente.class);
    }


    @Override
    public Utente getPlayer(String nickname) {
        Session session = ConnectionUtil.getInstance().getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        Utente result = entityManager.createNamedQuery("Utente.getUtenteQuery", Utente.class)
                .setParameter("nick", nickname)
                .getSingleResult();
        tx.commit();
        return result;
    }

    @Override
    public Utente logIn(String nickUtente, String password) {
        Session session = ConnectionUtil.getInstance().getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        Utente utente = entityManager.createNamedQuery("Utente.logInQuery", Utente.class)
                .setParameter("nick", nickUtente)
                .setParameter("pass", password)
                .getSingleResult();
        tx.commit();
        return utente;
    }

    @Override
    public void addUser(Utente u) {
        super.add(u);
    }


}