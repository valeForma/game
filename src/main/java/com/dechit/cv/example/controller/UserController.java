package com.dechit.cv.example.controller;

import com.dechit.cv.example.service.UserService;
import com.dechit.cv.example.user.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Controller
public class UserController {
    //inserisci il display method
    //inserisci il @RequestParam o utilizza la @ModelAttribute per mappare i parametri dall'html
    //è possibile inserire delle validazioni tipo @Valid, @Size ecc.
    //BindingResult vengono caricati tutti gli errori, dove è possibile anche caricarli custom(data da una hashMap<NomeAtt,errore>)
    //Bindig ha bisogno di un path di posizione dato dalla @RequestMapping

    // TODO inserisci controlli lato server!!
    @Autowired(required = true)
    private UserService userService;

    public void setUserService(UserService us) {
        this.userService = us;
    }


    //todo utilizzare Costraint(validateby=nome.class) implements ConstraintValidator<T,T>
    @PostMapping("/add")
    //    @Validated(ValidationFields.class)
    public String addUsers(@ModelAttribute("users") Utente utente) {
        //  if (utente.getId() == 0) {
        //TODO aggiungere controlli esistenza
        //TODO aggiungere controllo password con regex
        //TODO aggiungere controllo CF
        this.userService.addPerson(utente);
        return "redirect:/users";
    }


    @RequestMapping(value = "/edit/{nickname}", method = RequestMethod.GET)
    public String editUsers(@PathVariable("nickname") String nickname, Model model) {
        model.addAttribute("users", this.userService.getPersonById(nickname));

        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUser(Model model) {
        model.addAttribute("utente", new Utente());
        return "newGame";
    }


    @RequestMapping(value = "/showUser/", params = {"nickUtente"})
    public String getUser(@RequestParam("nickUtente") String nickname, Model model) {
        model.addAttribute("nickUtente", this.userService.getPersonById(nickname).getNickUtente());
        model.addAttribute("nome", this.userService.getPersonById(nickname).getNome());
        model.addAttribute("cognome", this.userService.getPersonById(nickname).getCognome());

        return "/showUser";
    }

    @RequestMapping(value = "/loginForm1")
    public String logIn(@RequestParam Map<String,String> requestParams, Model model){
        if(Objects.isNull(model.addAttribute(this.userService.logIn(requestParams.get("nickUtente"),requestParams.get("password"))))){
            return "/loginForm";
        }else{
            return "newGame";
        }
    }

    @RequestMapping(value ="/loginForm")
    public String logInBase(Model model){
        model.addAttribute("utente", new Utente());
        return"loginForm";
    }

}
/*
 *  non è possibile staccare le jsp dall'html
 *  la massimo è possibile generare un json o un js da elaborare
 *
 *  non è possibile utilizzare lo stesso principio di React, ovvero la SPA
 * */