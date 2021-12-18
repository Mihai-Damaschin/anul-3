public class AdvancedLibrary extends Library { // extinde clasa Library

    private int id; // declararea variabilei Id a bibliotecii
    private int numberOfFloors; // declararea variabilei nr de etaje a bibliotecii
    private String libraryName; // declararea variabilei denumire a bibliotecii

    public AdvancedLibrary() { // declararea constructorului clasei gol
    }

    // constructorul clasei cu parametri
    public AdvancedLibrary(int id, int numberOfFloors, String libraryName) {
        this.id = id; // atribuirea unei noi valori pentru variabila id
        this.numberOfFloors = numberOfFloors; // atribuirea unei noi valori pentru variabila ne de etaje
        this.libraryName = libraryName; // atribuirea unei noi valori pentru variabila nume
    }

    // getter pentru id-ul bibliotecii
    public int getId() {
        return id; // returneaza valoarea variabilei id-ului bibliotecii
    }

    // setter pentru id-ul bibliotecii
    public void setId(int id) {
        this.id = id; // atribuie valoarea variabilei id-ului bibliotecii
    }

    // getter pentru numele bibliotecii
    public String getLibraryName() {
        return libraryName; // returneaza valoarea variabilei numele bibliotecii
    }

    // setter pentru numele bibliotecii
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName; // atribuie valoarea variabilei numele bibliotecii
    }

    // getter pentru nr de etaje bibliotecii
    public int getNumberOfFloors() {
        return numberOfFloors; // returneaza valoarea variabilei nr de etaje a bibliotecii
    }

    // setter pentru nr de etaje bibliotecii
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors; // atribuie valoarea variabilei nr de etaje a bibliotecii
    }

    // cuvint cheie ce indica supraincarcarea metodei
    @Override
    // Declarea metodei ce returneaza atributele clasei intr-un string
    public String toString() {
        return "AdvancedLibrary{" + "id=" + id + ", numberOfFloors=" + numberOfFloors +
                ", libraryName=" + libraryName + '}';
    }
}//закрывается класс AdvancedLibrary

