/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

/**
 *
 * @author c1042486
 */
public class Bemanningslid {
    private int id;
    private int luchtvaartmaatschappij_id;
    private int persoon_id;
    private int functie_id;
    private Luchtvaartmaatschappij luchtvaartmaatschappij;
    private Persoon persoon;
    private Functie functie;

    public Luchtvaartmaatschappij getLuchtvaartmaatschappij() {
        return luchtvaartmaatschappij;
    }

    public void setLuchtvaartmaatschappij(Luchtvaartmaatschappij luchtvaartmaatschappij) {
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Functie getFunctie() {
        return functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLuchtvaartmaatschappij_id() {
        return luchtvaartmaatschappij_id;
    }

    public void setLuchtvaartmaatschappij_id(int luchtvaartmaatschappij_id) {
        this.luchtvaartmaatschappij_id = luchtvaartmaatschappij_id;
    }

    public int getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(int persoon_id) {
        this.persoon_id = persoon_id;
    }

    public int getFunctie_id() {
        return functie_id;
    }

    public void setFunctie_id(int functie_id) {
        this.functie_id = functie_id;
    }
    
}
