/**
 * Интерфейс, который определяет функционал для работы с продажей товаров
 * Данный интерфейс может быть использован, для любого класса-магазина неких наборов.
 * @author Сопронюк Юрій
 * @version 1.0
 */
public interface SellableProducts {
    boolean isSellable();
    void setSellable(boolean saleability);

    void sellSet(TouristSet set);
    double getSetPrice(TouristSet set);
}