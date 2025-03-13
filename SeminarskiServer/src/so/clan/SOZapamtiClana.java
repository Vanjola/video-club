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
public class SOZapamtiClana extends SistemskaOperacija {

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if (!(podatak instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije klase  clan.");
        }

        Clan clan = (Clan) podatak;
        List<Clan> listaClanova = (List<Clan>) (List<?>) DbBroker.getInstanca().ucitajListu(clan);
        for (Clan c : listaClanova) {
            if (c.getIdClana() != clan.getIdClana()
                    && (c.getEmail().equals(clan.getEmail()))) {
                throw new Exception("Clan sa navedenim emailom vec postoji");
            }
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Clan clan = (Clan) podatak;
        DbBroker.getInstanca().zapamti(clan);
        return clan;
    }

}
