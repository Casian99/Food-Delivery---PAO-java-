class Comanda{
    private Integer numar;
    private Integer suma;
    private Integer nr_produse;

    public Comanda(Integer numar, Integer suma, Integer nr_produse){
        this.numar=numar;
        this.suma=suma;
        this.nr_produse=nr_produse;
    }

    public Integer get_numar(){
        return this.numar;
    }

    public Integer get_suma(){
        return this.suma;
    }

    public Integer get_nr_produse(){
        return this.nr_produse;
    }
}