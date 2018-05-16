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
public class Vliegtuig {
    private int id;
    private int vliegtuigtype_id;
    private Vliegtuigtype vliegtuigtype;
    private int luchtvaartmaatschappij_id;
    private Luchtvaartmaatschappij luchtvaartmaatschappij;

    public Luchtvaartmaatschappij getLuchtvaartmaatschappij() {
        return luchtvaartmaatschappij;
    }

    public void setLuchtvaartmaatschappij(Luchtvaartmaatschappij luchtvaartmaatschappij) {
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
    }

    public Vliegtuigtype getVliegtuigtype() {
        return vliegtuigtype;
    }

    public void setVliegtuigtype(Vliegtuigtype vliegtuigtype) {
        this.vliegtuigtype = vliegtuigtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVliegtuigtype_id() {
        return vliegtuigtype_id;
    }

    public void setVliegtuigtype_id(int vliegtuigtype_id) {
        this.vliegtuigtype_id = vliegtuigtype_id;
    }

    public int getLuchtvaartmaatschappij_id() {
        return luchtvaartmaatschappij_id;
    }

    public void setLuchtvaartmaatschappij_id(int luchtvaartmaatschappij_id) {
        this.luchtvaartmaatschappij_id = luchtvaartmaatschappij_id;
    }    
}
