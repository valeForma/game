package com.dechit.cv.example.operationDAO;

import com.dechit.cv.example.user.Utente;

public interface UtenteDAO {

    void addUser(Utente u);
    Utente logIn(String nickUtente, String password);
    Utente getPlayer(String nickname);

}
