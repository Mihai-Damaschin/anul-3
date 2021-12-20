import java.util.ArrayList;

interface Products {
    public void showProductList();
}

public class Stoc implements Products {
    public static ArrayList<Product> products = new ArrayList<Product>() {{
        add(new Product(1, "patlajeli", 2, 1, 1.3));
        add(new Product(2, "papanasi", 5, 4.2, 5));
        add(new Product(3, "chiparusi", 7, 2, 3.3));
        add(new Product(4, "morcojiori", 1, 7, 9.2));
        add(new Product(5, "cucuruza", 3, 5, 5.2));
    }};

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public void showProductList() {
        System.out.println("Lista de produse:");
        for (Product product : products) {
            System.out.println("ID: " + product.id +
                    "\nName: " + product.name +
                    "\nCantitate: " + product.cantitate);
        }
    }
}
