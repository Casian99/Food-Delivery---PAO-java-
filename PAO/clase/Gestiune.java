import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

class Gestiune {
    ArrayList<Sofer> lista_soferi = new ArrayList<>();
    ArrayList<Local> lista_localuri = new ArrayList<>();
    ArrayList<Comanda> lista_comenzi = new ArrayList<>();
    ArrayList<User> lista_useri = new ArrayList<>();
    ArrayList<Persoana> lista_persoane = new ArrayList<>();
    NavigableSet<Tranzactie> lista_tranzactii = new TreeSet<>();
    

    public Gestiune(){

    }

    public void adauga_bucatar(String nume, String prenume, Integer an_nastere, String cnp, String post){
        Bucatar bucatar_nou = new Bucatar(nume, prenume, an_nastere, cnp, post);
        lista_persoane.add(bucatar_nou);
    }
    public void adauga_ospatar(String nume, String prenume, Integer an_nastere, String cnp, Integer raion){
        Ospatar ospatar_nou = new Ospatar(nume, prenume, an_nastere, cnp, raion);
        lista_persoane.add(ospatar_nou);
    }

    public void adauga_sofer(String nume, String prenume, Integer salariu){
        Sofer sofer_nou = new Sofer(nume, prenume, salariu);
        lista_soferi.add(sofer_nou);
    }

    public void adauga_user(String nume, String prenume, Integer an_nastere, String cnp, String tip){
        User user_nou = new User(nume, prenume, an_nastere, cnp, tip);
        lista_persoane.add(user_nou);
    }

    
        