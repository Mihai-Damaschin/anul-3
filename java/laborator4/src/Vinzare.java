public class Vinzare extends Stoc {
    @Override
    public void showProductList() {
        System.out.println("\nLista de produse pentru vinzare:");
        for (Product product : products) {
            System.out.println(product.id + ". " + product.name + " - " + product.pret_vinzare);
        }
        System.out.println();
    }
}
