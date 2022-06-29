class Ospatar extends Persoana {
    private Integer raion;
    
    public Ospatar(String nume, String prenume, Integer an_nastere, String cnp, Integer raion){
        super(nume, prenume, an_nastere, cnp);
        this.raion=raion;
    }

    public Integer get_post(){
        return this.raion;
    }
    
}