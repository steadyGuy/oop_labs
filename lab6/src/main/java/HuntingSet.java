import java.util.Objects;

/**
 * Класс специализированного туристического набора (набор для охоты)
 * Класс минимализированный.
 * @author Сопронюк Юрій
 * @version 1.0
 */
public class HuntingSet extends TouristSet {

    private int knives;
    private boolean isFreeze;
    private int axes;

    public HuntingSet(int knives, boolean isFreeze, int axes) {
        super();
        this.knives = knives;
        this.isFreeze = isFreeze;
        this.axes = axes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HuntingSet that = (HuntingSet) o;
        return knives == that.knives &&
                isFreeze == that.isFreeze &&
                axes == that.axes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), knives, isFreeze, axes);
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
                "Полный размер: " + (getSize() * getWeight()) + " единиц\n" +
                "Цена: " + getPrice() + " грн. \n" + "Стандарт: " + getStandard() + '\n' +
                "Количество ножей: " + this.knives +
                " Мини-холодильник: " + (this.isFreeze ? "есть" : "нету") +
                " Количество топоров: " + this.axes;
    }

    @Override
    public String toString() {
        return "\nHuntingSet{" +
                "knives=" + knives +
                ", isFreeze=" + isFreeze +
                ", axes=" + axes +
                "}";
    }
}
