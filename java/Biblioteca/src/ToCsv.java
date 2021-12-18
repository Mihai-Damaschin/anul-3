import java.time.LocalDate;
import java.util.ArrayList;

public class ToCsv {

    //константы
    private final static String ENTER = " "; //константа для пробела
    private final static String ENDL = "\n"; //константа для перехода на новою строку

    public static String toLineBook(Book book) { //метод перевода информации о книге в строку с параметром типа Book
        StringBuilder strB = new StringBuilder();
        //инициализация обьекта класса StringBuilder для записи всей информации в одну строку
        strB.append(book.getIsbn()); //добавление isbn книги в строку
        strB.append(ENTER); //разделение информации пробелом
        strB.append(book.getTitle());//добавление названия книги в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(book.getAuthor());//добавление автора книги в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(book.getGenre());//добавление жанра книги в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(book.getDateOfRelease());//добавление даты выпуска книги в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(book.getLang());//добавление языка книги в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(book.getNumberOfPages());//добавление кол-ва страниц книги в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(book.getPrice());//добавление цены книги в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(book.getAvalabil());//добавление доступности книги в строку
        strB.append(ENDL); //разделение информации переходом на новою строку.
        //следующая строка, и информация о другой книге будет записывать с новой строки в файле

        return strB.toString();//возвращение результирующей строки
    }//метод закрывается

    static String toLineLib(Library lib) {//метод перевода информации о библиотеке в строку с параметром типа Library
        ArrayList<Integer> l = lib.getBooks(); // запись в массив значения Isbn книг библиотеки
        StringBuilder strB = new StringBuilder();
        //инициализация обьекта класса StringBuilder для записи всей информации в одну строку
        strB.append(lib.getIdLibrary());//добавление id библиотеки в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(lib.getAdres());//добавление адреса библиотеки в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(lib.getTelephone());//добавление номера телефона библиотеки в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(lib.getNumberOfBooks());//добавление кол-ва книг библиотеки в строку
        strB.append(ENTER);//разделение информации пробелом
        for (Integer integer : l) {//цикл for для записи isbn книг библиотеки по их кол-ву
            strB.append(integer);//добавление isbn книг из библиотеки в строку
            strB.append(ENTER);//разделение информации пробелом
        }//цикл закрывается
        strB.append(ENTER);//разделение информации пробелом
        strB.append(lib.getDistrict());//добавление района библиотеки в строку
        strB.append(ENDL);//разделение информации переходом на новою строку.
        //следующая строка, и информация о другой книге будет записывать с новой строки в файле

        return strB.toString();//возвращение результирующей строки
    }//метод закрывается

    static String toLineAdLib(AdvancedLibrary lib) {//метод перевода информации о библиотеке в строку с параметром типа AdvancedLibrary
        StringBuilder strB = new StringBuilder();
        //инициализация обьекта класса StringBuilder для записи всей информации в одну строку
        strB.append(lib.getIdLibrary());//добавление id библиотеки в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(lib.getNumberOfFloors());//добавление кол-ва этажей библиотеки в строку
        strB.append(ENTER);//разделение информации пробелом
        strB.append(lib.getLibraryName());//добавление названия библиотеки в строку
        strB.append(ENDL);//разделение информации переходом на новою строку.
        //следующая строка, и информация о другой книге будет записывать с новой строки в файле

        return strB.toString();//возвращение результирующей строки
    }//метод закрывается

    public static Book toClientBook(String line) {//метод перевода из строки в обьект класса Book
        String data[] = line.split(ENTER);//создание массива строк с помощью раздения по пробелу
        int isbn = Integer.parseInt(data[0]);//создание целочисленного параметра isbn книги
        //с помощью явного преобразования в тип int первого эллемента массива строк
        String title = data[1];//создание параметра названия книги из втрого эллемента массива строк
        String author = data[2];//создание параметра автора книги из третьего эллемента массива строк
        String genre = data[3];//создание параметра жанра книги из четвертого эллемента массива строк
        String dateStr = data[4];//параметр даты выпуска книги из пятого эллемента массива строк
        LocalDate dateOfRelease = LocalDate.parse(dateStr);
        //явное преобразование строки даты выпуска книги в тип данных даты
        String lang = data[5];//создание параметра языка книги из шестого эллемента массива строк
        int numOfPages = Integer.parseInt(data[6]);//целочисленный параметр кол-ва страниц книги
        //с помощью явного преобразования в тип int седьмого эллемента массива строк
        double price = Double.parseDouble(data[7]);//параметр числа с плавающей точки  цены книги
        //с помощью явного преобразования в тип double восьмого эллемента массива строк
        String avail = data[8];//параметр доступности книги из девятого эллемента массива строк

        //создание обьекта класса Book с данными параметрами
        Book client = new Book(isbn, title, author, genre, dateOfRelease, lang, numOfPages, price, avail);
        return client; //возврашение обьекта типа Book
    }//метод закрывается

    static Library toClientLib(String line) {//метод перевода из строки в обьект класса Library
        String data[] = line.split(ENTER);//создание массива строк с помощью раздения по пробелу
        int id = Integer.parseInt(data[0]);//создание целочисленного параметра Id библиотеки
        //с помощью явного преобразования в тип int первого эллемента массива строк
        String adres = data[1];//параметр адреса библиотеки из втрого эллемента массива строк
        String telephone = data[2];//параметр телефона библиотеки из третьего эллемента
        int n = Integer.parseInt(data[3]);//создание целочисленного параметра кол-ва книг
        //с помощью явного преобразования в тип int четвертого эллемента массива строк
        ArrayList<Integer> l = new ArrayList<>();
        //создание списка, предназначенного для хранения isbn книг библиотеки
        int i = 4; //инициализация индекса эллемента массива строк
        for (int j = 0; j < n; i++, j++) {
            //цикл for для записи isbn книг библиотеки в список до кол-ва книг библиотеки
            l.add(Integer.parseInt(data[i]));
            //запись значения из i-нного эллемента массива строк с помощью явного преобразования
        }//цикл закрывается
        String district = data[i + 1];
        //создание параметра района библиотеки из (i+1) - нного эллемента массива строк

        //создание обьекта класса Library с данными параметрами
        Library lib = new Library(id, adres, telephone, n, l, district);
        return lib;//возврашение обьекта типа Library
    }//метод закрывается

    static AdvancedLibrary toClientAdvLib(String line) {
        //метод перевода из строки в обьект класса AdvancedLibrary
        String data[] = line.split(ENTER);//создание массива строк с помощью раздения по пробелу
        int id = Integer.parseInt(data[0]);//создание целочисленного параметра id библиотеки
        //с помощью явного преобразования в тип int первого эллемента массива строк
        int floors = Integer.parseInt(data[1]);//параметр кол-ва этажей библиотеки
        //с помощью явного преобразования в тип int втрого эллемента массива строк
        String name = data[2];//параметр названия библиотеки из третьего эллемента массива строк

        //создание обьекта класса AdvancedLibrary с данными параметрами
        AdvancedLibrary client = new AdvancedLibrary(id, floors, name);
        return client;//возврашение обьекта типа AdvancedLibrary
    }//метод закрывается
}//класс закрывается
