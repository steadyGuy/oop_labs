public class PicnicSet extends TouristSet {
    private int napkins;
    private int glasses;
    private int spoons;

    public PicnicSet(int napkins, int glasses, int spoons) {
        this.napkins = napkins;
        this.glasses = glasses;
        this.spoons = spoons;
    }

    public PicnicSet(int weight, int size, String standard, double price, int napkins, int glasses, int spoons) {
        super(weight, size, standard, price);
        this.napkins = napkins;
        this.glasses = glasses;
        this.spoons = spoons;
    }

    @Override
    public String getValuabilityOfSet() {
        return "Набор для пикника. \n" +
                "Полный размер:" + (getSize() * getWeight()) + " единиц\n" +
                "Цена: " + getPrice() + " грн. \n" + "Стандарт: " + getStandard() + '\n' +
                "Количество серветок: " + this.napkins +
                " Количество стаканов: " + this.glasses +
                " Количество ложок: " + this.spoons;
    }
}
