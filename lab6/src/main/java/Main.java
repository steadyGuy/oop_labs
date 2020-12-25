import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<TouristSet, Integer> sets = new HashMap<>();
        TouristSet set1 = new PicnicSet(4, 8, "AOP", 244.99, 100, 4, 2);
        TouristSet set2 = new HuntingSet(8, 6, "AGMA", 549.99, 10, true, 2);
        StoreInfo shop = new StoreInfo(2);
        sets.put(set1, 22);
        sets.put(set2, 10);
        TravelSetStore store = new TravelSetStore(sets, shop); //передаем наши наборы и информационный объект магазину

        String filePath = new File("").getAbsolutePath()+"/"+store.hashCode()+".bin";
        System.out.println(filePath);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(store);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception err) {
            System.out.println(err);
            System.exit(500);
        }

        TravelSetStore dataToRead = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            dataToRead = (TravelSetStore) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Считанные данные: " + dataToRead);
        } catch (Exception err) {
            System.out.println(err);
            System.exit(500);
        }

        if(dataToRead.getSetPrice(set1) == store.getSetPrice(set1) &&
                dataToRead.getSetAmount(set1) == store.getSetAmount(set1) &&
                dataToRead.isSellable() == store.isSellable() &&
                dataToRead.getStoreAbout().getSaleAbility() == store.getStoreAbout().getSaleAbility() &&
                dataToRead.getStoreAbout().getShopId() == store.getStoreAbout().getShopId() &&
                dataToRead.getStoreAbout().getShopName().equals(store.getStoreAbout().getShopName())
                ){
            System.out.println("Основные данные из байт совпали с оригиналом");
        }
        else{
            System.out.println("Основные данные из байт НЕ совпали с оригиналом");
        }
    }
}
