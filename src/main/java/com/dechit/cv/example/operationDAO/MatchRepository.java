package com.dechit.cv.example.operationDAO;

import com.dechit.cv.example.match.Partita;

public class MatchRepository extends OperationDaoImp<Partita> implements MatchDAO{


    public MatchRepository(){
        super(Partita.class);
    }

    @Override
    public void addToRanking(Partita partita){
        super.add(partita);
    }

}
