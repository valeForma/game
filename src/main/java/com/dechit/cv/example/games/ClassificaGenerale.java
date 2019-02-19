package main.java.com.dechit.cv.examplimport javax.persistence.*;

e.games;

import main.java.com.dechit.cv.example.matc
import main.java.com.dechit.cv.example.user.Utente;h.Partita;

@Entity
@Table(name = "classificagenerale")
public class ClassificaGenerale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="nickUtente", referencedColumnName = "nickUtente")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "nazione", referencedColumnName = "paese")
    private Utente nazione;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="punteggio", referencedColumnName = "punteggio",unique = false)
    private Partita punteggio;

    @Column(name = "tipo")
    private String tipoDiGioco;


    public ClassificaGenerale() {
        // TODO Auto-generated constructor stub
    }

    public ClassificaGenerale(Utente utente, Utente nazione, Partita punteggio,
                              String tipoDiGioco) {
        this.utente = utente;
        this.nazione = nazione;
        this.punteggio = punteggio;
        this.tipoDiGioco = tipoDiGioco;
    }

    public Utente getNazione() {
        return nazione;
    }

    public void setNazione(Utente nazione) {
        this.nazione = nazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Partita getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Partita punteggio) {
        this.punteggio = punteggio;
    }

    public String getTipoDiGioco() {
        return tipoDiGioco;
    }

    public void setTipoDiGioco(String tipoDiGioco) {
        this.tipoDiGioco = tipoDiGioco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
