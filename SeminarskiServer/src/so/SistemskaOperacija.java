/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DbBroker;

/**
 *
 * @author vanja
 */
public abstract class SistemskaOperacija {

    public Object izvrsiOperaciju(Object podatak) throws Exception {
        try {
            DbBroker.getInstanca().otvoriKonekciju();

            validiraj(podatak);
            Object rezultat = izvrsi(podatak);

            DbBroker.getInstanca().commit();

            return rezultat;
        } catch (Exception ex) {
            DbBroker.getInstanca().rollback();
            throw ex;
        } finally {
            DbBroker.getInstanca().zatvoriKonekciju();
        }
    }

    protected abstract void validiraj(Object podatak) throws Exception;

    protected abstract Object izvrsi(Object podatak) throws Exception;

}
