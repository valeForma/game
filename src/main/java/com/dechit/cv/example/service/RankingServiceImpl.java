package com.dechit.cv.example.service;

import com.dechit.cv.example.operationDAO.RankingDAO;
import com.dechit.cv.example.operationDAO.RankingRepository;
import com.dechit.cv.example.ranking.ClassificaGenerale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RankingServiceImpl extends RankingRepository implements RankingService  {

    private RankingDAO rankingDao = new RankingRepository();

    public void setRankingServiceImpl(RankingDAO rankingDao){
        this.rankingDao= rankingDao;
    }


    @Override
    @Transactional
    public List<ClassificaGenerale> showByNation(String nation) {
        return this.rankingDao.getByNation(nation);
    }

    @Override
    @Transactional
    public List<ClassificaGenerale> getAllRanking() {
        return this.rankingDao.getAllRanking();
    }

    @Override
    @Transactional
    public void addRanked(ClassificaGenerale classificaGenerale) {
        this.rankingDao.add(classificaGenerale);
    }

    @Override
    public List<ClassificaGenerale> showByType(String tipo) {
        return null;
    }


}
