package Tranzactie;

import Persoana.Persoana;
import Comanda.Comanda;

import java.time.LocalDateTime;

public class Tranzactie implements Comparable<Tranzactie> {
    private Boolean status;
    private Persoana persoana;
    private Comanda comanda;
    private LocalDateTime data_tranzactie;
    private LocalDateTime data_plata;

    public Tranzactie(Persoana persoana, Comanda comanda, LocalDateTime data_tranzactie){
        this.persoana = persoana;
        this.comanda = comanda;
        this.data_tranzactie = data_tranzactie;
        this.status = false;
        this.data_plata = null;
    }
    public Boolean get_status(){
        return this.status;
    }
    public Persoana get_persoana(){
        return this.persoana;
    }
    public Comanda get_comanda(){
        return this.comanda;
    }

    public LocalDateTime get_data_tranzactie(){
        return this.data_tranzactie;
    }

    public LocalDateTime get_data_plata(){
        return this.data_plata;
    }


    public int compareTo(Tranzactie other) {
        return this.data_tranzactie.compareTo(other.data_tranzactie);
    }

    public void platit(LocalDateTime data_plata){
        this.status = true;
        this.data_plata = data_plata;
    }
    public void afiseaza(){
        System.out.print("Comanda ");
        System.out.print(this.comanda.get_numar());
        System.out.print(" a fost efectuata de ");
        System.out.print(this.persoana.get_nume());
        System.out.print(" ");
        System.out.print(this.persoana.get_prenume());
        System.out.print(" la data de ");
        System.out.print(this.data_tranzactie);
        System.out.print("!");
    }
}