package com.dechit.cv.example.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "Utente.logInQuery",
                query = "FROM Utente WHERE nickutente = :nick AND password= :pass",
                timeout = 1,
                fetchSize = 1),
        @org.hibernate.annotations.NamedQuery(
                name = "Utente.getUtenteQuery",
                query = "FROM Utente WHERE nickutente = :nick",
                timeout = 1,
                fetchSize = 1)
})

@Entity
@Table(name = "utente")
public class Utente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "sesso")
    private char sesso;

    @Column(name = "datanascita")
    private Date dataNascita;

    @Column(name = "luogodinascita")
    private String luogoDiNascita;

    @Column(name = "paese")
    //TODO agganciarlo a checkString
    private String paese;

    @Column(name = "codicefiscale")
    private String codiceFiscale;

    @Column(name = "nickutente")
    private String nickUtente;

    @Column(name = "password")
    private String password;


    public Utente() {
        // TODO Auto-generated constructor stub
    }


    public Utente(String nome, String cognome, char sesso, Date dataNascita, String luogoDiNascita,
                  String paese, String codiceFiscale, String nickUtente, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.dataNascita = dataNascita;
        this.luogoDiNascita = luogoDiNascita;
        this.paese = paese;
        this.codiceFiscale = codiceFiscale;
        this.nickUtente = nickUtente;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNickUtente() {
        return nickUtente;
    }

    public void setNickUtente(String nickUtente) {
        this.nickUtente = nickUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getLuogoDiNascita() {
        return luogoDiNascita;
    }

    public void setLuogoDiNascita(String luogoDiNascita) {
        this.luogoDiNascita = luogoDiNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }




    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", sesso=" + sesso +
                ", dataNascita=" + dataNascita +
                ", luogoDiNascita='" + luogoDiNascita + '\'' +
                ", paese='" + paese + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", nickUtente='" + nickUtente + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
