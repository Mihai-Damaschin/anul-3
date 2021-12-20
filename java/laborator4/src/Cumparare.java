public class Cumparare extends Stoc {
    @Override
    public void showProductList() {
        System.out.println("\nLista de produse pentru cumparare:");
        for (Product product : products) {
            System.out.println(product.id + ". " + product.name + " - " + product.pret_cumparare);
        }
        System.out.println();
    }
}
