import java.util.Map;

/**
 * Класс магазина тур-наборов.
 * @author Сопронюк Юрій
 * @version 1.0
 */
public class TravelSetStore implements SellableProducts {
    private Map<TouristSet, Integer> sets; //агрегация
    private String name;
    private boolean saleability;

    public TravelSetStore() {
        this.sets = null;
        this.name = "Travel Set Store";
    }

    public TravelSetStore(Map<TouristSet, Integer> sets, String name) {
        this.sets = sets;
        this.name = name;
    }

    int getSetAmount(TouristSet set) {
        return sets.get(set);
    }

    /**
     * Процедура продажи товара из магазина по заданному набору
     * @param tSet - набор, который нужно продать
     */
    @Override
    public void sellSet(TouristSet tSet) {
        if (!saleability) {
            System.out.println("Магазин не продает товары!");
            return;
        }
        int amount = sets.get(tSet); //получить значения по ключу экземпляра Set-а
        sets.put(tSet, --amount);
    }

    @Override
    public double getSetPrice(TouristSet set) {
        return set.getPrice();
    }

    @Override
    public boolean isSellable() {
        return this.saleability;
    }

    @Override
    public void setSellable(boolean saleability) {
        this.saleability = saleability;
    }

    public String getName() {
        return name;
    }
}
