class User extends Persoana{
    private String tip;

    public User(String nume, String prenume, Integer an_nastere, String cnp, String tip){
        super(nume,prenume,an_nastere,cnp);
        this.tip=tip;
    }

    public String get_tip(){
        return this.tip;
    }
}