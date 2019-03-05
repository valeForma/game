package com.dechit.cv.example.operationDAO;

import com.dechit.cv.example.ranking.ClassificaGenerale;

import java.util.List;

public interface RankingDAO  extends OperationDao<ClassificaGenerale>{

    List<ClassificaGenerale> getByNation(String nation);

    List<ClassificaGenerale> getAllRanking();

    List<ClassificaGenerale> showByType(String tipo);
}
