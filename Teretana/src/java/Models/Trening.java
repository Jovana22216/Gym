/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Teretana;
import Models.Korisnik;

/**
 *
 * @author Jovana
 */
public class Trening {
    
    private Integer treningId;
    private Integer teretanaId;
    private String datum;
    private String vreme;
    private String trajanje;
    private String opis;
    private Integer cena; 
    public Teretana teretana = new Teretana();
    public Korisnik korisnik = new Korisnik();
    
   

    public Trening() {
    }

    public Trening(Integer treningId, Integer teretanaId, String datum, String vreme, String trajanje, String opis, Integer cena) {
        this.treningId = treningId;
        this.teretanaId = teretanaId;
        this.datum = datum;
        this.vreme = vreme;
        this.trajanje = trajanje;
        this.opis = opis;
        this.cena = cena;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

  
    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

   

    public Teretana getTeretana() {
        return teretana;
    }

    
    public void setTeretana(Teretana teretana) {
        this.teretana = teretana;
    }

  

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

  
 

  
  

    public String getOpis() {
        return opis;
    }

    public Integer getTeretanaId() {
        return teretanaId;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public Integer getTreningId() {
        return treningId;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getVreme() {
        return vreme;
    }

    public void setTeretanaId(Integer teretanaId) {
        this.teretanaId = teretanaId;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public void setTreningId(Integer treningId) {
        this.treningId = treningId;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public void getDatum(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
