package com.dechit.cv.example.service;

import com.dechit.cv.example.ranking.ClassificaGenerale;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RankingService {
    //estrai per nazione
     List<ClassificaGenerale> showByNation(String nation);
    //prendi tutto
    @Transactional
    List<ClassificaGenerale> getAllRanking();

    //add
     void addRanked(ClassificaGenerale classificaGenerale);

    List<ClassificaGenerale> showByType(String tipo);
}
