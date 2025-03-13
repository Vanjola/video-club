/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zaposleni;

import db.DbBroker;
import domen.Zaposleni;
import java.util.List;
import so.SistemskaOperacija;

/**
 *
 * @author vanja
 */
public class SOLogin extends SistemskaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Zaposleni)){
            throw new Exception("Prosledjeni objekat nije klase Zaposleni");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Zaposleni zaposleni = (Zaposleni) podatak;
        
        List<Zaposleni> lista = (List<Zaposleni>) (List<?>) DbBroker.getInstanca().nadji(zaposleni);
        
        if(lista.isEmpty()){
            throw new Exception("Pogresni kredencijali");
        }
        
        return lista.get(0);
    }
    
}
