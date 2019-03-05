package com.dechit.cv.example.service;

import com.dechit.cv.example.match.Partita;
import com.dechit.cv.example.operationDAO.MatchDAO;
import com.dechit.cv.example.operationDAO.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchServiceImp implements MatchService {

    private MatchDAO matchDao = new MatchRepository();

    public void setMatchServiceImp(MatchDAO matchDao){
        this.matchDao= matchDao;
    }

    @Override
    @Transactional
    public void addMatch(Partita p) {
    this.matchDao.add(p);
    }

}
