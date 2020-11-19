public class HuntingSet extends TouristSet {

    private int knives;
    private boolean isFreeze;
    private int axes;

    public HuntingSet(int knives, boolean isFreeze, int axes) {
        this.knives = knives;
        this.isFreeze = isFreeze;
        this.axes = axes;
    }

    public HuntingSet(int weight, int size, String standard, double price, int knives, boolean isFreeze, int axes) {
        super(weight, size, standard, price);
        this.knives = knives;
        this.isFreeze = isFreeze;
        this.axes = axes;
    }

    @Override
    public String getValuabilityOfSet() {
        return "Охотничий набор. \n" +
                "Полный размер:" + (getSize() * getWeight()) + " единиц\n" +
                "Цена: " + getPrice() + " грн. \n" + "Стандарт: " + getStandard() + '\n' +
                "Количество ножей: " + this.knives +
                " Мини-холодильник: " + (this.isFreeze ? "есть" : "нету") +
                " Количество топоров: " + this.axes;
    }
}
