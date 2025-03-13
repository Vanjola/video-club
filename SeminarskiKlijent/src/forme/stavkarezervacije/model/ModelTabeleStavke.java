/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.stavkarezervacije.model;


import domen.StavkaRezervacije;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vanja
 */
public class ModelTabeleStavke extends AbstractTableModel {
  private List<StavkaRezervacije> list;
    private String[] kolone = {"film"};

    public ModelTabeleStavke(List<StavkaRezervacije> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRezervacije sr = list.get(rowIndex);
        return sr.getFilm();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public StavkaRezervacije vratiIzabranuRezervaciju(int index) {
        return list.get(index);
    }

    public void setList(List<StavkaRezervacije> stavke) {
        this.list = stavke;
        fireTableDataChanged();
    }

    public void dodajStavku(StavkaRezervacije stavkaRezervacije) throws Exception {
        for(StavkaRezervacije stavka: list){
            if(stavka.getFilm().equals(stavkaRezervacije.getFilm())){
                throw new Exception("Vec ste dodali ovaj film");
            }
        }
        
        list.add(stavkaRezervacije);
        fireTableDataChanged();
    }

    public void izbrisiStavku(int izabraniRedStavke) {
        list.remove(izabraniRedStavke);
        fireTableDataChanged();
    }

    public List<StavkaRezervacije> getList() {
        return list;
    }
    
    
}
