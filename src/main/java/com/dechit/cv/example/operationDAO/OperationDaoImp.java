package com.dechit.cv.example.operationDAO;

import com.dechit.cv.example.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public abstract class OperationDaoImp<T>  implements OperationDao<T> {
    //semplice console.log

    private Class<T> entityClass;
    public Transaction tx = null;
    public EntityManager entityManager = ConnectionUtil.getInstance().emf.createEntityManager();


    public OperationDaoImp(Class<T> entityClass) {
        this.entityClass = entityClass;
        System.out.println("costruttore" + entityClass);
        ConnectionUtil.getInstance().openConnection(entityClass);
    }

    @Override
    public void add(T t) {
        Session session = ConnectionUtil.getInstance().getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        session.save(t);
        tx.commit();
    }

    @Override
    public void update(T t) {
        Session session = ConnectionUtil.getInstance().getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        session.update(t);
        tx.commit();
    }


}
