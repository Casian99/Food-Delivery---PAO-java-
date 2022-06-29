package Gestiune;

import DataHandlerDB.DataHandlerDB;
import Persoana.Bucatar;
import Persoana.Ospatar;
import Persoana.Persoana;
import Persoana.User;
import Sofer.Sofer;
import Comanda.Comanda;
import Local.Local;
import Tranzactie.Tranzactie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Gestiune {
    ArrayList<Sofer> lista_soferi = new ArrayList<>();
    ArrayList<Local> lista_localuri = new ArrayList<>();
    ArrayList<Comanda> lista_comenzi = new ArrayList<>();
    ArrayList<User> lista_useri = new ArrayList<>();
    ArrayList<Persoana> lista_persoane = new ArrayList<>();
    NavigableSet<Tranzactie> lista_tranzactii = new TreeSet<>();
    DataHandlerDB dataHandler;


    public Gestiune() {
        dataHandler = DataHandlerDB.getDataHandlerDB();
        dataHandler.createTable_soferi();
        dataHandler.createTable_localuri();
        dataHandler.createTable_useri();
        dataHandler.createTable_comenzi();
        dataHandler.loadSoferi(lista_soferi);
        dataHandler.loadUseri(lista_useri);
        dataHandler.loadLocaluri(lista_localuri);
        dataHandler.loadComenzi(lista_comenzi,lista_soferi,lista_useri,lista_localuri);
    }

    public void adauga_bucatar(String nume, String prenume, Integer an_nastere, String cnp, String post) {
        Bucatar bucatar_nou = new Bucatar(nume, prenume, an_nastere, cnp, post);
        lista_persoane.add(bucatar_nou);
    }

    public void adauga_ospatar(String nume, String prenume, Integer an_nastere, String cnp, Integer raion) {
        Ospatar ospatar_nou = new Ospatar(nume, prenume, an_nastere, cnp, raion);
        lista_persoane.add(ospatar_nou);
    }

    public void adauga_sofer(String nume, String prenume, Integer salariu) {
        Sofer sofer_nou = new Sofer(nume, prenume, salariu);
        lista_soferi.add(sofer_nou);
        this.dataHandler.write(sofer_nou);
    }

    public void adauga_user(String nume, String prenume, Integer an_nastere, String cnp, String tip) {
        User user_nou = new User(nume, prenume, an_nastere, cnp, tip);
        lista_persoane.add(user_nou);
        lista_useri.add(user_nou);
        this.dataHandler.write(user_nou);
    }

    public void adauga_local(String nume, Integer capacitate, String rating) {
        Local local_nou = new Local(nume, capacitate, rating);
        lista_localuri.add(local_nou);
        this.dataHandler.write(local_nou);
    }

    public void adauga_comanda(Integer numar, String nume_user, String nume_sofer, String nume_local, String adresa){
        Integer ia = lista_useri.size();
        Integer ie = lista_soferi.size();
        Integer is = lista_localuri.size();

        User user = null;
        Sofer sofer = null;
        Local local = null;

        for(Integer i=0;i<ia;i++){
            if(lista_useri.get(i).get_nume().equals(nume_user)){
                user = lista_useri.get(i);
            }
        }

        for(Integer i=0;i<ie;i++){
            if(lista_soferi.get(i).get_nume().equals(nume_sofer)){
                sofer = lista_soferi.get(i);
            }
        }

        for(Integer i=0;i<is;++i){
            if(lista_localuri.get(i).get_nume().equals(nume_local)){
                local = lista_localuri.get(i);
            }
        }

        if(user != null && sofer != null && local != null){
            Comanda comanda_noua = new Comanda(numar, user, sofer, local, adresa);
            lista_comenzi.add(comanda_noua);
            this.dataHandler.write(comanda_noua);
        }
    }


    public void sterge_tabela_soferi(){
        dataHandler.deleteTable_soferi();
    }
    public void sterge_tabela_useri(){
        dataHandler.deleteTable_useri();
    }
    public void sterge_tabela_localuri(){
        dataHandler.deleteTable_localuri();
    }
    public void sterge_tabela_comenzi(){
        dataHandler.deleteTable_comenzi();
    }


    public void afiseaza_comenzi() {
        Integer n = lista_comenzi.size();

        System.out.println("\nLista comenzi:");
        for (Integer i = 0; i < n; ++i) {
            Comanda comanda = lista_comenzi.get(i);

            User user = comanda.get_user();
            Sofer sofer = comanda.get_sofer();
            Local local = comanda.get_local();

            System.out.print("Comanda #");
            System.out.print(i + 1);
            System.out.print(": ");
            System.out.print("nr.");
            System.out.print(comanda.get_numar());
            System.out.print(", ");
            System.out.print(user.get_nume());
            System.out.print(" ");
            System.out.print(user.get_prenume());
            System.out.print(", Soferul dvs:");
            System.out.print(sofer.get_nume());
            System.out.print(", Adresa: ");
            System.out.print(comanda.get_adresa());
            System.out.print(", de la Restaurantul: ");
            System.out.println(local.get_nume());
        }
    }

    public void afiseaza_useri(){
        Integer u = lista_useri.size();

        System.out.println("\nLista useri:");

        for(Integer i=0;i<u;++i){
            User user = lista_useri.get(i);
            System.out.print("Userul #");
            System.out.print(i+1);
            System.out.print(": ");
            System.out.print(user.get_nume());
            System.out.print(" ");
            System.out.print(user.get_prenume());
            System.out.print(", ");
            System.out.println(user.get_tip());
        }
    }


    public void afiseaza_localuri(){
        Integer l = lista_localuri.size();

        System.out.println("\nLista localuri:");

        for(Integer i=0;i<l;++i){
            Local local = lista_localuri.get(i);
            System.out.print("Localul #");
            System.out.print(i+1);
            System.out.print(": ");
            System.out.print(local.get_nume());
            System.out.print(", cu un total de ");
            System.out.print(local.get_capacitate());
            System.out.print(" locuri, stele: ");
            System.out.println(local.get_rating());
        }
    }

    public void emitere_tranzactie(String nume_persoana, String prenume_persoana, Integer numar_comanda){
        Integer ic = lista_comenzi.size();
        Integer ip = lista_persoane.size();

        Comanda comanda = null;
        Persoana persoana = null;

        for(int i=0;i<ic;++i){
            if(lista_comenzi.get(i).get_numar().equals(numar_comanda)){
                comanda = lista_comenzi.get(i);
            }
        }
        for(int i=0;i<ip;++i){
            Persoana persoana_curenta = lista_persoane.get(i);
            if(persoana_curenta.get_nume().equals(nume_persoana) &&
                    persoana_curenta.get_prenume().equals(prenume_persoana)){
                persoana = persoana_curenta;
            }
        }

        if(comanda != null && persoana != null){
            Tranzactie tranzactie_noua = new Tranzactie(persoana, comanda, LocalDateTime.now());
            lista_tranzactii.add(tranzactie_noua);
        }
    }

    public void finalizare_tranzactie(String nume_persoana, String prenume_persoana, Integer numar_comanda){
        Tranzactie tranzactie = null;

        Iterator iterator = lista_tranzactii.descendingIterator();

        while(iterator.hasNext()) {
            tranzactie = (Tranzactie) iterator.next();
        }

        if(tranzactie != null){
            tranzactie.platit(LocalDateTime.now());
        }
    }


    public void afiseaza_tranzactii_finalizate(){
        Iterator iterator = lista_tranzactii.descendingIterator();

        System.out.println("\nLista de comenzi finalizate:");

        while(iterator.hasNext()) {

            Tranzactie tranzactie = (Tranzactie) iterator.next();
            if (!tranzactie.get_status()) {

                System.out.print("\n");
                tranzactie.afiseaza();
            }
        }
    }


    }

