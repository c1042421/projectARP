package hbo5.it.www.factory;
import hbo5.it.www.beans.VluchtBemanning;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author c1042410
 */
public class VluchtBemanningFactory extends BaseFactory {
    public VluchtBemanning maakVluchtbemanningVanResultset(ResultSet resultset) throws SQLException{
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

        return vluchtbemanning;
    }
}

