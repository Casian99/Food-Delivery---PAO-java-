package Persoana;

import Persoana.Persoana;

public class Bucatar extends Persoana {
    private String post;

    public Bucatar(String nume, String prenume, Integer an_nastere, String cnp, String post){
        super(nume, prenume, an_nastere, cnp);
        this.post=post;
    }

    public String get_post(){
        return this.post;
    }

}