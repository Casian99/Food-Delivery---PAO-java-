import DataHandler.DataHandler;
import Gestiune.Gestiune;

public class Main {
    public static void main(String[] args) {


        Gestiune gestiune = new Gestiune();

/*
        gestiune.adauga_sofer("Popescu", "Mihai", 1200);
        gestiune.adauga_sofer("Lazar", "Ioan", 1200);
        gestiune.adauga_sofer("Filip", "Paul", 1200);
        gestiune.adauga_sofer("Georgescu", "Vlad", 1200);


        gestiune.adauga_user("Jarda","Andrei", 1999, "5010904332211", "fidel");
        gestiune.adauga_user("Riclea","Costel", 2002, "5010980832211", "fidel");
        gestiune.adauga_user("Jurca","Sandu", 2001, "5010912332211", "standard");
        gestiune.adauga_user("Dima","Andrei", 2005, "5010967832211", "standard");


        gestiune.adauga_local("Padrino", 40, "*****");
        gestiune.adauga_local("Eker", 45, "****");
        gestiune.adauga_local("Epic", 30, "***");
        gestiune.adauga_local("Apropo", 28, "*****");


        gestiune.adauga_comanda(1, "Jarda", "Popescu", "Padrino", "Brailita 9");
        gestiune.adauga_comanda(2, "Riclea", "Lazar", "Eker", "Unirii 7");
        gestiune.adauga_comanda(3, "Jurca", "Filip", "Epic", "Universitate 4");
        gestiune.adauga_comanda(4, "Dima", "Georgescu", "Apropo", "Mihai Bravu 3");
        gestiune.adauga_comanda(5, "Dima", "Lazar", "Eker", "Brailita 1");




 */




        gestiune.adauga_sofer("Nume1", "Prenume1", 1111);
        gestiune.adauga_sofer("Nume2", "Prenume2", 2222);
        gestiune.adauga_user("User1","User2", 2000, "1111111111111", "tip1");
        gestiune.adauga_user("Riclea","Costel", 2010, "2222222222222", "tip2");
        gestiune.adauga_local("Local1", 11, "*");
        gestiune.adauga_local("Local2", 22, "**");
        gestiune.adauga_comanda(6, "Nume1", "User1", "Local1", "Strada 1");
        gestiune.adauga_comanda(7, "Nume2", "User2", "Local2", "Strada 2");





        gestiune.adauga_ospatar("Apopei", "Sergiu", 2000, "500711273351", 2);
        gestiune.adauga_ospatar("Gradinariu", "Teodor", 2001, "500713003381", 3);
        gestiune.adauga_ospatar("Morosan", "Victor", 2004, "500711873352", 9);

        gestiune.adauga_bucatar("Remus", "George", 1991, "472823113823", "sef");
        gestiune.adauga_bucatar("Ursu", "Calin", 1999, "472866743823", "ajutor");
        gestiune.adauga_bucatar("Surugiu", "Matei", 2000, "4728250543823", "sef");


        gestiune.emitere_tranzactie("Jarda", "Andrei", 1);
        gestiune.emitere_tranzactie("Riclea", "Costel", 2);
        gestiune.emitere_tranzactie("Jurca", "Sandu", 3);
        gestiune.emitere_tranzactie("Dima", "Andrei", 4);


        gestiune.finalizare_tranzactie("Jarda", "Andrei", 1);
        gestiune.finalizare_tranzactie("Riclea", "Costel", 2);
        gestiune.finalizare_tranzactie("Jurca", "Sandu", 2);
        // se afiseaza doar comanda 2 deoarece celelalte doua comenzi au date de intrare eronate






        gestiune.sterge_tabela_soferi();
        gestiune.sterge_tabela_useri();
        gestiune.sterge_tabela_localuri();
        gestiune.sterge_tabela_comenzi();


        gestiune.afiseaza_useri();
        gestiune.afiseaza_localuri();
        gestiune.afiseaza_comenzi();
        gestiune.afiseaza_tranzactii_finalizate();




    }

}
