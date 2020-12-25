import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * Класс специализированного туристического набора (набор для пикников)
 * Класс минимализированный.
 * @author Сопронюк Юрій
 * @version 1.0
 */
public class PicnicSet extends TouristSet {
    private int napkins;
    private int glasses;
    private int spoons;

    public PicnicSet(int napkins, int glasses, int spoons) {
        super();
        this.napkins = napkins;
        this.glasses = glasses;
        this.spoons = spoons;
    }

//    private void writeObject(ObjectOutputStream os) throws IOException {
//        os.defaultWriteObject();
//        os.writeObject(obj.getStatus());
//    }
//
//    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
//        is.defaultReadObject();
//        int status = (int) is.readObject();
//        obj = new OtherClass(status);
//    }

    public PicnicSet(int weight, int size, String standard, double price, int napkins, int glasses, int spoons) {
        super(weight, size, standard, price);
        this.napkins = napkins;
        this.glasses = glasses;
        this.spoons = spoons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PicnicSet picnicSet = (PicnicSet) o;
        return napkins == picnicSet.napkins &&
                glasses == picnicSet.glasses &&
                spoons == picnicSet.spoons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), napkins, glasses, spoons);
    }

    @Override
    public String getValuabilityOfSet() {
        return "Набор для пикника. \n" +
                "Полный размер: " + (getSize() * getWeight()) + " единиц\n" +
                "Цена: " + getPrice() + " грн. \n" + "Стандарт: " + getStandard() + '\n' +
                "Количество серветок: " + this.napkins +
                " Количество стаканов: " + this.glasses +
                " Количество ложок: " + this.spoons;
    }

    @Override
    public String toString() {
        return "\nPicnicSet{" +
                "napkins=" + napkins +
                ", glasses=" + glasses +
                ", spoons=" + spoons +
                "}";
    }
}
