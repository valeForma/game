package com.dechit.cv.example.service;

import com.dechit.cv.example.operationDAO.UserRepository;
import com.dechit.cv.example.operationDAO.UtenteDAO;
import com.dechit.cv.example.user.Utente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UtenteDAO utenteDao = new UserRepository();


    public void setUserServiceImpl(UtenteDAO utenteDao){
        this.utenteDao= utenteDao;
    }


    @Override
    @Transactional
    public void addPerson(Utente u) {
        this.utenteDao.addUser(u);
    }

    @Override
    @Transactional
    public Utente getPersonById(String nickname) {
        return this.utenteDao.getPlayer(nickname);
    }

    @Override
    @Transactional
    public Utente logIn(String nickname, String password) {
        return this.utenteDao.logIn(nickname, password);
    }


}
