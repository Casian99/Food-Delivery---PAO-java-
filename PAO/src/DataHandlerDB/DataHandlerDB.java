package DataHandlerDB;

import Comanda.Comanda;
import Local.Local;
import Persoana.User;
import Sofer.Sofer;

import java.sql.*;
import java.util.ArrayList;

public class DataHandlerDB {
    private static String dbURL = "jdbc:mysql://localhost:3306/proiectpao";
    private static String username = "root";
    private static String password = "casian99";
    private static Connection conn;

    private static DataHandlerDB dataHandler;

    private DataHandlerDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Conectat!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static DataHandlerDB getDataHandlerDB() {
        if (dataHandler == null) {
            dataHandler = new DataHandlerDB();
        }
        return dataHandler;
    }


    public void createTable_soferi() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS proiectpao.soferi " +
                    "(nume VARCHAR(50) not NULL, " +
                    " prenume VARCHAR(50), " +
                    " salariu INTEGER)";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            if(statement.execute(sql)==false)
                System.out.println("Tabela soferi a fost creata!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createTable_useri() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS proiectpao.useri " +
                    "(nume VARCHAR(50) not NULL, " +
                    " prenume VARCHAR(50), " +
                    " an_nastere INTEGER, " +
                    " cnp VARCHAR(15), " +
                    " tip VARCHAR(15))";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            if(statement.execute(sql)==false)
                System.out.println("Tabela useri a fost creata!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createTable_localuri() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS proiectpao.localuri " +
                    "(nume VARCHAR(50) not NULL, " +
                    " capacitate INTEGER, " +
                    " rating VARCHAR(6))";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            if(statement.execute(sql)==false)
                System.out.println("Tabela localuri a fost creata!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createTable_comenzi(){
        try{
            String sql = "CREATE TABLE IF NOT EXISTS proiectpao.comenzi " +
                    "(numar INTEGER not NULL, " +
                    " user_nume VARCHAR(50), " +
                    " sofer_nume VARCHAR(50), " +
                    " local_nume VARCHAR(50), " +
                    " adresa VARCHAR(50))";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            if(statement.execute(sql)==false)
                System.out.println("Tabela comenzi soferi a fost creata!");
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }


    public void deleteTable_soferi(){
        try{
            String sql = "DROP TABLE proiectpao.soferi";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Tabela soferi a fost stearsa");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteTable_useri(){
        try{
            String sql = "DROP TABLE proiectpao.useri";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Tabela useri a fost stearsa");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteTable_localuri(){
        try{
            String sql = "DROP TABLE proiectpao.localuri";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Tabela localuri a fost stearsa");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteTable_comenzi(){
        try{
            String sql = "DROP TABLE proiectpao.comenzi";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Tabela comenzi a fost stearsa");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    public void loadSoferi(ArrayList<Sofer> lista_soferi) {
        try {
            String sql = "SELECT * FROM soferi";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                String nume = result.getString("nume");
                String prenume = result.getString("prenume");
                Integer salariu = result.getInt("salariu");

                Sofer sofer_nou = new Sofer(nume, prenume, salariu);
                lista_soferi.add(sofer_nou);

                count++;
            }

            if (count == 0) {
                System.out.println("Niciun sofer nu a fost incarcat!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadUseri(ArrayList<User> lista_useri) {
        try {
            String sql = "SELECT * FROM useri";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                String nume = result.getString("nume");
                String prenume = result.getString("prenume");
                Integer an_nastere = result.getInt("an_nastere");
                String cnp = result.getString("cnp");
                String tip = result.getString("tip");

                User user_nou = new User(nume, prenume, an_nastere, cnp, tip);
                lista_useri.add(user_nou);

                count++;
            }

            if (count == 0) {
                System.out.println("Niciun user nu a fost incarcat!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadLocaluri(ArrayList<Local> lista_localuri) {
        try {
            String sql = "SELECT * FROM localuri";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                String nume = result.getString("nume");
                Integer capacitate = result.getInt("capacitate");
                String rating = result.getString("rating");

                //Sectie sectie_noua = new Sectie(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                Local local_nou = new Local(nume, capacitate, rating);
                lista_localuri.add(local_nou);

                count++;
            }

            if (count == 0) {
                System.out.println("Niciun local nu a fost incarcat!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    public void loadComenzi(ArrayList<Comanda> lista_comenzi, ArrayList<Sofer> lista_soferi,
                          ArrayList<User> lista_useri, ArrayList<Local> lista_localuri){
        try{
            String sql = "SELECT * FROM comenzi";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                Integer numar = result.getInt("numar");
                String user_nume = result.getString("user_nume");
                String sofer_nume = result.getString("sofer_nume");
                String local_nume = result.getString("local_nume");
                String adresa = result.getString("adresa");

                Integer ns = lista_soferi.size();
                Integer nu = lista_useri.size();
                Integer nl = lista_localuri.size();

                Sofer sofer = null;
                User user = null;
                Local local = null;

                for(Integer i=0;i<ns;++i){
                    if(lista_soferi.get(i).get_nume().equals(sofer_nume)){
                        sofer = lista_soferi.get(i);
                    }
                }

                for(Integer i=0;i<nu;++i){
                    if(lista_useri.get(i).get_nume().equals(user_nume)){
                        user = lista_useri.get(i);
                    }
                }

                for(Integer i=0;i<nl;++i){
                    if(lista_localuri.get(i).get_nume().equals(local_nume)){
                        local = lista_localuri.get(i);
                    }
                }

                Comanda comanda_noua = new Comanda(numar, user, sofer, local, adresa);
                lista_comenzi.add(comanda_noua);

                count++;
            }

            if(count == 0){
                System.out.println("Nicio comanda nu a fost incarcata!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void write(Sofer sofer) {
        try {
            String sql_insert = "INSERT INTO soferi (nume, prenume, salariu) VALUES (?, ?, ?)";
            PreparedStatement sql_statement = conn.prepareStatement(sql_insert);

            sql_statement.setString(1, sofer.get_nume());
            sql_statement.setString(2, sofer.get_prenume());
            sql_statement.setInt(3, sofer.get_salariu());

            int rowsInserted = sql_statement.executeUpdate();
            if (rowsInserted == 0) {
                System.out.println("Eroare la scrierea soferului in baza de date!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void write(User user) {
        try {
            String sql_insert = "INSERT INTO useri (nume, prenume, an_nastere, cnp, tip) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sql_statement = conn.prepareStatement(sql_insert);

            sql_statement.setString(1, user.get_nume());
            sql_statement.setString(2, user.get_prenume());
            sql_statement.setInt(3, user.get_an_nastere());
            sql_statement.setString(4, user.get_cnp());
            sql_statement.setString(5, user.get_tip());

            int rowsInserted = sql_statement.executeUpdate();
            if (rowsInserted == 0) {
                System.out.println("Eroare la scrierea userului in baza de date!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void write(Local local) {
        try {
            String sql_insert = "INSERT INTO localuri (nume, capacitate, rating) VALUES (?, ?, ?)";
            PreparedStatement sql_statement = conn.prepareStatement(sql_insert);

            sql_statement.setString(1, local.get_nume());
            sql_statement.setInt(2, local.get_capacitate());
            sql_statement.setString(3, local.get_rating());

            int rowsInserted = sql_statement.executeUpdate();
            if (rowsInserted == 0) {
                System.out.println("Eroare la scrierea localului in baza de date!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void write(Comanda comanda) {
        try{
            String sql_insert = "INSERT INTO comenzi (numar, user_nume, sofer_nume, local_nume, adresa) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sql_statement = conn.prepareStatement(sql_insert);

            sql_statement.setInt(1, comanda.get_numar());
            sql_statement.setString(2, comanda.get_user().get_nume());
            sql_statement.setString(3, comanda.get_sofer().get_nume());
            sql_statement.setString(4, comanda.get_local().get_nume());
            sql_statement.setString(5, comanda.get_adresa());

            int rowsInserted = sql_statement.executeUpdate();
            if (rowsInserted == 0) {
                System.out.println("Eroare la scrierea comenzii in baza de date!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

