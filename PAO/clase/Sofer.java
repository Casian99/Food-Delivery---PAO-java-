class Sofer{
    private String nume;
    private String prenume;
    private Integer salariu;

    public Sofer(String nume, String prenume, Integer salariu){
        this.nume=nume;
        this.prenume=prenume;
        this.salariu = salariu;
    }

    public String get_nume(){
        return this.nume;
    }
    
    public String get_prenume(){
        return this.prenume;
    }

    public Integer get_salariu(){
        return this.salariu;
    }
}