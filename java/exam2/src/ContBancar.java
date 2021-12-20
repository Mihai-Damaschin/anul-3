interface SetDisplay {
    public void display();
}

public class ContBancar implements SetDisplay {
    static double sum;

    ContBancar() {
    }

    ContBancar(double number) {
        sum = number;
    }

    public void add(double number) {
        sum += number;
    }

    public boolean extract(double number) {
        if (number < sum) {
            sum -= number;

            return true;
        }

        return false;
    }

    public double getSum() {
        return sum;
    }
    @Override
    public void display() {
        System.out.println("Balanta actuala este: " + sum);
    }
}
