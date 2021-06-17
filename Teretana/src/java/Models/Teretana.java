/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Blob;

/**
 *
 * @author Jovana
 */
public class Teretana {
    
    private Integer teretanaId;
    private String nazivTeretane;
    private String  telefonTeretane;
    private String  adresaTeretane;
    private String grad;
    private String email;
    private String opis;
    private Blob fotografija;

    public Teretana() {
    }

    public Teretana(Integer teretanaId, String nazivTeretane, String telefonTeretane, String adresaTeretane, String grad, String email, String opis, Blob fotografija) {
        this.teretanaId = teretanaId;
        this.nazivTeretane = nazivTeretane;
        this.telefonTeretane = telefonTeretane;
        this.adresaTeretane = adresaTeretane;
        this.grad = grad;
        this.email = email;
        this.opis = opis;
        this.fotografija = fotografija;
    }


   

    public String getAdresaTeretane() {
        return adresaTeretane;
    }

    public String getEmail() {
        return email;
    }

    public String getGrad() {
        return grad;
    }

    public Blob getFotografija() {
        return fotografija;
    }

    public String getNazivTeretane() {
        return nazivTeretane;
    }

    public String getOpis() {
        return opis;
    }

    public String getTelefonTeretane() {
        return telefonTeretane;
    }

    public Integer getTeretanaId() {
        return teretanaId;
    }

    public void setAdresaTeretane(String adresaTeretane) {
        this.adresaTeretane = adresaTeretane;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFotografija(Blob fotografija) {
        this.fotografija = fotografija;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public void setNazivTeretane(String nazivTeretane) {
        this.nazivTeretane = nazivTeretane;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setTelefonTeretane(String telefonTeretane) {
        this.telefonTeretane = telefonTeretane;
    }

    public void setTeretanaId(Integer teretanaId) {
        this.teretanaId = teretanaId;
    }

    public void getNazivTeretane(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
    
}
