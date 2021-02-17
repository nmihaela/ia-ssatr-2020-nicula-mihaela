/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.biblioteca.service;

import ro.utcluj.biblioteca.connection.DBAccess;
import ro.utcluj.biblioteca.model.Cartea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mihaela
 */
public class carteService {
     DBAccess dbAccess;

    public carteService() throws ClassNotFoundException, SQLException {
        this.dbAccess = DBAccess.getInstance();
    }

  
    
     public String adaugaCarte (Cartea carte) throws SQLException {
        Random random = new Random();
        int id = random.nextInt(999999999);
       try (Statement s = dbAccess.getConnection().createStatement()) {
            s.executeUpdate("INSERT INTO CARTI (ID,GEN, AUTOR, NUME, AN_PUBL,NR_PAG) VALUES ("+id+",'"+ carte.getGEN() + "','" + carte.getAUTOR()+ "','" + carte.getNUME() + "'," + Integer.parseInt(String.valueOf(carte.getAN_PUBL())) + "," + Integer.parseInt(String.valueOf(carte.getNR_PAG()))  +  ")");
        }
        return "Carte adaugata: " + carte.toString();
    }
    
      public List<Cartea> vizualizareBiblioteca () throws SQLException {
        try (Statement s = dbAccess.getConnection().createStatement()) {
            ResultSet resultSet = s.executeQuery("SELECT * FROM CARTI");
            if (resultSet.next()) {
                Cartea cartea = createCarteaFromResultSet(resultSet);

                List<Cartea> carti = new ArrayList<>();
                carti.add(cartea);
                while (resultSet.next()) {
                    cartea = new Cartea();
                    cartea.setID(resultSet.getInt("id"));
                    cartea.setGEN(resultSet.getString("Gen"));
                    cartea.setAUTOR(resultSet.getString("autor"));
                    cartea.setNUME(resultSet.getString("nume"));
                    cartea.setAN_PUBL(resultSet.getInt("an"));
                    cartea.setNR_PAG(resultSet.getInt("nr_pag"));
                    carti.add(cartea);
                }
                return carti;
            } else {
                return new ArrayList<>(0);
            }
        }
    }

    private Cartea createCarteaFromResultSet(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
