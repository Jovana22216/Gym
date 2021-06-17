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
public class Korisnik {
    
   private Integer korisnikId;
    private String imeKorisnika;
    private String prezimeKorisnika;
    private String korisnickoIme;
    private String sifra;
    private String email;
    private String  telefonKorisnika;
    private String  adresaKorisnika;
    private String gradKorisnika;
    private String rolaId;

    public Korisnik() {
    }

    public Korisnik(Integer korisnikId, String imeKorisnika, String prezimeKorisnika, String korisnickoIme, String sifra, String email, String telefonKorisnika, String adresaKorisnika, String gradKorisnika, String rolaId) {
        this.korisnikId = korisnikId;
        this.imeKorisnika = imeKorisnika;
        this.prezimeKorisnika = prezimeKorisnika;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.email = email;
        this.telefonKorisnika = telefonKorisnika;
        this.adresaKorisnika = adresaKorisnika;
        this.gradKorisnika = gradKorisnika;
        this.rolaId = rolaId;
    }

    public String getAdresaKorisnika() {
        return adresaKorisnika;
    }

    public String getEmail() {
        return email;
    }

    public String getGradKorisnika() {
        return gradKorisnika;
    }

    public String getImeKorisnika() {
        return imeKorisnika;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public Integer getKorisnikId() {
        return korisnikId;
    }

    public String getPrezimeKorisnika() {
        return prezimeKorisnika;
    }

    public String getRolaId() {
        return rolaId;
    }

    public String getSifra() {
        return sifra;
    }

    public String getTelefonKorisnika() {
        return telefonKorisnika;
    }

    public void setAdresaKorisnika(String adresaKorisnika) {
        this.adresaKorisnika = adresaKorisnika;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGradKorisnika(String gradKorisnika) {
        this.gradKorisnika = gradKorisnika;
    }

    public void setImeKorisnika(String imeKorisnika) {
        this.imeKorisnika = imeKorisnika;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public void setPrezimeKorisnika(String prezimeKorisnika) {
        this.prezimeKorisnika = prezimeKorisnika;
    }

    public void setRolaId(String rolaId) {
        this.rolaId = rolaId;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setTelefonKorisnika(String telefonKorisnika) {
        this.telefonKorisnika = telefonKorisnika;
    }

    /*public void setRolaId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public void getImeKorisnika(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
