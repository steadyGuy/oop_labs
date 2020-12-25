public class StoreInfo {
    private String shopName;
    private int shopId;
    private boolean saleAbility;

    public StoreInfo(String shopName, boolean saleAbility) {
        this.shopName = shopName;
        this.saleAbility = saleAbility;
    }

    public StoreInfo(int shopId) {
        this.shopId = shopId;
        this.shopName = "Магазин №" + shopId;
        this.saleAbility = false;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public boolean getSaleAbility() {
        return saleAbility;
    }

    public void setSaleAbility(boolean saleAbility) {
        this.saleAbility = saleAbility;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "StoreInfo{" +
                "shopName='" + shopName + '\'' +
                ", shopId=" + shopId +
                ", saleAbility=" + saleAbility +
                '}';
    }
}
