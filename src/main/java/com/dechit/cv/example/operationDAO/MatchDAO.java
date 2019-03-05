package com.dechit.cv.example.operationDAO;

import com.dechit.cv.example.match.Partita;

public interface MatchDAO extends OperationDao<Partita>{

    void addToRanking (Partita partita);
}
