import java.time.LocalDate;

public class Book {
    private int isbn;                                       //обьявление переменной isbn книги
    private String title;                                  //обьявление переменной названия книги
    private String author;                             //обьявление переменной автора книги
    private String genre;                               //обьявление переменной жанра книги
    private LocalDate dateOfRelease;        //обьявление переменной даты выпуска книги
    private String lang;                                 //обьявление переменной языка книги
    private int numberOfPages;                  //обьявление переменной кол-ва страниц книги
    private double price;                                      //обьявление переменной цены книги
    private String avalabil;                            //обьявление переменной доступности книги

    //пустой конструктор класса
    public Book() {
    }

    //конструктор класса с параметрами
    public Book(int isbn, String title, String author, String genre, LocalDate dateOfRelease, String lang, int numberOfPages, double price, String avalabil) {
        this.isbn = isbn; //обращение к переменной класса isbn книги через this
        this.title = title; //обращение к переменной класса названия книги через this
        this.author = author; //обращение к переменной класса автора книги через this
        this.genre = genre; //обращение к переменной класса жанра книги через this
        this.dateOfRelease = dateOfRelease; //обращение к переменной даты выпуска книги через this
        this.lang = lang; //обращение к переменной класса языка книги через this
        this.numberOfPages = numberOfPages;    //обращение к переменной кол-ва страниц книги через this
        this.price = price; //обращение к переменной класса цены книги через this
        this.avalabil = avalabil; //обращение к переменной класса доступности книги через this
    }

    //геттер для переменной isbn книги
    public int getIsbn() {
        return isbn;//возвращение значения переменной  isbn книги
    }

    //сеттер для переменной isbn книги
    public void setIsbn(int isbn) {
        this.isbn = isbn;//присваивание значения переменной  isbn книги
    }

    //геттер для переменной названия книги
    public String getTitle() {
        return title;//возвращение значения переменной  названия книги
    }

    //сеттер для переменной названия книги
    public void setTitle(String title) {
        this.title = title;//присваивание значения переменной  названия книги
    }

    //геттер для переменной автора книги
    public String getAuthor() {
        return author;//возвращение значения переменной  автора книги
    }

    //сеттер для переменной автора книги
    public void setAuthor(String author) {
        this.author = author;//присваивание значения переменной  автора книги
    }

    //геттер для переменной жанра книги
    public String getGenre() {
        return genre;//возвращение значения переменной  жанра книги
    }

    //сеттер для переменной жанра книги
    public void setGenre(String genre) {
        this.genre = genre;//присваивание значения переменной  жанра книги
    }

    //геттер для переменной даты выпуска книги
    public LocalDate getDateOfRelease() {
        return dateOfRelease;//возвращение значения переменной  даты выпуска книги
    }

    //сеттер для переменной даты выпуска книги
    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;//присваивание значения переменной  даты выпуска книги
    }

    //геттер для переменной языка книги
    public String getLang() {
        return lang;//возвращение значения переменной  языка книги
    }

    //сеттер для переменной языка книги
    public void setLang(String lang) {
        this.lang = lang;//присваивание значения переменной  языка книги
    }

    //геттер для переменной кол-ва страниц книги
    public int getNumberOfPages() {
        return numberOfPages;//возвращение значения переменной  кол-ва страниц книги
    }

    //сеттер для переменной кол-ва страниц книги
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;//присваивание значения кол-ва страниц книги
    }

    //геттер для переменной цены книги
    public double getPrice() {
        return price;//возвращение значения переменной  цены книги
    }

    //сеттер для переменной цены книги
    public void setPrice(double price) {
        this.price = price;//присваивание значения переменной  цены книги
    }

    //геттер для переменной доступности книги
    public String getAvalabil() {
        return avalabil;//возвращение значения переменной  доступности книги
    }

    //сеттер для переменной доступности книги
    public void setAvalabil(String avalabil) {
        this.avalabil = avalabil;//присваивание значения переменной  доступности книги
    }

    //аннотация перегрузки метода
    @Override
    //метод для получения хэш-кода обьекта
    public int hashCode() {
        int hash = 5; //обьявление и инициализация переменной хэшкода
        hash = 79 * hash + this.isbn; //алгоритм получения уникального хэш-кода каждого обьекта
        return hash; //возвращение значения хэш-кода
    }

    //аннотация перегрузки метода
    @Override
    //метод для сравнения двух обьектов класса на идентичность
    public boolean equals(Object obj) {
        if (this == obj) { //проверяется, если обьект является самим собой.
            return true; //возвращается значение True, если утверждение в if - истинно
        }
        if (obj == null) {//проверяется, если обьект имеет значение null
            return false; //возвращается значение False, если утверждение в if - истинно
        }
        if (getClass() != obj.getClass()) {//проверяется, если обьект не является обьектом данного класса
            return false;//возвращается значение False, если утверждение в if - истинно
        }
        final Book other = (Book) obj; //присваивание обьекта obj с явной конвертацией в обьект данного класса
        //возвращается значение True, если ни одно из вышеуказанных утвержедний не верно.
        //обьявление и инициализация финального обьекта класса other путем
        return this.isbn == other.isbn;
    }

    //аннотация перегрузки метода
    @Override
    //Метод для быстрого доступа к значениям обьектов класса;
    //обычно используется в разработке и тестировании путем вывода информации в консоль
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", author=" + author + ", genre=" + genre + ", dateOfRelease=" + dateOfRelease + ", lang=" + lang + ", numberOfPages=" + numberOfPages + ", price=" + price + ", avalabil=" + avalabil + '}';
        //возвращаются все значения и характеристики обьекта класса с описанием
    }
}//закрывается класс Book

