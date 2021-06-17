/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Jovana
 */
public class Rezervacija {

    private Integer rezervacijaId;
    private Integer korisnikId;
    private Integer treningId;
    private boolean status;
    private Integer teretanaId;
    private boolean placeno;
    public Korisnik korisnik = new Korisnik();
    public Trening trening = new Trening();
    public Teretana teretana = new Teretana();

    public Rezervacija() {
    }

    public Rezervacija(Integer rezervacijaId, Integer korisnikId, Integer treningId, boolean status, Integer teretanaId, boolean placeno) {
        this.rezervacijaId = rezervacijaId;
        this.korisnikId = korisnikId;
        this.treningId = treningId;
        this.status = status;
        this.teretanaId = teretanaId;
        this.placeno = placeno;
    }

    public Teretana getTeretana() {
        return teretana;
    }

    public void setTeretana(Teretana teretana) {
        this.teretana = teretana;
    }

    public Integer getTeretanaId() {
        return teretanaId;
    }

    public void setTeretanaId(Integer teretanaId) {
        this.teretanaId = teretanaId;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Integer getKorisnikId() {
        return korisnikId;
    }

    public Integer getRezervacijaId() {
        return rezervacijaId;
    }

    public Integer getTreningId() {
        return treningId;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean getPlaceno() {
        return this.placeno;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public void setRezervacijaId(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTreningId(Integer treningId) {
        this.treningId = treningId;
    }

    public void setPlaceno(boolean placeno) {
        this.placeno = placeno;
    }

}
