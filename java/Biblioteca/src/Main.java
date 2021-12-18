import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {  // deschide clasa
    // initializeaza logger-ul de erori si exceptii
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    static Scanner sc = new Scanner(System.in); // initializarea scanerului de date ce sunt introduse in consola

    static ArrayList<Library> libList = new ArrayList<>(); // initializarea listei de biblioteci
    static ArrayList<Book> bookList = new ArrayList<>(); // initializarea listeie de carti
    static ArrayList<AdvancedLibrary> advList = new ArrayList<>();
    // initializarea listei de biblioteci cu parametri extinsi

    public static void main(String[] args) {
        // metoda main, care face posibila executarea clasei pentru compilator
        menu();  // apelarea functiei menu
    } // inchiderea metodei

    public static void numberOfLibsThatStartWith45() {
        // Declararea metodei ce determina numarul de biblioteci a caror numarul de telefon incepe cu 45
        int numOfLibs = 0; // inițializarea numărului de biblioteci, acestea sunt încă 0
        for (Library lib1 : libList) {// îmbunătățit pentru bucla peste lista de biblioteci
            if (lib1.getTelephone().startsWith("45")) {// verificați dacă condiția este îndeplinită
                numOfLibs++; // dacă condiția este adevărată, numărul de biblioteci crește cu 1
            } // instrucțiunea if este închisă
        } // bucla este închisă
        System.out.println("Număr de biblioteci al căror număr de telefon începe cu 45 =" + numOfLibs); // scoate rezultatul în consolă
    } // metoda este închisă

    public static void booksWithMaxPages() {
        // Metodă de determinare a numărului de cărți cu numărul maxim de pagini
        int maxNumOfPages = 0;
        // inițializare cu o variabilă care conține valoarea maximă a paginilor din carte
        int counter = 0; // inițializați contorul de cărți
        for (Book book : bookList) {// îmbunătățit pentru bucla pe lista de cărți
            if (book.getNumberOfPages() > maxNumOfPages) {
                // dacă numărul de pagini din carte este mai mare decât valoarea maximă
                maxNumOfPages = book.getNumberOfPages();
                // valoarea maximă este modificată de numărul de pagini ale cărții curente
            } // instrucțiunea if este închisă
        } // bucla este închisă
        System.out.println("Cartile cu numarul maxim de pagini:"); // scoate informații în consolă
        for (Book book : bookList) {// îmbunătățit pentru bucla pe lista de cărți
            if (book.getNumberOfPages() == maxNumOfPages) {
                // dacă numărul de pagini ale cărții curente se potrivește cu numărul maxim
                System.out.println(book.toString()); // informațiile despre această carte sunt tipărite pe consolă
                counter++; // contorul este incrementat cu 1
            } // instrucțiunea if este închisă
        } // bucla este închisă
        System.out.println("Număr de cărți cu număr maxim de pagini =" + counter);
        // trimite informații despre numărul de cărți cu numărul maxim de pagini către consolă
    } // metoda este închisă

    public static void libsWithFloors() {
        // Metodă de numărare a numărului de biblioteci cu numărul de etaje introdus de la tastatură dintr-un anumit interval
        int counter = 0; // inițializați numărul de biblioteci
        System.out.println("Vă rugăm să introduceți numărul de etaje (de la 1 la 7) în bibliotecă:");
        // scoateți informații în consolă și cereți o anumită valoare
        int floors = sc.nextInt(); // inițializați variabila numărului necesar de etaje și a acesteia
        // determinăm valoarea sa folosind Scanner din consolă
        for (AdvancedLibrary lib : advList) {
            // îmbunătățit pentru lista de buclă bazată pe clasa Bibliotecă avansată
            if (lib.getNumberOfFloors() == floors) {
                // dacă numărul de etaje ale unei anumite biblioteci se potrivește cu cel dat
                counter++; // contorul este incrementat cu unu
            } // instrucțiunea if este închisă
        } // bucla este închisă
        System.out.println("Număr de biblioteci cu" + floors + "etaje =" + counter);
        // scoateți informații și rezultat în consolă
    } // metoda este închisă

    public static void insertBooks() {// Metodă de introducere a informațiilor despre cărți în listă
        System.out.println("Vă rugăm să introduceți numărul de cărți:"); // indiciu pentru utilizator
        int n = sc.nextInt(); // inițializarea numărului de cărți introduse din consolă
        System.out.println("Vă rugăm să introduceți informațiile despre" + n + "cărți");
        // indiciu pentru utilizator
        for (int i = 0; i < n; i++) {// bucla for
            Book b = new Book(); // inițializarea unui nou obiect al clasei de carte
            System.out.println("Cartea #" + i + 1); // indiciu pentru utilizator
            System.out.println("ISBN:"); // indiciu pentru utilizator
            b.setIsbn(sc.nextInt()); // atribuirea valorii isbn prin intermediul consolei
            System.out.println("Titlu:"); // indiciu pentru utilizator
            b.setTitle(sc.next()); // atribuirea valorii titlului cărții prin intermediul consolei
            System.out.println("Autor:"); // indiciu pentru utilizator
            b.setAuthor(sc.next()); // atribuirea valorii autorului prin consolă
            System.out.println("Gen:"); // indiciu pentru utilizator
            b.setGenre(sc.next()); // atribuirea valorii genului prin consolă
            System.out.println("Data lansării aaaa-ll-zz:"); // indiciu pentru utilizator
            b.setDateOfRelease(LocalDate.parse(sc.next()));
            // atribuiți valoarea datei de lansare prin consolă
            System.out.println("Limba:"); // indiciu pentru utilizator
            b.setLang(sc.next()); // atribuirea unei valori de limbă prin consolă
            System.out.println("Număr de pagini:"); // indiciu pentru utilizator
            b.setNumberOfPages(sc.nextInt()); // atribuirea valorilor paginii prin intermediul consolei
            System.out.println("Preț:"); // indiciu pentru utilizator
            b.setPrice(sc.nextDouble()); // atribuirea valorii prețului prin consolă
            System.out.println("Disponibilitate:"); // indiciu pentru utilizator
            b.setAvalabil(sc.next()); // atribuirea valorii de accesibilitate prin consolă
            bookList.add(b); // adaugă un obiect la listă
        } // bucla este închisă
    } // metoda este închisă

    public static void insertLibraries() {// Metodă de introducere a informațiilor despre biblioteci în listă
        System.out.println("Vă rugăm să introduceți numărul de biblioteci:"); // indiciu pentru utilizator
        int n = sc.nextInt(); // inițializarea numărului de biblioteci introduse din consolă
        System.out.println("Vă rugăm să introduceți informațiile despre" + n + "biblioteci"); // indiciu pentru utilizator

        for (int i = 0; i < n; i++) {// bucla for
            Library l = new Library(); // inițializarea unui nou obiect al clasei de bibliotecă
            System.out.println("Biblioteca #" + (i + 1)); // indiciu pentru utilizator
            System.out.println("ID:"); // indiciu pentru utilizator
            l.setIdLibrary(sc.nextInt()); // atribuirea valorii id-ului bibliotecii prin consolă
            System.out.println("Adresă:"); // indiciu pentru utilizator
            l.setAdres(sc.next()); // atribuirea valorii adresei prin consolă
            System.out.println("Număr de telefon:"); // indiciu pentru utilizator
            l.setTelephone(sc.next()); // atribuirea valorii numărului de telefon prin consolă
            System.out.println("Număr de cărți:"); // indiciu pentru utilizator
            l.setNumberOfBooks(sc.nextInt()); // atribuirea valorii numărului de cărți prin intermediul consolei
            ArrayList<Integer> lb = new ArrayList<>();
            // inițializați lista clasei ArrayList de tip întreg
            for (int j = 0; j < l.getNumberOfBooks(); j++) {// bucla for
                System.out.println("ISBN al cărții #" + (j + 1) + ":");
                // indiciu pentru utilizator
                lb.add(sc.nextInt()); // atribuirea valorii isbn cărților prin consolă
                l.setBooks(lb); // adaugă cărți ISbn la listă
            } // bucla este închisă
            System.out.println("District:"); // indiciu pentru utilizator
            l.setDistrict(sc.next()); // atribuirea valorii regiunii prin consolă
            libList.add(l); // adaugă un obiect la listă
            System.out.println("Doriți să introduceți și informații avansate despre această bibliotecă?"); // Sugestie pentru utilizator
            System.out.println("'y' - yes"); // indiciu pentru utilizator
            System.out.println("'n' - nu"); // indiciu pentru utilizator
            System.out.println("Alegerea dvs. ->"); // indiciu pentru utilizator
            String ch = sc.next(); // citește selecția din consolă
            if ("y".equals(ch)) {// dacă utilizatorul a ales să adauge informații
                insertAdvancedLib(l.getIdLibrary());
                // apelează metoda de completare a informațiilor în clasa AdvancedLibrary
                exportAdLib(); // apelează metoda de export a datelor din listă de tip AdvancedLibrary
            } // instrucțiunea if este închisă
        } // bucla este închisă
    } // metoda este închisă

    private static void insertAdvancedLib(int id) {
        // Metodă de introducere a informațiilor despre bibliotecile cu parametri extinși în listă
        AdvancedLibrary al = new AdvancedLibrary();
        // inițializarea unui nou obiect al clasei de biblioteci cu add. parametrii
        al.setId(id); // atribuirea valorii id din clasa Library
        System.out.println("Număr de etaje:"); // indiciu pentru utilizator
        al.setNumberOfFloors(sc.nextInt()); // atribuirea valorii etajelor prin intermediul consolei
        System.out.println("Numele bibliotecii:"); // indiciu pentru utilizator
        al.setLibraryName(sc.next()); // atribuirea valorii numelui prin consola
        advList.add(al); // adaugă un obiect la listă
    } // metoda este închisă

    private static void exportBook() {
        // Metodă pentru exportarea informațiilor despre cărți într-un fișier text
        try (FileWriter fileW = new FileWriter("bookList.csv")) {
            // încercați cu resurse, inițializați și deschideți fluxul FileWriter cu c
            // parametrul de destinație al fișierului
            for (Book user : bookList) {// îmbunătățit pentru bucla pe lista de cărți
                String line = ToCsv.toLineBook(user);
                // inițializarea șirului introdus în fișier cu șirul returnat al metodei apelate
                fileW.write(line); // scrie linia în fișier
            } // bucla este închisă
        } catch (IOException ex) {
            // captează excepțiile care pot apărea în timpul execuției codului în încercare,
            // Se așteaptă eroare I/O
            LOG.log(Level.SEVERE, null, ex); // Ieșire de eroare către consolă prin intermediul loggerului
        } // legătura try-catch este închisă, FileWriter este închis automat
    } // metoda este închisă

    private static void exportLib() {
        // Metodă pentru exportarea informațiilor despre biblioteci într-un fișier text
        try (FileWriter fileW = new FileWriter("libraryList.csv")) {
            // try-with-resources, inițializat și
            // deschide un flux FileWriter cu un parametru de destinație a fișierului
            for (Library user : libList) {// bucla for îmbunătățită pe lista bibliotecii
                String line = ToCsv.toLineLib(user);
                // inițializarea șirului introdus în fișier cu șirul returnat al metodei apelate
                fileW.write(line); // scrie linie în fișier
            } // bucla este închisă
        } catch (IOException ex) {
            // captează excepțiile care pot apărea în timpul execuției codului în încercare,
            // Se așteaptă eroare I/O
            LOG.log(Level.SEVERE, null, ex); // ieșire de eroare către consolă prin intermediul loggerului
        } // legătura try-catch este închisă, FileWriter este închis automat
    } // metoda este închisă

    private static void exportAdLib() {
        // Metodă de export de informații despre biblioteci cu add. parametri într-un fișier text
        try (FileWriter fileW = new FileWriter("libraryAdvancedList.csv")) {
            // try-with-resources, inițializat și
            // deschide un flux FileWriter cu un parametru de destinație a fișierului
            for (AdvancedLibrary user : advList) {// îmbunătățit pentru bucla pe lista de biblioteci
                String line = ToCsv.toLineAdLib(user);
                // inițializarea șirului introdus în fișier cu șirul returnat al metodei apelate
                fileW.write(line); // scrie linie în fișier
            } // bucla este închisă
        } catch (IOException ex) {
            // captează excepțiile care pot apărea în timpul execuției codului în încercare,
            // Se așteaptă eroare I/O
            LOG.log(Level.SEVERE, null, ex); // Ieșire de eroare către consolă prin intermediul loggerului
        } // legătura try-catch este închisă, FileWriter este închis automat
    } // metoda este închisă

    private static void importBook() {
        // Metodă de importare a informațiilor despre cărți într-un fișier text
        List<Book> list = new ArrayList();
        try (FileReader fileR = new FileReader("bookList.csv")) {
            // try-with-resources, inițializat și
            // deschide un flux FileReader cu un parametru de destinație a fișierului
            BufferedReader buffR = new BufferedReader(fileR);
            // inițializați un obiect din clasa BufferedReader din fluxul FileReader
            // pentru citirea optimă din fișier
            String line = null; //инициализация считываемой строки
            while ((line = buffR.readLine()) != null) {
                // buclă while atâta timp cât există linia citită din fișier
                Book cl = ToCsv.toClientBook(line);
                // creează un nou obiect din clasa cărților cu parametrii returnați de metodele apelate
                list.add(cl);// adaugă un obiect de clasă de carte la listă
            } // bucla este închisă
        } catch (IOException ex) {
            // captează excepțiile care pot apărea în timpul execuției codului în încercare,
            // aștept erori I/O și fișierul nu a fost găsit
            LOG.log(Level.SEVERE, null, ex);// ieșire de eroare către consolă prin intermediul loggerului
        }// legătura try-catch este închisă, FileReader este închis automat
        bookList = (ArrayList<Book>) list; // atribuie o nouă valoare listei de cărți
        for (Book b : bookList) { // bucla for îmbunătățită pentru lista de cărți
            System.out.println(b.toString());
            // afișează informații pe ecran folosind metoda toString ().
        } // bucla este închisă
    } // metoda este închisă

    private static void importLib() {
        // Metodă de importare a informațiilor despre biblioteci într-un fișier text
        List<Library> list = new ArrayList();
        try (FileReader fileR = new FileReader("libraryList.csv")) {
            // try-with-resources, inițializat și
            // deschide un flux FileReader cu un parametru de destinație a fișierului
            BufferedReader buffR = new BufferedReader(fileR);
            // inițializați un obiect din clasa BufferedReader din fluxul FileReader
            // pentru citirea optimă din fișier
            String line = null; // inițializarea liniei de citire
            while ((line = buffR.readLine()) != null) {
                // buclă while atâta timp cât există linia citită din fișier
                Library cl = ToCsv.toClientLib(line);
                // creăm un nou obiect al clasei bibliotecii cu parametrii returnați de metodele apelate
                list.add(cl); // adaugă un obiect de clasă de carte la listă
            } // bucla este închisă
        } catch (IOException ex) {
            // captează excepțiile care pot apărea în timpul execuției codului în încercare,
            // aștept erori I/O și fișierul nu a fost găsit
            LOG.log(Level.SEVERE, null, ex);// ieșire de eroare către consolă prin intermediul loggerului
        }// legătura try-catch este închisă, FileReader este închis automat
        libList = (ArrayList<Library>) list;// atribuiți o nouă valoare listei de biblioteci
        for (Library l : libList) {// bucla for îmbunătățită în lista de biblioteci
            System.out.println(l.toString());
            // afișează informații pe ecran folosind metoda toString ().
        } // bucla este închisă
    } // metoda este închisă

    private static void importAdvLib() {
        // Metodă de importare a informațiilor despre biblioteci cu add. parametri într-un fișier text
        List<AdvancedLibrary> list = new ArrayList();
        try (FileReader fileR = new FileReader("libraryAdvancedList.csv")) {
            // try-with-resources, inițializat și
            // deschide un flux FileReader cu un parametru de destinație a fișierului
            BufferedReader buffR = new BufferedReader(fileR);
            // inițializați un obiect din clasa BufferedReader din fluxul FileReader
            // pentru citirea optimă din fișier
            String line = null; // inițializarea liniei de citire
            while ((line = buffR.readLine()) != null) {
                // buclă while atâta timp cât există linia citită din fișier
                AdvancedLibrary cl = ToCsv.toClientAdvLib(line);
                // creăm un nou obiect din clasa bibliotecii augmentate cu parametri,
                // returnat de metodele apelate
                list.add(cl); // adaugă un obiect de clasă de carte la listă
            } // bucla este închisă
        } catch (IOException ex) {
            // captează excepțiile care pot apărea în timpul execuției codului în încercare,
            // aștept erori I/O și fișierul nu a fost găsit
            LOG.log(Level.SEVERE, null, ex);// ieșire de eroare către consolă prin intermediul loggerului
        }// legătura try-catch este închisă, FileReader este închis automat
        advList = (ArrayList<AdvancedLibrary>) list;
        // atribuie o nouă valoare listei de biblioteci augmentate
        for (AdvancedLibrary al : advList) {
            // s-a îmbunătățit pentru bucla pe lista bibliotecilor adăugate
            System.out.println(al.toString());
            // afișează informații pe ecran folosind metoda toString ().
        } // bucla este închisă
    } // metoda este închisă


    private static void menu() {
        // Metoda meniului principal pentru utilizator în consolă
        int ch = -1; // Inițializarea variabilei responsabile de selecția utilizatorilor

        do {// metoda do-while
            System.out.println("\tMENIU"); // indiciu pentru utilizator
            System.out.println("VĂ RUGĂM ALEGEȚI UNUL DIN URMĂTOARELE OPȚIUNI"); // indiciu pentru utilizator
            System.out.println("1. Inserați informațiile (va fi exportată automat)"); // indiciu pentru utilizator
            System.out.println("2. Importați informații (va fi afișat automat)"); // indiciu pentru utilizator
            System.out.println("3. Vizualizați informațiile"); // indiciu pentru utilizator
            System.out.println("4. Efectuați sarcinile"); // indiciu pentru utilizator
            System.out.println("0. Ieșire"); // indiciu pentru utilizator
            System.out.print("Alegerea dvs. -> "); // indiciu pentru utilizator
            ch = sc.nextInt(); // citește valoarea variabilei din consolă
            choise(ch); // apelează metoda de gestionare a selecției utilizatorilor
        } while (ch != 0); // bucla este închisă dacă utilizatorul selectează „0”
    } // metoda este închisă

    private static void choise(int ch) {
        // metodă pentru gestionarea selecției utilizatorului cu un parametru întreg
        switch (ch) {// comutator pentru procesarea diferitelor opțiuni pentru selectarea utilizatorului în funcție de parametru
            case 1 -> {// dacă unitatea este selectată, va fi afișat meniul de selectare a introducerii informațiilor
                int c = -1; // inițializați variabila de selecție

                do {// metoda do-while
                    System.out.println("\nINSERT INFORMATION"); // indiciu pentru utilizator
                    System.out.println("VĂ RUGĂM ALEGEȚI UNUL DIN URMĂTOARELE OPȚIUNI"); // indiciu pentru utilizator
                    System.out.println("1. Cărți"); // indiciu pentru utilizator
                    System.out.println("2. Biblioteci"); // indiciu pentru utilizator
                    System.out.println("0. Ieșire"); // indiciu pentru utilizator
                    System.out.print("Alegerea dvs. -> "); // indiciu pentru utilizator
                    c = sc.nextInt(); // citește valoarea variabilei din consolă
                    insert(c); // apelează metoda de gestionare a alegerii utilizatorului de introducere a informațiilor
                } while (c != 0); // bucla este închisă dacă utilizatorul selectează „0”
            } // cazul este închis
            case 2 -> {// în cazul în care se selectează două, va fi afișat meniul de selecție a importului de informații
                int c = -1; // inițializați variabila de selecție
                do {// metoda do-while
                    System.out.println("\nIMPORTĂ & AFIȘĂ INFORMAȚII"); // indiciu pentru utilizator
                    System.out.println("VĂ RUGĂM ALEGEȚI UNUL DIN URMĂTOARELE OPȚIUNI"); // indiciu pentru utilizator
                    System.out.println("1. Cărți"); // indiciu pentru utilizator
                    System.out.println("2. Biblioteci"); // indiciu pentru utilizator
                    System.out.println("0. Ieșire"); // indiciu pentru utilizator
                    System.out.print("Alegerea dvs. -> "); // indiciu pentru utilizator
                    c = sc.nextInt(); // citește valoarea variabilei din consolă
                    importShow(c);
                    // apelează metoda de gestionare la alegerea utilizatorului de a importa informații
                } while (c != 0); // bucla este închisă dacă utilizatorul selectează „0”
            } // cazul este închis
            case 3 -> {// dacă este selectat un triplet, va fi afișat un meniu pentru selectarea informațiilor
                int c = -1; // inițializați variabila de selecție
                do {// metoda do-while
                    System.out.println("\nAfișați informații"); // indiciu pentru utilizator
                    System.out.println("VĂ RUGĂM ALEGEȚI UNUL DIN URMĂTOARELE OPȚIUNI");// indiciu pentru utilizator
                    System.out.println("1. Cărți"); // indiciu pentru utilizator
                    System.out.println("2. Biblioteci"); // indiciu pentru utilizator
                    System.out.println("0. Ieșire"); // indiciu pentru utilizator
                    System.out.print("Alegerea dvs. -> "); // indiciu pentru utilizator
                    c = sc.nextInt(); // citește valoarea variabilei din consolă
                    show(c); // apelează metoda de gestionare a selectării de către utilizator a afișajului de informații
                } while (c != 0); // bucla este închisă dacă utilizatorul selectează „0”
            } // cazul este închis
            case 4 -> {// dacă se selectează patru, sarcinile descrise în sarcină vor fi efectuate
                numberOfLibsThatStartWith45();
                // apelează metoda de numărare a bibliotecilor al căror număr de telefon începe cu 45
                booksWithMaxPages(); // apelează metoda de numărare a cărților cu numărul maxim de pagini
                libsWithFloors();
                // apelează metoda de numărare a bibliotecilor cu numărul de etaje specificat de utilizator
            } // cazul este închis
        } // Comutatorul este închis
    } // metoda este închisă

    private static void insert(int c) {
        // metoda de procesare pentru selectarea de către utilizator a informațiilor introduse
        switch (c) {
            // comutați pentru procesarea diferitelor opțiuni pentru selectarea utilizatorului prin parametrul de intrare a informațiilor
            case 1 -> {// în cazul selecției unității bu
                insertBooks(); // apelează metoda de introducere a listei de cărți dintr-un fișier
                exportBook(); // apelează metoda de export a listei de cărți dintr-un fișier
            } // cazul este închis
            case 2 -> {// în cazul selecției unității
                insertLibraries(); // apelează metoda de introducere a unei liste de biblioteci dintr-un fișier
                exportLib(); // apelează metoda de export a listei de biblioteci dintr-un fișier
            } // cazul este închis
            case 0 -> {// în cazul selecției unității
                menu(); // apelează metoda de afișare a meniului principal
            } // cazul este închis
        } // Comutatorul este închis
    } // metoda este închisă

    private static void importShow(int c) {
        // metoda de gestionare a selectării de către utilizator a importului de informații
        switch (c) {
            // comută pentru a gestiona diferite opțiuni pentru selectarea utilizatorului prin parametrul de import de informații
            case 1 -> {
                // dacă este selectată o unitate, se va executa metoda de procesare a selecției de import de informații
                importBook(); // apelează metoda de importare a unei liste de cărți dintr-un fișier
            } // cazul este închis
            case 2 -> {
                // în cazul alegerii a două, se va executa metoda de prelucrare a alegerii exportului de informații
                importLib(); // apelează metoda de importare a unei liste de biblioteci dintr-un fișier
                importAdvLib();
                // apelează metoda de import pentru lista de biblioteci cu suplimentare. parametrii din fișier
            } // cazul este închis
            case 0 -> {// dacă este selectat zero, utilizatorul va reveni la meniul principal
                menu(); // apelează metoda de afișare a meniului principal
            } // cazul este închis
        } // Comutatorul este închis
    } // metoda este închisă

    private static void show(int c) {
        // metoda de gestionare a alegerii utilizatorului de afisare a informatiilor pe spatiu
        switch (c) {// comutator pentru gestionarea diferitelor opțiuni ale utilizatorului
            // prin parametrul de ieșire a informațiilor către consolă
            case 1 -> {// dacă este selectată unitatea, informațiile despre cărți vor fi afișate pe consolă
                for (Book b : bookList) {// bucla for îmbunătățită pentru lista de cărți
                    System.out.println("Numărul cărții"); // scoate informații în consolă
                    System.out.println("Isbn:" + b.getIsbn());
                    // ieșirea isbn a cărții
                    System.out.println("Titlu:" + b.getTitle());
                    // afișează titlul cărții
                    System.out.println("Autor:" + b.getAuthor());
                    // ieșirea autorului cărții
                    System.out.println("Gen:" + b.getGenre());
                    // afișează genul cărții
                    System.out.println("Data lansării:" + b.getDateOfRelease());
                    // afișează data lansării cărții
                    System.out.println("Limba:" + b.getLang());
                    // afișează limba cărții
                    System.out.println("Pagini:" + b.getNumberOfPages());
                    // afișează numărul de pagini de carte
                    System.out.println("Preț:" + b.getPrice());
                    // afișează prețul cărții
                    System.out.println("Disponibilitate:" + b.getAvalabil());
                    // afișează disponibilitatea negru
                } // bucla este închisă
            } // cazul este închis
            case 2 -> {
                // în cazul unei alegeri a două, se va efectua ieșirea către consola a informațiilor despre biblioteci
                for (int i = 0; i < libList.size(); i++) {// for parcurge lista de biblioteci
                    Library l = libList.get(i);
                    // inițializarea obiectului bibliotecă a poziției curente în listă
                    System.out.println("Bibliotecă"); // trimite informații către consolă
                    System.out.println("ID:" + l.getIdLibrary()); // afișează id-ul bibliotecii
                    System.out.println("Adresa:" + l.getAdres()); // afișează adresa bibliotecii
                    System.out.println("Număr de telefon:" + l.getTelephone());
                    // afișează numărul de telefon de contact al bibliotecii
                    System.out.println("ID-urile cărților:" + l.getBooks());
                    // afișează lista isbn a cărților din bibliotecă
                    System.out.println("District:" + l.getDistrict());
                    // ieșire din Zona Bibliotecii
                    System.out.println("Avansat"); // trimite informații către consolă
                    for (int j = 0; j < libList.size(); j++) {
                        // pentru a trece prin lista de biblioteci cu add. parametrii
                        AdvancedLibrary al = advList.get(j);
                        // inițializarea unui obiect din clasa AdvancedLibrary a poziției curente din listă
                        if (al.getId() == l.getIdLibrary()) {
                            // verifică dacă informații suplimentare sunt relevante pentru biblioteca curentă
                            System.out.println("Număr de etaje:" + al.getNumberOfFloors());
                            // afișează numărul de etaje din bibliotecă
                            System.out.println("Numele bibliotecii:" + al.getLibraryName());
                            // afișează numele bibliotecii
                        } // dacă este închis
                    } // bucla este închisă
                } // bucla este închisă
            } // cazul este închis
            case 0 -> {// în cazul selecției unității
                menu(); // apelează metoda de afișare a meniului principal
            } // cazul este închis
        } // Comutatorul este închis
    } // metoda este închisă
} // clasa este închisă

