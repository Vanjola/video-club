/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clan;

import db.DbBroker;
import domen.Clan;
import so.SistemskaOperacija;
import java.sql.*;
/**
 *
 * @author vanja
 */
public class SOObrisiClana  extends SistemskaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Clan)){
        throw new Exception("Prosledjeni objekat nije klase clan");
    }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        try{
        Clan clan= (Clan) podatak;
        DbBroker.getInstanca().obrisi(clan);
        return clan;
    }catch(SQLIntegrityConstraintViolationException ex){
        ex.printStackTrace();
        throw new Exception("Ne mozete da obriste clana koji ima rezervaciju");
    }
        
    }
    
}
