class Local{
    private String nume;
    private Integer capacitate;
    private String rating;

    public Local(String nume, Integer capacitate, String rating){
        this.nume=nume;
        this.capacitate=capacitate;
        this.rating=rating;
    }

    public String get_nume(){
        return this.nume;
    }

    public Integer get_capacitate(){
        return this.capacitate;
    }

    public String get_rating(){
        return this.rating;
    }
}