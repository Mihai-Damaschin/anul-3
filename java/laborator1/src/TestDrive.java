public class TestDrive {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane();

        System.out.println("Avionul procurat saptamina trecuta are urmatoarele carasteristici:");

        System.out.println("Categoria: " + airplane1.getCategory());
        System.out.println("Tip aeronava: " + airplane1.getCategoryName());
        System.out.println("Culoare: " + airplane1.getColor());
        System.out.println("Numar de scaune: " + airplane1.getSeats());
        System.out.println("Vat: " + airplane1.getVat());
    }
}
