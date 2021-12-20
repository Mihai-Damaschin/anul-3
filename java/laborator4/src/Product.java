public class Product {
    public int id;
    public String name;
    public int cantitate;
    public double pret_cumparare;
    public double pret_vinzare;

    public Product() {
    }

    public Product(int id, String name, int cantitate, double pret_cumparare, double pret_vinzare) {
        this.id = id;
        this.name = name;
        this.cantitate = cantitate;
        this.pret_cumparare = pret_cumparare;
        this.pret_vinzare = pret_vinzare;
    }
}
