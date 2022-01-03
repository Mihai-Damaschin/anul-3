import java.util.StringTokenizer;

public class TestClass {
    public static void main(String[] args) {
        ContBancar contBancar = new ContBancar();
        ContBancarExtins contBancarExtins = new ContBancarExtins(10, 10);

        contBancarExtins.display();
        contBancarExtins.adaugaDobindaAnuala();

        System.out.println("In urma obtinerii dobinzii avem in cont: " + contBancar.getSum());

        contBancar.extract(2);

        System.out.println("In urma extragerii avem in cont: " + contBancar.getSum());

        StringTokenizer st = new

                StringTokenizer("Programul in Java");

        while (st.hasMoreTokens()){

            System.out.println("urmatorul cuvant: " +

                    st.nextToken());

        }
    }
}
