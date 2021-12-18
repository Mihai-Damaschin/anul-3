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

    public static void numberOfLibsThatStartWith45 () {
        // Declararea metodei ce determina numarul de biblioteci a caror numarul de telefon incepe cu 45
        int numOfLibs = 0; // inițializarea numărului de biblioteci, acestea sunt încă 0
        for (Library lib1: libList) {// îmbunătățit pentru bucla peste lista de biblioteci
            if (lib1.getTelephone (). startsWith ("45")) {// verificați dacă condiția este îndeplinită
                numOfLibs ++; // dacă condiția este adevărată, numărul de biblioteci crește cu 1
            } // instrucțiunea if este închisă
        } // bucla este închisă
        System.out.println ("Număr de biblioteci al căror număr de telefon începe cu 45 =" + numOfLibs); // scoate rezultatul în consolă
    } // metoda este închisă

    public static void booksWithMaxPages() {
        //Метод для определения кол-ва книг с максимальным количеством страниц
        int maxNumOfPages = 0;
        //инициализация переменой, которая содержит максимальное значение станиц в книге
        int counter = 0; // инициализация счетчика книг
        for (Book book : bookList) { //улучшенный цикл for по списку книг
            if (book.getNumberOfPages() > maxNumOfPages) {
                //если количество страниц книги больше максимального значения
                maxNumOfPages = book.getNumberOfPages();
                // максимальное значение меняется на кол-во страниц текущей книги
            }//оператор if закрывается
        }// цикл закрывается
        System.out.println("The books with maximum number of pages:"); //вывод информации на консоль
        for (Book book : bookList) {//улучшенный цикл for по списку книг
            if (book.getNumberOfPages() == maxNumOfPages) {
                //если количество страниц текущей книги совпадает с максимальным количеством
                System.out.println(book.toString()); //информация о данной книге выводится в консоль
                counter++; //счетчик увеличивается на 1
            }//оператор if закрывается
        }// цикл закрывается
        System.out.println("Number of books with maximum number of pages = " + counter);
        //вывод информации о кол-ве книг с максимальным кол-вом страниц на консоль
    }//метод закрывается

    public static void libsWithFloors() {
        //Метод подсчета кол-ва библиотек с кол-вом этажей, введеных с клавиатуры из определенного интервала
        int counter = 0; //инизицализация счетчика кол-ва библиотек
        System.out.println("Please enter number of floors (1 to 7) in the library :");
        //вывод информации на консоль и просьба ввести определенное значение
        int floors = sc.nextInt(); //инициализация переменной необходимого числа этажей и ее
        //определение  ее значения с помощью Scanner из консоли
        for (AdvancedLibrary lib : advList) {
            //улучшенный цикл for по списку, основанном на классе Advanced Library
            if (lib.getNumberOfFloors() == floors) {
                // если кол-во этажей определенной библиотеки соответствует заданному
                counter++; // счетчик увеличивается на единицу
            }//оператор if закрывается
        }// цикл закрывается
        System.out.println("Number of libraries with " + floors + " floors = " + counter);
        //вывод информации и результата на консоль
    }//метод закрывается

    public static void insertBooks() { //Метод ввода информации о книгах в список
        System.out.println("Please enter number of books:"); //подсказка для пользователя
        int n = sc.nextInt(); //инициализация кол-ва вводимых книг из консоли
        System.out.println("Please enter the information about " + n + " books");
        //подсказка для пользователя
        for (int i = 0; i < n; i++) { //цикл for
            Book b = new Book();//инициализация нового обьекта класса книг
            System.out.println("Book #" + i + 1);//подсказка для пользователя
            System.out.println("ISBN:");//подсказка для пользователя
            b.setIsbn(sc.nextInt());//присваивание значения isbn через консоль
            System.out.println("Title:");//подсказка для пользователя
            b.setTitle(sc.next());//присваивание значения названия книги через консоль
            System.out.println("Author:");//подсказка для пользователя
            b.setAuthor(sc.next());//присваивание значения автора через консоль
            System.out.println("Genre:");//подсказка для пользователя
            b.setGenre(sc.next());//присваивание значения жанра через консоль
            System.out.println("Date of Release yyyy-mm-dd:");//подсказка для пользователя
            b.setDateOfRelease(LocalDate.parse(sc.next()));
            //присваивание значения даты выпуска через консоль
            System.out.println("Language:");//подсказка для пользователя
            b.setLang(sc.next());//присваивание значения языка через консоль
            System.out.println("Number of Pages:");//подсказка для пользователя
            b.setNumberOfPages(sc.nextInt());//присваивание значения страниц через консоль
            System.out.println("Price:");//подсказка для пользователя
            b.setPrice(sc.nextDouble());//присваивание значения цены через консоль
            System.out.println("Availability:");//подсказка для пользователя
            b.setAvalabil(sc.next());//присваивание значения доступности через консоль
            bookList.add(b);//добавление обьекта в список
        }// цикл закрывается
    }//метод закрывается

    public static void insertLibraries() {//Метод ввода информации о библиотеках в список
        System.out.println("Please enter number of libraries:");//подсказка для пользователя
        int n = sc.nextInt();//инициализация кол-ва вводимых библиотек из консоли
        System.out.println("Please enter the information about " + n + " libraries");//подсказка для пользователя

        for (int i = 0; i < n; i++) {//цикл for
            Library l = new Library();//инициализация нового обьекта класса библиотек
            System.out.println("Library #" + (i + 1));//подсказка для пользователя
            System.out.println("ID:");//подсказка для пользователя
            l.setIdLibrary(sc.nextInt());//присваивание значения id библиотеки через консоль
            System.out.println("Address: ");//подсказка для пользователя
            l.setAdres(sc.next());//присваивание значения адресса через консоль
            System.out.println("Telephone number: ");//подсказка для пользователя
            l.setTelephone(sc.next());//присваивание значения номера телефона через консоль
            System.out.println("Number of books: ");//подсказка для пользователя
            l.setNumberOfBooks(sc.nextInt());//присваивание значения кол-ва книг через консоль
            ArrayList<Integer> lb = new ArrayList<>();
            //инизицализация списка класса ArrayList целочисленного типа
            for (int j = 0; j < l.getNumberOfBooks(); j++) {//цикл for
                System.out.println("ISBN of book #" + (j + 1) + ": ");
                //подсказка для пользователя
                lb.add(sc.nextInt());//присваивание значения isbn  книг через консоль
                l.setBooks(lb);//добавление  isbn книг в список
            }// цикл закрывается
            System.out.println("District:");//подсказка для пользователя
            l.setDistrict(sc.next());//присваивание значения района через консоль
            libList.add(l);//добавление обьекта в список
            System.out.println("Do you want to enter and advanced information about this library ? ");//подсказка для пользователя
            System.out.println("'y' - yes");//подсказка для пользователя
            System.out.println("'n' - no");//подсказка для пользователя
            System.out.println("Your choice -> ");//подсказка для пользователя
            String ch = sc.next();//считывание выбора с консоли
            if ("y".equals(ch)) {//если пользователь выбрал добавить информацию
                insertAdvancedLib(l.getIdLibrary());
                //вызов метода заполнения информации к классу AdvancedLibrary
                exportAdLib(); //вызов метода экспорта данных списка типа AdvancedLibrary
            }//оператор if закрывается
        }// цикл закрывается
    }//метод закрывается

    private static void insertAdvancedLib(int id) {
        //Метод ввода информации о библиотеках с расширенными параметрами в список
        AdvancedLibrary al = new AdvancedLibrary();
        //инициализация нового обьекта класса библиотек с доп. параметрами
        al.setId(id);//присваивание значения id из класса Library
        System.out.println("Number of Floors: ");//подсказка для пользователя
        al.setNumberOfFloors(sc.nextInt());//присваивание значения этажей через консоль
        System.out.println("Name of Library: ");//подсказка для пользователя
        al.setLibraryName(sc.next());//присваивание значения названия через консоль
        advList.add(al);//добавление обьекта в список
    }//метод закрывается

    private static void exportBook() {
        //Метод экспорта информации о книгах в текстовый файл
        try (FileWriter fileW = new FileWriter("bookList.csv")) {
            // try-with-resources, инициализируется и открывается поток FileWriter с с
            //параметром точки назначения файла
            for (Book user : bookList) {//улучшенный цикл for по списку книг
                String line = ToCsv.toLineBook(user);
                //инициализация вводимой в файл строки возвращаемой строкой вызываемого метода
                fileW.write(line); //запись строки в файл
            }// цикл закрывается
        } catch (IOException ex) {
            //catch для исключений, которые могут появиться в ходе выполнения кода в try,
            //ожидается ошибка ввода-вывода
            LOG.log(Level.SEVERE, null, ex); //вывод ошибки на консоль через логгер
        }//закрывается связка try-catch, FileWriter автоматически закрывается
    }//метод закрывается

    private static void exportLib() {
        //Метод экспорта информации о библиотеках в текстовый файл
        try (FileWriter fileW = new FileWriter("libraryList.csv")) {
            // try-with-resources, инициализируется и
            //открывается поток FileWriter с с параметром точки назначения файла
            for (Library user : libList) {//улучшенный цикл for по списку библиотек
                String line = ToCsv.toLineLib(user);
                //инициализация вводимой в файл строки возвращаемой строкой вызываемого метода
                fileW.write(line);//запись строки в файл
            }// цикл закрывается
        } catch (IOException ex) {
            //catch для исключений, которые могут появиться в ходе выполнения кода в try,
            // ожидается ошибка ввода-вывода
            LOG.log(Level.SEVERE, null, ex);//вывод ошибки на консоль через логгер
        }//закрывается связка try-catch, FileWriter автоматически закрывается
    }//метод закрывается

    private static void exportAdLib() {
        //Метод экспорта информации о библиотеках с доп. параметрами в текстовый файл
        try (FileWriter fileW = new FileWriter("libraryAdvancedList.csv")) {
            // try-with-resources, инициализируется и
            //открывается поток FileWriter с с параметром точки назначения файла
            for (AdvancedLibrary user : advList) {//улучшенный цикл for по списку библиотек
                String line = ToCsv.toLineAdLib(user);
                //инициализация вводимой в файл строки возвращаемой строкой вызываемого метода
                fileW.write(line);//запись строки в файл
            }// цикл закрывается
        } catch (IOException ex) {
            //catch для исключений, которые могут появиться в ходе выполнения кода в try,
            //ожидается ошибка ввода-вывода
            LOG.log(Level.SEVERE, null, ex); //вывод ошибки на консоль через логгер
        }//закрывается связка try-catch, FileWriter автоматически закрывается
    }//метод закрывается

    private static void importBook() {
        //Метод импорта информации о книгах в текстовый файл
        List<Book> list = new ArrayList();
        try (FileReader fileR = new FileReader("bookList.csv")) {
            // try-with-resources, инициализируется и
            //открывается поток FileReader с с параметром точки назначения файла
            BufferedReader buffR = new BufferedReader(fileR);
            //инициализация обьекта класса BufferedReader из потока FileReader
            //для оптимального чтения из файла
            String line = null; //инициализация считываемой строки
            while ((line = buffR.readLine()) != null) {
                //цикл while, пока строка, считываемая из файла  существует
                Book cl = ToCsv.toClientBook(line);
                //создание нового обьекта класса книг с параметрами, возвращаемые вызываемым методов
                list.add(cl); //добавление обьекта класса книг в список
            }// цикл закрывается
        } catch (IOException ex) {
            //catch для исключений, которые могут появиться в ходе выполнения кода в try,
            //ожидаются ошибки ввода-вывода и ненахождения файла
            LOG.log(Level.SEVERE, null, ex);//вывод ошибки на консоль через логгер
        }//закрывается связка try-catch, FileReader автоматически закрывается
        bookList = (ArrayList<Book>) list; //присваивание нового значения списку книг
        for (Book b : bookList) { //улучшенный цикл for по списку книг
            System.out.println(b.toString());
            //вывод информации на экран с помощью метода toString()
        }// цикл закрывается
    }//метод закрывается

    private static void importLib() {
        //Метод импорта информации о библиотеках в текстовый файл
        List<Library> list = new ArrayList();
        try (FileReader fileR = new FileReader("libraryList.csv")) {
            // try-with-resources, инициализируется и
            //открывается поток FileReader с с параметром точки назначения файла
            BufferedReader buffR = new BufferedReader(fileR);
            //инициализация обьекта класса BufferedReader из потока FileReader
            //для оптимального чтения из файла
            String line = null;//инициализация считываемой строки
            while ((line = buffR.readLine()) != null) {
                //цикл while, пока строка, считываемая из файла  существует
                Library cl = ToCsv.toClientLib(line);
                //создание нового обьекта класса библиотеки с параметрами, возвращаемые вызываемым методов
                list.add(cl);//добавление обьекта класса книг в список
            }// цикл закрывается
        } catch (IOException ex) {
            //catch для исключений, которые могут появиться в ходе выполнения кода в try,
            //ожидаются ошибки ввода-вывода и ненахождения файла
            LOG.log(Level.SEVERE, null, ex);//вывод ошибки на консоль через логгер
        }//закрывается связка try-catch, FileReader автоматически закрывается
        libList = (ArrayList<Library>) list;//присваивание нового значения списку библиотек
        for (Library l : libList) {//улучшенный цикл for по списку библиотек
            System.out.println(l.toString());
            //вывод информации на экран с помощью метода toString()
        }// цикл закрывается
    }//метод закрывается

    private static void importAdvLib() {
        //Метод импорта информации о библиотеках с доп. параметрами в текстовый файл
        List<AdvancedLibrary> list = new ArrayList();
        try (FileReader fileR = new FileReader("libraryAdvancedList.csv")) {
            // try-with-resources, инициализируется и
            //открывается поток FileReader с с параметром точки назначения файла
            BufferedReader buffR = new BufferedReader(fileR);
            //инициализация обьекта класса BufferedReader из потока FileReader
            //для оптимального чтения из файла
            String line = null;//инициализация считываемой строки
            while ((line = buffR.readLine()) != null) {
                //цикл while, пока строка, считываемая из файла  существует
                AdvancedLibrary cl = ToCsv.toClientAdvLib(line);
                //создание нового обьекта класса дополненной библиотеки с параметрами,
                //возвращаемые вызываемым методов
                list.add(cl);//добавление обьекта класса книг в список
            }// цикл закрывается
        } catch (IOException ex) {
            //catch для исключений, которые могут появиться в ходе выполнения кода в try,
            //ожидаются ошибки ввода-вывода и ненахождения файла
            LOG.log(Level.SEVERE, null, ex);//вывод ошибки на консоль через логгер
        }//закрывается связка try-catch, FileReader автоматически закрывается
        advList = (ArrayList<AdvancedLibrary>) list;
        //присваивание нового значения списку дополненных библиотек
        for (AdvancedLibrary al : advList) {
            //улучшенный цикл for по списку дополненных библиотек
            System.out.println(al.toString());
            //вывод информации на экран с помощью метода toString()
        }// цикл закрывается
    }//метод закрывается


    private static void menu() {
        //Метод главного меню для пользователя в консоли
        int ch = -1; // Инициализация переменной, отвечаюшей за выбор пользователя

        System.out.println(ch + "ch");

        do { //метод do-while
            System.out.println("\tTHE MENU");//подсказка для пользователя
            System.out.println("PLEASE CHOOSE ONE OF THE FOLLOWING");//подсказка для пользователя
            System.out.println("1. Insert the information (it will be ехported automatically)");//подсказка для пользователя
            System.out.println("2. Import information      (it will be shown automatically)");//подсказка для пользователя
            System.out.println("3. View the information");//подсказка для пользователя
            System.out.println("4. Do the tasks");//подсказка для пользователя
            System.out.println("0. Exit");//подсказка для пользователя
            System.out.print("Your choice -> ");//подсказка для пользователя
            ch = sc.nextInt(); // считываение значение переменной из консоли
            choise(ch); //вызов метода обработки выбора пользователя
        } while (ch > 1);// цикл закрывается, если пользователь выберет "0"
    }//метод закрывается

    private static void choise(int ch) {
        //метод обработки выбора пользователя с целочисленным параметром
        switch (ch) { //switch для обработки разных вариантов выбора пользователя по параметру
            case 1 -> { //в случае, выбора единицы выведется меню выбора ввода информации
                int c = -1; //инициализация переменной выбора

                do {//метод do-while
                    System.out.println("\nINSERT INFORMATION");//подсказка для пользователя
                    System.out.println("PLEASE CHOOSE ONE OF THE FOLLOWING");
                    //подсказка для пользователя
                    System.out.println("1. Books");//подсказка для пользователя
                    System.out.println("2. Libraries");//подсказка для пользователя
                    System.out.println("0. Exit");//подсказка для пользователя
                    System.out.print("Your choice -> ");//подсказка для пользователя
                    c = sc.nextInt();// считываение значение переменной из консоли
                    insert(c); //вызов метода обработки выбора пользователя ввода информации
                } while (c > 1);// цикл закрывается, если пользователь выберет "0"
            }//case закрывается
            case 2 -> {//в случае, выбора двойки выведется меню выбора импорта информации
                int c = -1;//инициализация переменной выбора
                do {//метод do-while
                    System.out.println("\nIMPORT & SHOW INFORMATION");
                    //подсказка для пользователя
                    System.out.println("PLEASE CHOOSE ONE OF THE FOLLOWING");
                    //подсказка для пользователя
                    System.out.println("1. Books");//подсказка для пользователя
                    System.out.println("2. Libraries");//подсказка для пользователя
                    System.out.println("0. Exit");//подсказка для пользователя
                    System.out.print("Your choice -> ");//подсказка для пользователя
                    c = sc.nextInt();// считываение значение переменной из консоли
                    importShow(c);
                    //вызов метода обработки выбора пользователя импорта информации
                } while (c > 1);// цикл закрывается, если пользователь выберет "0"
            }//case закрывается
            case 3 -> {//в случае, выбора тройки выведется меню выбора вывода информации
                int c = -1;//инициализация переменной выбора
                do {//метод do-while
                    System.out.println("\nSHOW INFORMATION");//подсказка для пользователя
                    System.out.println("PLEASE CHOOSE ONE OF THE FOLLOWING");
                    //подсказка для пользователя
                    System.out.println("1. Books");//подсказка для пользователя
                    System.out.println("2. Libraries");//подсказка для пользователя
                    System.out.println("0. Exit");//подсказка для пользователя
                    System.out.print("Your choice -> ");//подсказка для пользователя
                    c = sc.nextInt();// считываение значение переменной из консоли
                    show(c);//вызов метода обработки выбора пользователя вывода информации
                } while (c > 1);// цикл закрывается, если пользователь выберет "0"
            }//case закрывается
            case 4 -> {//в случае, выбора четверки выполнятся задачи, описанные в задаче
                numberOfLibsThatStartWith45();
                //вызов метода подсчета библиотек номер телефона которых начинается с 45
                booksWithMaxPages();//вызов метода подсчета книг с максимальным кол-вом страниц
                libsWithFloors();
                //вызов метода подсчета библиотек с кол-вом этажей, указанных пользователем
            }//case закрывается
        }//switch закрывается
    }//метод закрывается

    private static void insert(int c) {
        //метод обработки выбора пользователя ввода информации
        switch (c) {
            //switch для обработки разных вариантов выбора пользователя по параметру ввода информации
            case 1 -> {//в случае, выбора единицы бу
                insertBooks();// вызов метода ввода списка книг из файла
                exportBook();// вызов метода экспорта списка книг из файла
            }//case закрывается
            case 2 -> {//в случае, выбора единицы
                insertLibraries();// вызов метода ввода списка библиотек из файла
                exportLib();// вызов метода экспорта списка библиотек из файла
            }//case закрывается
            case 0 -> {//в случае, выбора единицы
                menu();//вызов метода вывода главного меню
            }//case закрывается
        }//switch закрывается
    }//метод закрывается

    private static void importShow(int c) {
        //метод обработки выбора пользователя импорта информации
        switch (c) {
            //switch для обработки разных вариантов выбора пользователя по параметру импорта информации
            case 1 -> {
                //в случае, выбора единицы выполнится метод обработки выбора импорта информации
                importBook();// вызов метода импорта списка книг из файла
            }//case закрывается
            case 2 -> {
                //в случае, выбора двойки выполнится метод обработки выбора экспорта информации
                importLib(); // вызов метода импорта списка библиотек из файла
                importAdvLib();
                // вызов метода импорта списка библиотек с доп. параметрами из файла
            }//case закрывается
            case 0 -> {//в случае, выбора нуля пользователь вернется в главное меню
                menu();//вызов метода вывода главного меню
            }//case закрывается
        }//switch закрывается
    }//метод закрывается

    private static void show(int c) {
        //метод обработки выбора пользователя вывода на косноль информации
        switch (c) {//switch для обработки разных вариантов выбора пользователя
            //по параметру вывода на консоль информации
            case 1 -> {//в случае, выбора единицы выполнится вывод на консоль информации о книгах
                for (Book b : bookList) {//улучшенный цикл for по спику книг
                    System.out.println("Book #"); //вывод информации на консоль
                    System.out.println("Isbn: " + b.getIsbn());
                    //вывод isbn книги
                    System.out.println("Title: " + b.getTitle());
                    //вывод названия книги
                    System.out.println("Author: " + b.getAuthor());
                    //вывод автора книги
                    System.out.println("Genre: " + b.getGenre());
                    //вывод жанра книги
                    System.out.println("Release Date: " + b.getDateOfRelease());
                    //вывод даты выпуска книги
                    System.out.println("Language: " + b.getLang());
                    //вывод языка книги
                    System.out.println("Pages: " + b.getNumberOfPages());
                    //вывод кол-ва страниц книги
                    System.out.println("Price: " + b.getPrice());
                    //вывод цены книги
                    System.out.println("Availabilty: " + b.getAvalabil());
                    //вывод доступности ниги
                }// цикл закрывается
            }//case закрывается
            case 2 -> {
                //в случае, выбора двойки выполнится вывод на консоль информации о библиотеках
                for (int i = 0; i < libList.size(); i++) {//цикл for по списку библиотек
                    Library l = libList.get(i);
                    //инициализация обьекта класса library текущей позиции в списке
                    System.out.println("Library");//вывод информации на консоль
                    System.out.println("ID: " + l.getIdLibrary());//вывод id библиотеки
                    System.out.println("Address: " + l.getAdres());//вывод адреса библиотеки
                    System.out.println("Telephone number: " + l.getTelephone());
                    //вывод контактного номера телефона библиотеки
                    System.out.println("Books' IDs: " + l.getBooks());
                    //вывод списка isbn книг библиотеки
                    System.out.println("District: " + l.getDistrict());
                    //вывод Района библиотеки
                    System.out.println("Advanced");//вывод информации на консоль
                    for (int j = 0; j < libList.size(); j++) {
                        //цикл for  по списку библиотек с доп. параметрами
                        AdvancedLibrary al = advList.get(j);
                        //инициализация обьекта класса AdvancedLibrary текущей позиции в списке
                        if (al.getId() == l.getIdLibrary()) {
                            //проверяется, является дополнительная информация актуальной для текущей библиотеки
                            System.out.println("Number of Floors: " + al.getNumberOfFloors());
                            //вывод кол-ва этажей библиотеки
                            System.out.println("Name of Library: " + al.getLibraryName());
                            //вывод названия библиотеки
                        }//if закрывается
                    }// цикл закрывается
                }// цикл закрывается

            }//case закрывается
            case 0 -> {//в случае, выбора единицы
                menu();//вызов метода вывода главного меню
            }//case закрывается
        }//switch закрывается
    }//метод закрывается
}//класс закрывается

