/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

import java.util.Date;
/**
 *
 * @author c1042486
 */
public class Stockage {
    private Integer id;
    private String reden;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

    public Date getVandatum() {
        return vandatum;
    }

    public void setVandatum(Date vandatum) {
        this.vandatum = vandatum;
    }

    public Date getTotdatum() {
        return totdatum;
    }

    public void setTotdatum(Date totdatum) {
        this.totdatum = totdatum;
    }

    public Integer getVliegtuig_id() {
        return vliegtuig_id;
    }

    public void setVliegtuig_id(Integer vliegtuig_id) {
        this.vliegtuig_id = vliegtuig_id;
    }

    public Integer getHangar_id() {
        return hangar_id;
    }

    public void setHangar_id(Integer hangar_id) {
        this.hangar_id = hangar_id;
    }
    private Date vandatum;
    private Date totdatum;
    private Integer vliegtuig_id;
    private Integer hangar_id;
    
    
    
}
