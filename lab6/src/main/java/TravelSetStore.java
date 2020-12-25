import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/**
 * Класс магазина тур-наборов.
 * @author Сопронюк Юрій
 * @version 1.0
 */
public class TravelSetStore implements SellableProducts, Serializable {
    private Map<TouristSet, Integer> sets; //агрегация
    private transient StoreInfo storeAbout; //простая асоциация
    private boolean saleability;

    public TravelSetStore() {
        this.sets = null;
        this.storeAbout = new StoreInfo("No-name", false);
        this.saleability = storeAbout.getSaleAbility();
    }

    public TravelSetStore(Map<TouristSet, Integer> sets, StoreInfo about) {
        this.sets = sets;
        this.storeAbout = about;
        this.saleability = about.getSaleAbility();
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeObject(storeAbout.getShopId());
    }

    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
        is.defaultReadObject();
        int id = (int) is.readObject();
        storeAbout = new StoreInfo(id);
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
        return storeAbout.getSaleAbility();
    }

    @Override
    public void setSellable(boolean saleability) {
        storeAbout.setSaleAbility(saleability);
    }

    public StoreInfo getStoreAbout() {
        return storeAbout;
    }

    public void setStoreAbout(StoreInfo storeAbout) {
        this.storeAbout = storeAbout;
    }

    @Override
    public String toString() {
        return "TravelSetStore{" +
                "sets=" + sets +
                ", \nStoreAbout=" + storeAbout +
                '}';
    }
}
