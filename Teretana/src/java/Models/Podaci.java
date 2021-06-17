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
public class Podaci {
    
    private Integer podatakId;
    private Integer korisnikId;
    private String zahtev;
    private Double kilaza;
    private String pritisak;
    private String aktivnost;
    private String pol;
   
    public Korisnik korisnik = new Korisnik();
     
    public Podaci() {
    
    }

    public Podaci(Integer podatakId, Integer korisnikId, String zahtev, Double kilaza, String pritisak, String aktivnost, String pol) {
        this.podatakId = podatakId;
        this.korisnikId = korisnikId;
        this.zahtev = zahtev;
        this.kilaza = kilaza;
        this.pritisak = pritisak;
        this.aktivnost = aktivnost;
        this.pol = pol;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    
    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

      

    public String getZahtev() {
        return zahtev;
    }

    public void setZahtev(String zahtev) {
        this.zahtev = zahtev;
    }

  

    public String getAktivnost() {
        return aktivnost;
    }

    public Double getKilaza() {
        return kilaza;
    }

    public Integer getPodatakId() {
        return podatakId;
    }

    public String getPritisak() {
        return pritisak;
    }

    public String getPol() {
        return pol;
    }

    public void setAktivnost(String aktivnost) {
        this.aktivnost = aktivnost;
    }

    public void setKilaza(Double kilaza) {
        this.kilaza = kilaza;
    }

    public void setPodatakId(Integer podatakId) {
        this.podatakId = podatakId;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public void setPritisak(String pritisak) {
        this.pritisak = pritisak;
    }
  
}
