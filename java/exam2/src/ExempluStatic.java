class ExempluStatic {

    public static int atributStatic = 15;

    public int atributNeStatic = 15;

    public static void main(String[] argv) {

        ExempluStatic e1 = new ExempluStatic();

        ExempluStatic e2 = new ExempluStatic();

        e1.atributStatic = 25;

        e1.atributNeStatic = 25;

        System.out.println("Valoarea S" + e2.atributStatic);

        System.out.println("Valoarea NeS" + e2.atributNeStatic);
    }
}