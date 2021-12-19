import java.util.ArrayList;

public class Library {
    private int idLibrary; //обьявление переменной Id библиотеки
    private String adres; //обьявление переменной адресса библиотеки
    private String telephone; //обьявление переменной номера телефона библиотеки
    private int numberOfBooks; //обьявление переменной кол-ва книг библиотеки
    private ArrayList<Integer> books; //обьявление переменной книг библиотеки
    private String district; //обьявление переменной района библиотеки

    public Library() {//пустой конструктор класса
    }

    //конструктор класса с параметрами
    public Library(int idLibrary, String adres, String telephone, int numberOfBooks, ArrayList<Integer> books, String district) {
        this.idLibrary = idLibrary; //обращение к переменной класса Id библиотеки через this
        this.adres = adres; //обращение к переменной класса адресса библиотеки через this
        this.telephone = telephone;//обращение к переменной номера телефона библиотеки через this
        this.numberOfBooks = numberOfBooks;//обращение к переменной кол-ва книг библиотеки через this
        this.books = books; //обращение к переменной класса книг библиотеки через this
        this.district = district; //обращение к переменной класса района библиотеки через this
    }

    //геттер для переменной  района библиотеки
    public String getDistrict() {
        return district; //возвращение значения переменной  района библиотеки
    }

    //сеттер для переменной района библиотеки
    public void setDistrict(String district) {
        this.district = district; //присваивание значения переменной  района библиотеки
    }

    //геттер для переменной  кода библиотеки
    public int getIdLibrary() {
        return idLibrary;//возвращение значения переменной  кода библиотеки
    }

    //сеттер для переменной  кода библиотеки
    public void setIdLibrary(int idLibrary) {
        this.idLibrary = idLibrary;//присваивание значения переменной  кода библиотеки
    }

    //геттер для переменной  адреса библиотеки
    public String getAdres() {
        return adres;//возвращение значения переменной  адреса библиотеки
    }

    //сеттер для переменной  адреса библиотеки
    public void setAdres(String adres) {
        this.adres = adres;//присваивание значения переменной  адреса библиотеки
    }

    //геттер для переменной  номера телефона библиотеки
    public String getTelephone() {
        return telephone;//возвращение значения переменной  номера телефона библиотеки
    }

    //сеттер для переменной  номера телефона библиотеки
    public void setTelephone(String telephone) {
        this.telephone = telephone;//присваивание значения переменной  номера телефона библиотеки
    }

    //геттер для переменной  кол-ва книг библиотеки
    public int getNumberOfBooks() {
        return numberOfBooks;//возвращение значения переменной  кол-ва книг библиотеки
    }

    //cеттер для переменной  кол-ва книг библиотеки
    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;//присваивание значения переменной  кол-ва книг библиотеки
    }

    //геттер для переменной  списка книг библиотеки
    public ArrayList<Integer> getBooks() {
        return books;//возвращение значения переменной  списка книг библиотеки
    }

    //сеттер для переменной  списка книг библиотеки
    public void setBooks(ArrayList<Integer> books) {
        this.books = books;//присваивание значения переменной  списка книг библиотеки
    }

    //аннотация перегрузки метода
    @Override
    //метод для получения хэш-кода обьекта
    public int hashCode() {
        int hash = 7; //обьявление и инициализация переменной хэшкода
        hash = 79 * hash + this.idLibrary;//алгоритм получения уникального хэш-кода обьекта
        return hash; //возвращение значения хэш-кода
    }

    //аннотация перегрузки метода
    @Override
    //метод для сравнения двух обьектов класса на идентичность
    public boolean equals(Object obj) {
        if (this == obj) {  //проверяется, если обьект является самим собой.
            return true; //возвращается значение True, если утверждение в if - истинно
        }
        if (obj == null) { //проверяется, если обьект имеет значение null
            return false; //возвращается значение False, если утверждение в if - истинно
        }
        if (getClass() != obj.getClass()) { //проверяется, если обьект не является обьектом данного класса
            return false; //возвращается значение False, если утверждение в if - истинно
        }
        final Library other = (Library) obj;
        //присваивания обьекта obj с явной конвертацией в обьект данного класса
        //возвращается значение True, если ни одно из вышеуказанных утвержедний не верно.
        //обьявление и инициализация финального обьекта класса other путем
        return this.idLibrary == other.idLibrary;
    }

    //аннотация перегрузки метода
    @Override
    //Метод для быстрого доступа к значениям обьектов класса;
    //обычно используется в разработке и тестировании путем вывода информации в консоль
    public String toString() {
        return "Library{" + "idLibrary=" + idLibrary + ", adres=" + adres + ", telephone=" +
                telephone + ", numberOfBooks=" + numberOfBooks + ", books=" + books +
                ", district=" + district + '}';
    }
//возвращаются все значения и характеристики обьекта класса с описанием
}//закрывается класс Library

