import java.time.LocalDate;
import java.util.ArrayList;

public class ToCsv {

    // constante
    private final static String ENTER = ""; // constantă pentru spațiu
    private final static String ENDL = "\n"; // constantă pentru a comuta la o linie nouă

    public static String toLineBook(Book book) {// metodă de traducere a informațiilor despre carte într-un șir cu un parametru de tip Book
        StringBuilder strB = new StringBuilder();
        // inițializați un obiect din clasa StringBuilder pentru a scrie toate informațiile într-o singură linie
        strB.append(book.getIsbn()); // adaugă isbn book la șir
        strB.append(ENTER); // separați informațiile cu un spațiu
        strB.append(book.getTitle()); // adaugă titlul cărții la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(book.getAuthor()); // adaugă autorul cărții la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(book.getGenre()); // adaugă genul cărții la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(book.getDateOfRelease()); // adaugă data de lansare a cărții la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(book.getLang()); // adaugă limba cărții la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(book.getNumberOfPages()); // adaugă numărul de pagini de carte la un șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(book.getPrice()); // adaugă prețul cărții la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(book.getAvalabil()); // adaugă accesibilitatea cărții la șir
        strB.append(ENDL); // împărțiți informațiile saltând la o linie nouă.
        // linia următoare, iar informațiile despre o altă carte vor fi scrise pe o nouă linie din fișier

        return strB.toString(); // returnează șirul rezultat
    } // metoda este închisă

    static String toLineLib(Library lib) {// metoda de traducere a informațiilor despre bibliotecă într-un șir cu un parametru de tip Library
        ArrayList<Integer> l = lib.getBooks(); // scrieți valoarea Isbn a cărților de bibliotecă în matrice
        StringBuilder strB = new StringBuilder();
        // inițializați un obiect din clasa StringBuilder pentru a scrie toate informațiile într-o singură linie
        strB.append(lib.getIdLibrary()); // adaugă id-ul bibliotecii la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(lib.getAdres()); // adăugați adresa bibliotecii la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(lib.getTelephone()); // adăugați numărul de telefon al bibliotecii la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(lib.getNumberOfBooks()); // adaugă numărul de cărți din bibliotecă la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        for (Integer integer : l) {// bucla for pentru a scrie cărțile bibliotecii ISbn după numărul lor
            strB.append(integer); // adăugarea cărților ISbn din bibliotecă la șir
            strB.append(ENTER); // separă informațiile cu un spațiu
        } // bucla este închisă
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(lib.getDistrict()); // adaugă regiunea bibliotecii la șir
        strB.append(ENDL); // separarea informațiilor prin tranziție la o nouă linie.
        // linia următoare, iar informațiile despre o altă carte vor fi scrise pe o nouă linie din fișier

        return strB.toString(); // returnează șirul rezultat
    } // metoda este închisă

    static String toLineAdLib(AdvancedLibrary lib) {// metoda de traducere a informațiilor din bibliotecă într-un șir cu un parametru de tip AdvancedLibrary
        StringBuilder strB = new StringBuilder();
        // inițializați un obiect din clasa StringBuilder pentru a scrie toate informațiile într-o singură linie
        strB.append(lib.getIdLibrary()); // adaugă id-ul bibliotecii la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(lib.getNumberOfFloors()); // adaugă numărul de etaje biblioteci la șir
        strB.append(ENTER); // separă informațiile cu un spațiu
        strB.append(lib.getLibraryName()); // adăugați numele bibliotecii la șir
        strB.append(ENDL); // separarea informațiilor prin tranziție la o nouă linie.
        // linia următoare, iar informațiile despre o altă carte vor fi scrise pe o nouă linie din fișier

        return strB.toString(); // returnează șirul rezultat
    } // metoda este închisă

    public static Book toClientBook(String line) { // metodă de transfer de la o linie la un obiect din clasa Book
        String data[] = line.split(ENTER); // creează o matrice de șiruri de caractere prin împărțirea după spațiu
        int isbn = Integer.parseInt(data[0]); // creează parametrul întreg isbn al cărții
        // prin conversia explicită a primului element al matricei de șiruri în int
        String title = data[1]; // creează parametrul titlului cărții din al treilea element al matricei de șiruri
        String author = data[2]; // creează un parametru de autor de carte din al treilea element al matricei de șiruri
        String genre = data[3]; // creează un parametru de gen de carte din al patrulea element al matricei de șiruri
        String dateStr = data[4]; // parametrul datei de lansare a cărții din al cincilea element al matricei de șiruri
        LocalDate dateOfRelease = LocalDate.parse(dateStr);
        // convertește în mod explicit șirul datei de emitere a cărții în tipul de date privind data
        String lang = data[5]; // creează un parametru de limbaj de carte din al șaselea element al matricei de șiruri
        int numOfPages = Integer.parseInt(data[6]); // parametru întreg al numărului de pagini de carte
        // prin conversia explicită a celui de-al șaptelea element al matricei de șiruri în int
        double price = Double.parseDouble(data[7]); // parametrul numărului în virgulă mobilă al prețului cărții
        // folosind o conversie explicită la tipul dublu al celui de-al optulea element al matricei de șiruri
        String avail = data[8]; // parametrul disponibilității cărții din al nouălea element al matricei de șiruri

        // creăm un obiect din clasa Book cu parametrii dați
        Book client = new Book(isbn, title, author, genre, dateOfRelease, lang, numOfPages, price, avail);
        return client; // returnează un obiect de tip Book
    } // metoda este închisă

    static Library toClientLib(String line) { // metoda de transfer de la un șir la un obiect din clasa Library
        String data[] = line.split(ENTER); // creează o matrice de șiruri de caractere prin împărțirea după spațiu
        int id = Integer.parseInt(data[0]); // creează un parametru întreg Id al bibliotecii
        // prin conversia explicită a primului element al matricei de șiruri în int
        String adres = data[1]; // parametrul adresei bibliotecii din al treilea element al matricei de șiruri
        String telephone = data[2]; // parametrul telefonului bibliotecii din al treilea element
        int n = Integer.parseInt(data[3]); // creează un parametru întreg pentru numărul de cărți
        // prin conversia explicită a celui de-al patrulea element al matricei de șiruri în int
        ArrayList<Integer> l = new ArrayList<>();
        // creează o listă pentru stocarea cărților din bibliotecă isbn
        int i = 4; // inițializează indexul elementului din tabloul de șiruri
        for (int j = 0; j < n; i++, j++) {
            // bucla pentru a scrie cărți de bibliotecă ISbn în listă până la numărul de cărți de bibliotecă
            l.add(Integer.parseInt(data[i]));
            // scrieți valoarea din elementul i al matricei de șiruri folosind o conversie explicită
        } // bucla este închisă
        String district = data[i + 1];
        // creăm un parametru de regiune de bibliotecă din elementul (i + 1) - al n-lea al matricei de șiruri

        // creăm un obiect din clasa Library cu parametrii dați
        Library lib = new Library(id, adres, telephone, n, l, district);
        return lib; // returnează un obiect Library
    } // metoda este închisă

    static AdvancedLibrary toClientAdvLib(String line) {
        // metoda de transfer de la un șir la un obiect din clasa AdvancedLibrary
        String data[] = line.split(ENTER); // creează o matrice de șiruri de caractere prin împărțirea după spațiu
        int id = Integer.parseInt(data[0]); // creează un ID de parametru întreg al bibliotecii
        // prin conversia explicită a primului element al matricei de șiruri în int
        int floors = Integer.parseInt(data[1]); // parametrul numărului de etaje din bibliotecă
        // folosind o conversie explicită în tipul int al celui de-al treilea element al matricei de șiruri
        String name = data[2]; // parametrul numelui bibliotecii din al treilea element al matricei de șiruri

        // creăm un obiect din clasa AdvancedLibrary cu acești parametri
        AdvancedLibrary client = new AdvancedLibrary(id, floors, name);
        return client; // returnează un obiect de tip AdvancedLibrary
    } // metoda este închisă
} // clasa este închisă
