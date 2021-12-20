public class Magazin extends Stoc {
    public static void main(String[] args) {
        Stoc stoc = new Stoc();
        stoc.showProductList();

        Cumparare cumparare = new Cumparare();
        cumparare.showProductList();

        Vinzare vinzare = new Vinzare();
        vinzare.showProductList();
    }
}
