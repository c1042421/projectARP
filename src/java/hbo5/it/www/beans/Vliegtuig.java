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
    private Integer id;
    private Integer vliegtuigtype_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVliegtuigtype_id() {
        return vliegtuigtype_id;
    }

    public void setVliegtuigtype_id(Integer vliegtuigtype_id) {
        this.vliegtuigtype_id = vliegtuigtype_id;
    }

    public Integer getLuchtvaartmaatschappij_id() {
        return luchtvaartmaatschappij_id;
    }

    public void setLuchtvaartmaatschappij_id(Integer luchtvaartmaatschappij_id) {
        this.luchtvaartmaatschappij_id = luchtvaartmaatschappij_id;
    }
    private Integer luchtvaartmaatschappij_id;
    
}
