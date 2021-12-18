import java.time.LocalDate;

public class Book {
    private int isbn; // declararea variabilei isbn a cartii
    private String title; // declararea variabilei titlu a cartii
    private String author;  // declararea variabilei autor a cartii
    private String genre; // declararea variabilei gen a cartii
    private LocalDate dateOfRelease;  // declararea variabilei data publicarii a cartii
    private String lang; // declararea variabilei limba a cartii
    private int numberOfPages;  // declararea variabilei numar de pagini a cartii
    private double price; // declararea variabilei pret a cartii
    private String avalabil;  // declararea variabilei disponibilitate a cartii

    // declararea constructorului clasei gol
    public Book() {
    }

    // constructorul clasei cu parametri
    public Book(int isbn, String title, String author, String genre, LocalDate dateOfRelease, String lang, int numberOfPages, double price, String avalabil) {
        this.isbn = isbn; // atribuirea unei noi valori pentru variabila isbn
        this.title = title; // atribuirea unei noi valori pentru variabila titlu
        this.author = author; // atribuirea unei noi valori pentru variabila autor
        this.genre = genre; // atribuirea unei noi valori pentru variabila gen
        this.dateOfRelease = dateOfRelease; // atribuirea unei noi valori pentru variabila data publicarii
        this.lang = lang; // atribuirea unei noi valori pentru variabila limba
        this.numberOfPages = numberOfPages; // atribuirea unei noi valori pentru variabila nr de pagini
        this.price = price; // atribuirea unei noi valori pentru variabila pret
        this.avalabil = avalabil; // atribuirea unei noi valori pentru variabila disconibilitate
    }

    // getter pentru isbn-ul cartii
    public int getIsbn() {
        return isbn; // returneaza valoarea variabilei isbn a cartii
    }

    // setter pentru isbn-ul cartii
    public void setIsbn(int isbn) {
        this.isbn = isbn; // atribuie valoarea variabilei isbn a cartii
    }

    // getter pentru titlul cartii
    public String getTitle() {
        return title; // returneaza valoarea variabilei titlu a cartii
    }

    // setter pentru titlul cartii
    public void setTitle(String title) {
        this.title = title; // atribuie valoarea variabilei titlu a cartii
    }

    // getter pentru autorul cartii
    public String getAuthor() {
        return author; // returneaza valoarea variabilei autorului a cartii
    }

    // setter pentru autorul cartii
    public void setAuthor(String author) {
        this.author = author; // atribuie valoarea variabilei autor a cartii
    }

    // getter pentru genul cartii
    public String getGenre() {
        return genre; // returneaza valoarea variabilei genul a cartii
    }

    // setter pentru genul cartii
    public void setGenre(String genre) {
        this.genre = genre; // atribuie valoarea variabilei genul a cartii
    }

    // getter pentru date publicarii cartii
    public LocalDate getDateOfRelease() {
        return dateOfRelease; // returneaza valoarea variabilei date publicarii a cartii
    }

    // setter pentru autorul cartii
    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease; // atribuie valoarea variabilei data publicarii a cartii
    }

    // getter pentru limba cartii
    public String getLang() {
        return lang; // returneaza valoarea variabilei limba a cartii
    }

    // setter pentru limba cartii
    public void setLang(String lang) {
        this.lang = lang; // atribuie valoarea variabilei limba a cartii
    }

    // getter pentru numarul de pagini a cartii
    public int getNumberOfPages() {
        return numberOfPages; // returneaza valoarea variabilei nr de pagini a cartii
    }

    // setter pentru numarul de pagini a cartii
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages; // atribuie valoarea variabilei nr de pagini a cartii
    }

    // getter pentru pretul cartii
    public double getPrice() {
        return price; // returneaza valoarea variabilei pretul a cartii
    }

    // setter pentru pretul cartii
    public void setPrice(double price) {
        this.price = price; // atribuie valoarea variabilei pretul cartii
    }

    // getter pentru disponibilitatea cartii
    public String getAvalabil() {
        return avalabil;  // returneaza valoarea variabilei disponibilitate a cartii
    }

    // setter pentru disponibilitatea cartii
    public void setAvalabil(String avalabil) {
        this.avalabil = avalabil; // atribuie valoarea variabilei disponibilitatea cartii
    }

    // cuvint cheie ce indica supraincarcarea metodei
    @Override
    // declararea metodei ce permite obtinerea unui hash
    public int hashCode() {
        int hash = 5;  // declararea si initializarea variabilei de hash
        hash = 79 * hash + this.isbn; // algoritmul ce genereaza un hash code
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
        final Book other = (Book) obj;
        // se atribuie clasei other metodele clasei Book ce se contin in obiectul obj
        // returneaza True, da nici o conditie de mai sus nu este satisfacuta
        // declararea si initializarea obiectului final clasei prin other
        return this.isbn == other.isbn;
    }

    // cuvint cheie ce indica supraincarcarea metodei
    @Override
    // Declarea metodei ce returneaza atributele clasei intr-un string
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", author=" + author + ", genre=" + genre + ", dateOfRelease=" + dateOfRelease + ", lang=" + lang + ", numberOfPages=" + numberOfPages + ", price=" + price + ", avalabil=" + avalabil + '}';
    }
}// inchiderea clasei Library

