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
    private Integer id;
    private Integer luchtvaartmaatschappij_id;
    private Integer persoon_id;
    private Integer functie_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLuchtvaartmaatschappij_id() {
        return luchtvaartmaatschappij_id;
    }

    public void setLuchtvaartmaatschappij_id(Integer luchtvaartmaatschappij_id) {
        this.luchtvaartmaatschappij_id = luchtvaartmaatschappij_id;
    }

    public Integer getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(Integer persoon_id) {
        this.persoon_id = persoon_id;
    }

    public Integer getFunctie_id() {
        return functie_id;
    }

    public void setFunctie_id(Integer functie_id) {
        this.functie_id = functie_id;
    }
    
}
