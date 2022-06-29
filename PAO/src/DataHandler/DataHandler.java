package DataHandler;


import Comanda.Comanda;
import Local.Local;
import Persoana.User;
import Sofer.Sofer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class DataHandler{
    private static String pathToLog = "log.csv";
    private static String pathToCsvSoferi = "soferi.csv";
    private static String pathToCsvUseri = "useri.csv";
    private static String pathToCsvLocaluri = "localuri.csv";
    private static String pathToCsvComenzi = "comenzi.csv";
    private static FileWriter logWriter;
    private static FileWriter csvWriterSoferi;
    private static FileWriter csvWriterUseri;
    private static FileWriter csvWriterLocaluri;
    private static FileWriter csvWriterComenzi;
    private static BufferedReader csvReaderSoferi;
    private static BufferedReader csvReaderUseri;
    private static BufferedReader csvReaderLocaluri;
    private static BufferedReader csvReaderComenzi;

    private static DataHandler dataHandler;

    private DataHandler(){
        try {
            logWriter = new FileWriter(pathToLog, true);
            csvWriterSoferi = new FileWriter(pathToCsvSoferi, true);
            csvWriterUseri = new FileWriter(pathToCsvUseri, true);
            csvWriterLocaluri = new FileWriter(pathToCsvLocaluri, true);
            csvWriterComenzi = new FileWriter(pathToCsvComenzi, true);
            csvReaderSoferi = new BufferedReader(new FileReader(pathToCsvSoferi));
            csvReaderUseri = new BufferedReader(new FileReader(pathToCsvUseri));
            csvReaderLocaluri = new BufferedReader(new FileReader(pathToCsvLocaluri));
            csvReaderComenzi = new BufferedReader(new FileReader(pathToCsvComenzi));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static DataHandler getDataHandler(){
        if(dataHandler == null){
            dataHandler = new DataHandler();
        }
        return dataHandler;
    }

    public void loadSoferi(ArrayList<Sofer> lista_soferi){
        String row;
        try {
            logWriter.append("loadSoferi, " + LocalDateTime.now().toString() + "\n");
            logWriter.flush();
            while ((row = csvReaderSoferi.readLine()) != null) {
                String[] data = row.split(",");
                Sofer sofer_nou = new Sofer(data[0], data[1], Integer.parseInt(data[2]));
                lista_soferi.add(sofer_nou);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUseri(ArrayList<User> lista_useri){
        String row;
        try {
            logWriter.append("loadUseri, " + LocalDateTime.now().toString() + "\n");
            logWriter.flush();
            while ((row = csvReaderUseri.readLine()) != null) {
                String[] data = row.split(",");
                User user_nou = new User(data[0], data[1],Integer.parseInt(data[2]),data[3],data[4]);
                lista_useri.add(user_nou);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void loadLocaluri(ArrayList<Local> lista_localuri){
        String row;
        try {
            logWriter.append("loadLocaluri, " + LocalDateTime.now().toString() + "\n");
            logWriter.flush();
            while ((row = csvReaderLocaluri.readLine()) != null) {
                String[] data = row.split(",");
                Local local_nou = new Local(data[0], Integer.parseInt(data[1]), data[2]);
                lista_localuri.add(local_nou);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void loadComenzi(ArrayList<Comanda> lista_comenzi, ArrayList<Sofer> lista_soferi,
                            ArrayList<User> lista_useri, ArrayList<Local> lista_localuri){
        String row;
        try {
            logWriter.append("loadComenzi, " + LocalDateTime.now().toString() + "\n");
            logWriter.flush();
            while ((row = csvReaderComenzi.readLine()) != null) {
                String[] data = row.split(",");

                Integer na = lista_soferi.size();
                Integer ne = lista_useri.size();
                Integer ns = lista_localuri.size();

                Sofer sofer = null;
                User user = null;
                Local local = null;

                for(Integer i=0;i<na;++i){
                    if(lista_soferi.get(i).get_nume().equals(data[1])){
                        sofer = lista_soferi.get(i);
                    }
                }

                for(Integer i=0;i<ne;++i){
                    if(lista_useri.get(i).get_nume().equals(data[2])){
                        user = lista_useri.get(i);
                    }
                }

                for(Integer i=0;i<ns;++i){
                    if(lista_localuri.get(i).get_nume().equals(data[4])){
                        local = lista_localuri.get(i);
                    }
                }

                Comanda comanda_noua = new Comanda(Integer.parseInt(data[0]), user, sofer, local, data[4]);
                lista_comenzi.add(comanda_noua);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void write(Sofer sofer){
        try {
            logWriter.append("writeSofer, " + LocalDateTime.now().toString() + "\n");
            csvWriterSoferi.append(sofer.get_nume());
            csvWriterSoferi.append(",");
            csvWriterSoferi.append(sofer.get_prenume());
            csvWriterSoferi.flush();
            logWriter.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void write(User user){
        try {
            logWriter.append("writeUser, " + LocalDateTime.now().toString() + "\n");
            csvWriterUseri.append(user.get_nume());
            csvWriterUseri.append(",");
            csvWriterUseri.append(user.get_prenume());
            csvWriterUseri.append(",");
            csvWriterUseri.append(user.get_tip());
            csvWriterUseri.append("\n");
            csvWriterUseri.flush();
            logWriter.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void write(Local local) {
        try {
            logWriter.append("writeLocal, " + LocalDateTime.now().toString() + "\n");
            csvWriterLocaluri.append(local.get_nume());
            csvWriterLocaluri.append(",");
            csvWriterLocaluri.append(local.get_capacitate().toString());
            csvWriterLocaluri.append(",");
            csvWriterLocaluri.append(local.get_rating());
            csvWriterLocaluri.append("\n");
            csvWriterLocaluri.flush();
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write(Comanda comanda) {
        try {
            logWriter.append("writeComanda, " + LocalDateTime.now().toString() + "\n");
            csvWriterComenzi.append(comanda.get_numar().toString());
            csvWriterComenzi.append(",");
            csvWriterComenzi.append(comanda.get_user().get_nume());
            csvWriterComenzi.append(",");
            csvWriterComenzi.append(comanda.get_sofer().get_nume());
            csvWriterComenzi.append(",");
            csvWriterComenzi.append(comanda.get_local().get_nume());
            csvWriterComenzi.append(",");
            csvWriterComenzi.append(comanda.get_adresa());
            csvWriterComenzi.append("\n");
            csvWriterComenzi.flush();
            logWriter.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
