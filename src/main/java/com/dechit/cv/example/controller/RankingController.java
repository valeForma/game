package com.dechit.cv.example.controller;

import com.dechit.cv.example.ranking.ClassificaGenerale;
import com.dechit.cv.example.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RankingController {

    @Autowired(required = true)
    private RankingService rankingService;

    public void setUserService(RankingService rs) {
        this.rankingService = rs;
    }

    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public String showUser(Model model) {
        model.addAttribute("ranking", new ClassificaGenerale());
        return "ranking";
    }

//per nazione
    @RequestMapping(value = "/showRanking", params = {"nazione"})
    public String listUserNation(Model model) {
        //oggetto che si occupa di passare i dati dalla model alla view
        model.addAttribute("ranking", new ClassificaGenerale());
        model.addAttribute("listRanking", this.rankingService.showByNation(""));
        return "showUser";
    }

    @RequestMapping(value = "/showRanking", params = {"tipo"})
    public String listUserType(String tipo, Model model) {
        //oggetto che si occupa di passare i dati dalla model alla view
        model.addAttribute("ranking", new ClassificaGenerale());
        model.addAttribute("listRanking", this.rankingService.showByType(tipo));
        return "showRanking";
    }

    @RequestMapping(value = "/showRanking", method = RequestMethod.GET)
    public String listUserAdd(Model model) {
        //oggetto che si occupa di passare i dati dalla model alla view
        model.addAttribute("ranking", new ClassificaGenerale());
        model.addAttribute("listRanking", this.rankingService.getAllRanking());
        return "showRanking";
    }

}
