public class ContBancarExtins extends ContBancar {
    double dobinda;

    ContBancarExtins(double $sum, double $dobinda) {
        new ContBancar($sum);

        dobinda = $dobinda;
    }

    public void adaugaDobindaAnuala() {
        add(getSum() * (dobinda / 100));
    }

    @Override
    public void display() {
        System.out.println("Balanta actuala este: " + sum + " iar dobinda este: " + dobinda);
    }
}
