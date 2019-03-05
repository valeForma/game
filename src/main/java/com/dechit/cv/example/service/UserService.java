package com.dechit.cv.example.service;

import com.dechit.cv.example.user.Utente;

public interface UserService {
    void addPerson(Utente u);
    Utente logIn(String nickname, String password);
    Utente getPersonById(String nickname);

}
