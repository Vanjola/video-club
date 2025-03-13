/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clan;

import db.DbBroker;
import domen.Clan;
import java.util.List;
import so.SistemskaOperacija;

/**
 *
 * @author vanja
 */
public class SONadjiClana extends SistemskaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
          if(!(podatak instanceof Clan)){
        throw new Exception("Prosledjeni objekat nije klase clan");
    }

    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Clan clan=(Clan) podatak;
        return (List<Clan>)(List<?>) DbBroker.getInstanca().nadji(clan);
    }
    
    
}
