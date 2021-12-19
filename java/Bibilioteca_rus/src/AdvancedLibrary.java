public class AdvancedLibrary extends Library { //расширяет класс Library

    private int id; //обьявление переменной  id библиотеки
    private int numberOfFloors; //обьявление переменной кол-ва этажей библиотеки
    private String libraryName; //обьявление переменной наименования библиотеки

    public AdvancedLibrary() { //пустой конструктор класса
    }

    //конструктор класса с параметрами
    public AdvancedLibrary(int id, int numberOfFloors, String libraryName) {
        this.id = id; //обращение к переменной класса  id библиотеки через this
        this.numberOfFloors = numberOfFloors;  //обращение к переменной количества этажей библиотеки
        this.libraryName = libraryName; //обращение к переменной наименования библиотеки через this
    }

    //геттер для переменной id библиотеки
    public int getId() {
        return id;//возвращение значения переменной  id библиотеки
    }

    //сеттер для переменной id библиотеки
    public void setId(int id) {
        this.id = id;//присваивание значения переменной  id библиотеки
    }

    //геттер для переменной наименования библиотеки
    public String getLibraryName() {
        return libraryName; //возвращение значения переменной  наименования библиотеки
    }

    //сеттер для переменной наименования библиотеки
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;//присваивание значения переменной  наименования библиотеки
    }

    //геттер для переменной кол-ва этажей библиотеки
    public int getNumberOfFloors() {
        return numberOfFloors;//возвращение значения переменной  кол-ва этажей библиотеки
    }

    //сеттер для переменной кол-ва этажей библиотеки
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;//присваивание значения переменной кол-ва этажей библиотеки
    }

    //аннотация перегрузки метода
    @Override
    //метод для для быстрого доступа к значениям обьектов класса;
    public String toString() {
        return "AdvancedLibrary{" + "id=" + id + ", numberOfFloors=" + numberOfFloors +
                ", libraryName=" + libraryName + '}';
        //возвращаются все значения и характеристики обьекта класса с описанием
    }
}//закрывается класс AdvancedLibrary

