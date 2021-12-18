import java.util.ArrayList;

public class Library {
    private int idLibrary; // declararea variabilei Id a bibliotecii
    private String adres; // declararea variabilei adresei a bibliotecii
    private String telephone; // declararea variabilei telefon a bibliotecii
    private int numberOfBooks; // declararea variabilei numar de carti a bibliotecii
    private ArrayList<Integer> books; // declararea variabilei carti a bibliotecii
    private String district; // declararea variabilei raion a bibliotecii

    public Library() { // declararea constructorului clasei gol
    }

    // constructorul clasei cu parametri
    public Library(int idLibrary, String adres, String telephone, int numberOfBooks, ArrayList<Integer> books, String district) {
        this.idLibrary = idLibrary; // atribuirea unei noi valori pentru variabila id
        this.adres = adres; // atribuirea unei noi valori pentru variabila adresa
        this.telephone = telephone; // atribuirea unei noi valori pentru variabila telefon
        this.numberOfBooks = numberOfBooks; // atribuirea unei noi valori pentru variabila numar de carti
        this.books = books; // atribuirea unei noi valori pentru variabila carti
        this.district = district; // atribuirea unei noi valori pentru variabila raion
    }

    // getter pentru raionul bibliotecii
    public String getDistrict() {
        return district; // returneaza valoarea variabilei raion a bibliotecii
    }

    // setter pentru raionul bibliotecii
    public void setDistrict(String district) {
        this.district = district; // atribuie valoarea variabilei raion a bibliotecii
    }

    // getter pentru id bibliotecii
    public int getIdLibrary() {
        return idLibrary; // returneaza valoarea variabilei id a bibliotecii
    }

    //сеттер для переменной  кода библиотеки
    public void setIdLibrary(int idLibrary) {
        this.idLibrary = idLibrary; // atribuie valoarea variabilei id a bibliotecii
    }

    // getter pentru adresa bibliotecii
    public String getAdres() {
        return adres; // returneaza valoarea variabilei adresa a bibliotecii
    }

    // setter pentru adresa bibliotecii
    public void setAdres(String adres) {
        this.adres = adres; // atribuie valoarea variabilei adresa a bibliotecii
    }

    // getter pentru numarul de telefon a bibliotecii
    public String getTelephone() {
        return telephone;// returneaza valoarea variabilei telefon a bibliotecii
    }

    // setter pentru numarul de telefon a bibliotecii
    public void setTelephone(String telephone) {
        this.telephone = telephone; // atribuie valoarea variabilei telefon a bibliotecii
    }

    // getter pentru numarul de carti a bibliotecii
    public int getNumberOfBooks() {
        return numberOfBooks; // returneaza valoarea variabilei nr de carti a bibliotecii
    }

    // setter pentru numarul de carti a bibliotecii
    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks; // atribuie valoarea variabilei nr de carti a bibliotecii
    }

    // getter pentru lista de carti a bibliotecii
    public ArrayList<Integer> getBooks() {
        return books; // returneaza valoarea variabilei carti a bibliotecii
    }

    // setter pentru lista de carti a bibliotecii
    public void setBooks(ArrayList<Integer> books) {
        this.books = books;  // atribuie valoarea variabilei carti a bibliotecii
    }

    // cuvint cheie ce indica supraincarcarea metodei
    @Override
    // declararea metodei ce permite obtinerea unui hash
    public int hashCode() {
        int hash = 7; // declararea si initializarea variabilei de hash
        hash = 79 * hash + this.idLibrary; // algoritmul ce genereaza un hash code
        return hash; // returnarea hash-ului obtinut
    }

    // cuvint cheie ce indica supraincarcarea metodei
    @Override
    // declararea metodei ce permite compararea a doua clase
    public boolean equals(Object obj) {
        if (this == obj) {  // se verifica daca obiectul este el insusi
            return true; // se returneaza True daca conditia este satisfacuta
        }
        if (obj == null) { // se verifica daca obiectul nu este gol
            return false; // se returneaza False daca conditia este satisfacuta
        }
        if (getClass() != obj.getClass()) { // se verifica daca obiectul nu este este obiect al clasei date
            return false; // se returneaza False daca conditia este satisfacuta
        }
        final Library other = (Library) obj;
        // se atribuie clasei other metodele clasei Library ce se contin in obiectul obj
        // returneaza True, da nici o conditie de mai sus nu este satisfacuta
        // declararea si initializarea obiectului final clasei prin other
        return this.idLibrary == other.idLibrary;
    }

    // cuvint cheie ce indica supraincarcarea metodei
    @Override
    // Declarea metodei ce returneaza atributele clasei intr-un string
    public String toString() {
        return "Library{" + "idLibrary=" + idLibrary + ", adres=" + adres + ", telephone=" +
                telephone + ", numberOfBooks=" + numberOfBooks + ", books=" + books +
                ", district=" + district + '}';
    }
}// inchiderea clasei Library

