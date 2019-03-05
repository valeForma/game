package com.dechit.cv.example.operationDAO;

import com.dechit.cv.example.ranking.ClassificaGenerale;
import com.dechit.cv.example.util.ConnectionUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RankingRepository extends OperationDaoImp<ClassificaGenerale> implements RankingDAO {

    public RankingRepository() {
        super(ClassificaGenerale.class);
    }

    @Override
    public List<ClassificaGenerale> getByNation(String nation) {
        Session session = ConnectionUtil.getInstance().getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        List<ClassificaGenerale> result = entityManager.createNamedQuery("ClassificaGenerale.getRankingByNationQuery", ClassificaGenerale.class)
                .setParameter("naz",nation)
                .getResultList();
        tx.commit();
        return result;
    }


    @Override
    public List<ClassificaGenerale> getAllRanking() {
        Session session = ConnectionUtil.getInstance().getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        List<ClassificaGenerale> result= entityManager.createNamedQuery("ClassificaGenerale.getAllRankingQuery", ClassificaGenerale.class)
                .getResultList();
        tx.commit();
        return result;
    }

    @Override
    public List<ClassificaGenerale> showByType(String tipo) {
        Session session = ConnectionUtil.getInstance().getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        List<ClassificaGenerale> result = entityManager.createNamedQuery("ClassificaGenerale.getRankingByTypeQuery", ClassificaGenerale.class)
                .setParameter("tipo",tipo)
                .getResultList();
        tx.commit();
        return result;
    }

}
