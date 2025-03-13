/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import domen.DomenskiObjekat;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;
/**
 *
 * @author vanja
 */
public class DbBroker {
    
    private static DbBroker instanca;
    private Connection konekcija;
    
    private DbBroker(){
        
    }

    public static DbBroker getInstanca(){
        if(instanca == null){
            instanca = new DbBroker();
        }
        return instanca;
    }
    
    public void otvoriKonekciju() throws Exception{
        InputStream inputStream = new FileInputStream(new File("konfiguracija.properties"));
        Properties properties = new Properties();
        properties.load(inputStream);
        
        String url = properties.getProperty("url");
        String port = properties.getProperty("port");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String dbType = properties.getProperty("dbType");
        String dbName = properties.getProperty("dbName");
        konekcija = DriverManager.getConnection("jdbc:"+dbType+"://"+url+":"+port+"/"+dbName, username, password);
        konekcija.setAutoCommit(false);
        inputStream.close();
    }
    
    public void zatvoriKonekciju() throws Exception{
        konekcija.close();
    }
    
    public void commit() throws Exception{
        konekcija.commit();
    }
    
    public void rollback() throws Exception{
        konekcija.rollback();
    }
    
    
    public void zapamti(DomenskiObjekat domenskiObjekat) throws Exception{
        String upit = "INSERT INTO " + domenskiObjekat.vratiNazivTabele()+"("+domenskiObjekat.vratiKoloneZaInsert()+") VALUES("+domenskiObjekat.vratiVrednostiZaInsert()+")";
        
        PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        
        ps.execute();
        
        if(domenskiObjekat.imaAutoIncrementIdKolonu()){
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generisaniId = rs.getInt(1);
            domenskiObjekat.setId(generisaniId);
        }
    }
    
    public void izmeni(DomenskiObjekat domenskiObjekat) throws Exception{
        String upit = "UPDATE " + domenskiObjekat.vratiNazivTabele()+" SET "+ domenskiObjekat.vratiKoloneZaUpdate()+" WHERE "+domenskiObjekat.vratiUslovZaId();
        
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.execute();
    }
    
    public void obrisi(DomenskiObjekat domenskiObjekat) throws Exception{
        String upit = "DELETE FROM "+ domenskiObjekat.vratiNazivTabele()+" WHERE "+ domenskiObjekat.vratiUslovZaId();
        
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.execute();
    }
    
    public List<DomenskiObjekat> ucitajListu(DomenskiObjekat domenskiObjekat) throws Exception{
        String upit = "SELECT * FROM "+ domenskiObjekat.vratiNazivTabele()+ " " + domenskiObjekat.vratiJoinUslov();
        
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ResultSet rs = ps.executeQuery();
        
        return domenskiObjekat.napraviListu(rs);
    }
    
    public List<DomenskiObjekat> nadji(DomenskiObjekat domenskiObjekat) throws Exception{
        String upit = "SELECT * FROM "+ domenskiObjekat.vratiNazivTabele()+ " " + domenskiObjekat.vratiJoinUslov() + " WHERE "+ domenskiObjekat.vratiUslovPretrage();
        
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ResultSet rs = ps.executeQuery();
        
        return domenskiObjekat.napraviListu(rs);
    }
}
