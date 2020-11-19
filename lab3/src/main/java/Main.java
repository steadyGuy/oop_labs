import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<TouristSet, Integer> sets = new HashMap<>();
        TouristSet set1 = new PicnicSet(4, 8, "AOP", 244.99, 100, 4, 2);
        TouristSet set2 = new HuntingSet(8, 6, "AGMA", 549.99, 10, true, 2);

        sets.put(set1, 22);
        sets.put(set2, 10);

        System.out.println(set1.getValuabilityOfSet() + '\n');
        System.out.println(set2.getValuabilityOfSet());

        TravelSetStore store = new TravelSetStore(sets, "My own SUPER store");
        store.setSellable(true);
        System.out.println("Магазин: " + store.getName());
        System.out.println("Продает/Открыт: " + store.isSellable());

        System.out.println("Цена набора 1: " + store.getSetPrice(set1));
        System.out.println("Цена набора 2: " + store.getSetPrice(set2) + '\n');

        System.out.println("Количество товаров до продаж: " + (store.getSetAmount(set1) + store.getSetAmount(set2)));
        for (int i = 0; i < 4; i++) {
            store.sellSet(set1);
        }

        store.sellSet(set2);
        store.sellSet(set2);

        System.out.println("Количество товаров после продаж: " + (store.getSetAmount(set1) + store.getSetAmount(set2)));
        store.setSellable(false);
        store.sellSet(set2);
    }
}
