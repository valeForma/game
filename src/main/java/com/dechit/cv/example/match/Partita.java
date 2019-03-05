package com.dechit.cv.example.match;

import com.dechit.cv.example.user.Utente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "partita")
public class Partita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "punteggio")
    private Integer punteggio;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "nickUtente",referencedColumnName = "nickUtente")
    private Utente utente;

    @Column(name = "data")
    private Date data;

    public Partita() {
        // TODO Auto-generated constructor stub
    }

    public Partita(Integer punteggio, Utente utente, Date data) {
        this.punteggio = punteggio;
        this.utente = utente;
        this.data = data;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
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
