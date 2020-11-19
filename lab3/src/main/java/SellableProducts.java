public interface SellableProducts {
    //интерфейс который указывает продает ли магазин продукту, или нет

    boolean isSellable();
    void setSellable(boolean saleability);
    void sellSet(TouristSet set);
    double getSetPrice(TouristSet set);
}
