interface VehiculInterface {
    public void getNrDeRoti();
}

public class Vehicul implements VehiculInterface {
    public static void main(String[] args) {
        Vehicul vehicul1 = new Vehicul();
        vehicul1.getNrDeRoti();

        Motocicleta motocicleta1 = new Motocicleta();
        motocicleta1.getNrDeRoti();

        Autocamion autocamion1 = new Autocamion();
        autocamion1.getNrDeRoti();
    }

    @Override
    public void getNrDeRoti() {
        System.out.println("Acest vehicul nu are roti");
    }
}

