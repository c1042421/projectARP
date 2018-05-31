/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Persoon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author c1042410
 */
public class BemanningFactory extends BaseFactory {

    public Bemanningslid maakBemanningslidVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            return maakObject(resultset);
        }
        return null;
    }

    @Override
    public Bemanningslid maakObject(ResultSet resultset) throws SQLException {
        Bemanningslid bemanningslid = new Bemanningslid();

        bemanningslid.setId(resultset.getInt(1));
        bemanningslid.setLuchtvaartmaatschappij_id(resultset.getInt("luchtvaartmaatschappij_id"));
        bemanningslid.setPersoon_id(resultset.getInt("persoon_id"));
        bemanningslid.setFunctie_id(resultset.getInt("functie_id"));
        
        Functie functie = new FunctieFactory().maakObject(resultset);
        Luchtvaartmaatschappij lvm = new LuchtvaartmaatschappijFactory().maakObject(resultset);
        Persoon persoon = new PersoonFactory().maakObject(resultset);
        
        bemanningslid.setFunctie(functie);
        bemanningslid.setLuchtvaartmaatschappij(lvm);
        bemanningslid.setPersoon(persoon);
        
        return bemanningslid;
    }

    public Bemanningslid maakBemanningslidVanRequest(HttpServletRequest request) {
        Bemanningslid lid = new Bemanningslid();
        
        String stringID = request.getParameter("id");
        
        if (stringID != null){
            lid.setId(Integer.parseInt(stringID));
        }
        
        lid.setLuchtvaartmaatschappij_id(Integer.parseInt(request.getParameter("lvm_id")));
        lid.setFunctie_id(Integer.parseInt(request.getParameter("functie_id")));
        
        return lid;
    }
}
