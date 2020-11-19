/**
 * Абстрактный класс туристического набора, от которого будут наследоваться
 * другие (специализированные) туристические наборы
 * @author Сопронюк Юрій
 * @version 1.0
 */
public abstract class TouristSet implements Standard {

    private int weight;
    private int size;
    private String standard;
    private double price;

    public TouristSet() {
        this.weight = 0;
        this.size = 0;
        this.standard = "AAPP";
        this.price = 0D;
    }

    public TouristSet(int weight, int size, String standard, double price) {
        setWeight(weight);
        setSize(size);
        setStandard(standard);
        setPrice(price);
    }

    @Override
    public String getStandard() {
        return standard;
    }

    @Override
    public void setStandard(String standard) {
        if (standard.length() < 15) {
            this.standard = standard;
        } else {
            this.standard = "no standard";
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 25 && weight > 1) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 10 && size > 1) {
            this.size = size;
        } else {
            this.size = 1;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 10000D && price > 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    //ценность каждого тур-набора (в виде описания)
    /**
     * Абстрактынй метод для получения значения ценности каждого тур-набора
     * (в виде описания). Реализация в классах-наследниках
     * @return возвращает описания набора
     */
    public abstract String getValuabilityOfSet();
}
