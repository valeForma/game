package com.dechit.cv.example.match;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "partita")
public class Partita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "punteggio",unique = false)
    private Integer punteggio;

    @Column(name = "nickutente")
    private String nickUtente;

    @Column(name = "data")
    private Date data;

    public Partita() {
        // TODO Auto-generated constructor stub
    }

    public Partita(int punteggio, String nickUtente, Date data) {
        this.punteggio = punteggio;
        this.nickUtente = nickUtente;
        this.data = data;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public String getNickUtente() {
        return nickUtente;
    }

    public void setNickUtente(String nickUtente) {
        this.nickUtente = nickUtente;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
