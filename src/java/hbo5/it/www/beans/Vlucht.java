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
public class Vlucht {
    private Integer id;
    private String code;
    private Date vertrektijd;
    private Date aankomsttijd;
    private Integer vliegtuig_id;
    private Integer vertrekluchthaven_id;
    private Integer aankomstluchthaven_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getVertrektijd() {
        return vertrektijd;
    }

    public void setVertrektijd(Date vertrektijd) {
        this.vertrektijd = vertrektijd;
    }

    public Date getAankomsttijd() {
        return aankomsttijd;
    }

    public void setAankomsttijd(Date aankomsttijd) {
        this.aankomsttijd = aankomsttijd;
    }

    public Integer getVliegtuig_id() {
        return vliegtuig_id;
    }

    public void setVliegtuig_id(Integer vliegtuig_id) {
        this.vliegtuig_id = vliegtuig_id;
    }

    public Integer getVertrekluchthaven_id() {
        return vertrekluchthaven_id;
    }

    public void setVertrekluchthaven_id(Integer vertrekluchthaven_id) {
        this.vertrekluchthaven_id = vertrekluchthaven_id;
    }

    public Integer getAankomstluchthaven_id() {
        return aankomstluchthaven_id;
    }

    public void setAankomstluchthaven_id(Integer aankomstluchthaven_id) {
        this.aankomstluchthaven_id = aankomstluchthaven_id;
    }
    
}
