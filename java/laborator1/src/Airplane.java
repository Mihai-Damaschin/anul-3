public class Airplane {
    private final String category;
    private final String category_name;
    private final String color;
    private final int seats;
    private final int vat;

    {
        category = "C";
        category_name = "airline jet";
        color = "Yellow";
        seats = 400;
        vat = 130;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryName() {
        return category_name;
    }

    public String getColor() {
        return color;
    }

    public int getSeats() {
        return seats;
    }

    public int getVat() {
        return vat;
    }
}
