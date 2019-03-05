package com.dechit.cv.example.controller;

import com.dechit.cv.example.match.Partita;
import com.dechit.cv.example.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MatchController {

    private MatchService matchService;

    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }

//    @RequestMapping(value = "/partita", method = RequestMethod.GET)
//    public String showUser(Model model) {
//        model.addAttribute("ranking", new Partita());
//
//        return "newGame";
//    }

    @RequestMapping(value = "/nuovoGioco")
    public String newGame(Model model){
         model.addAttribute("partita", new Partita());
        return "newGame";
    }

}
