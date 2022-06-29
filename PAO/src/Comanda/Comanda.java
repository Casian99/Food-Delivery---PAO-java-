package Comanda;

import Persoana.User;
import Sofer.Sofer;
import Local.Local;

public class Comanda{
    private Integer numar;
    private User user;
    private Sofer sofer;
    private Local local;
    private String adresa;

    public Comanda(Integer numar, User user, Sofer sofer, Local local, String adresa){
        this.numar=numar;
        this.user=user;
        this.sofer=sofer;
        this.local=local;
        this.adresa=adresa;
    }

    public Integer get_numar(){
        return this.numar;
    }

    public User get_user(){
        return this.user;
    }

    public Sofer get_sofer(){
        return this.sofer;
    }

    public Local get_local(){
        return this.local;
    }

    public String get_adresa(){
        return this.adresa;
    }


}