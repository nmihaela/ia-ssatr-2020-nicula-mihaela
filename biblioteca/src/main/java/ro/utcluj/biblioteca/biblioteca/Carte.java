
package ro.utcluj.biblioteca.biblioteca;

import ro.utcluj.biblioteca.model.Cartea;
import ro.utcluj.biblioteca.service.carteService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;


public class Carte {
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
        carteService carteService = new carteService();
        try {

            ServerSocket ss = new ServerSocket(4030);

            while (true) {
                System.out.println("Astept conexiune de la client...");
                Socket s = ss.accept(); 
                System.out.println("Clientul s-a conectat!");
                //......
                BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                //......
                String line = "";
                String[] data = fluxIn.readLine().split(" ");
                switch (data[0]) {
                    
                    case "adaugaCarte":{
                        Cartea carte = new Cartea();
                        carte.setGEN(data[1]);
                        carte.setAUTOR(data[2]);
                        carte.setNUME(data[3]);
                        carte.setAN_PUBL(Integer.parseInt(data[4]));
                        carte.setNR_PAG(Integer.parseInt(data[5]));

                        String result = carteService.adaugaCarte (carte);
                        fluxOut.println(result);
                        break;
                    }
                    case "vizualizareBiblioteca": {
                        List<Cartea> result = carteService.vizualizareBiblioteca();
                        fluxOut.println(result);
                        break;
                    }
                    
                    default: {
                        
                    }
                }

                s.close();
             }
            } 
        catch (Exception e) {
            e.printStackTrace();
        }
     }
}
     

