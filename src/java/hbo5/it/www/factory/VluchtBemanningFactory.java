package hbo5.it.www.factory;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author c1042410
 */
public class VluchtBemanningFactory extends BaseFactory {

    public VluchtBemanning maakVluchtbemanningVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            return maakObject(resultset);
        }
        return null;
    }

    @Override
    public VluchtBemanning maakObject(ResultSet resultset) throws SQLException {
        VluchtBemanning vluchtbemanning = new VluchtBemanning();

        vluchtbemanning.setId(resultset.getInt("ID"));
        vluchtbemanning.setTaak(resultset.getString("TAAK"));
        vluchtbemanning.setBemanningslid_id(resultset.getInt("BEMANNINGSLID_ID"));
        vluchtbemanning.setVlucht_id(resultset.getInt("VLUCHT_ID"));

        try {
            Bemanningslid bemanningslid = new BemanningFactory().maakObject(resultset);
            vluchtbemanning.setBemanningslid(bemanningslid);
           
            Vlucht vlucht = new VluchtFactory().maakObject(resultset);
            vluchtbemanning.setVlucht(vlucht);
        } catch (Exception e) {
        }

        return vluchtbemanning;
    }

    public VluchtBemanning maakVluchtBemanningVanRequest(HttpServletRequest request) {
        VluchtBemanning vluchtbemanning = new VluchtBemanning();
        
        vluchtbemanning.setTaak(request.getParameter("taak_id"));
        vluchtbemanning.setBemanningslid_id(Integer.parseInt(request.getParameter("bemannings_id")));
        vluchtbemanning.setVlucht_id(Integer.parseInt(request.getParameter("vlucht_id")));
        
        return vluchtbemanning;
    }
}
