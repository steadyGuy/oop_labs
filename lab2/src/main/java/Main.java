import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JSONObject arrJSON, json; // Объект со всеми данными из JSON файла
        String data = JSON.getDataFromFile("src/main/resources/db.json");
        arrJSON = JSON.getJSON(data);

        ArrayList<JSONObject> arr = (ArrayList<JSONObject>) arrJSON.get("books"); // Получаем массив
        ArrayList<Book> books = new ArrayList<>();

        String author, name;
        long publish;
        long amount;
        for (JSONObject obj: arr) {
            json = JSON.getJSON(obj.toString());
            author = json.get("author").toString();
            name = (String) json.get("name");
            publish = (long) json.get("year");
            amount = (long) json.get("amountIssuance");
            books.add(new Book(author, name, (int)publish, amount));
        }

        books.add(new Book());
        books.add(new Book());

        System.out.println("\nDouglas Adams books for 1982: ");
        Book.booksByCriterion(books, "Дуглас Адамс", 1982);

        System.out.println("\nVirginia Andrews books for 1979: ");
        Book.booksByCriterion(books, "Вирджиния Эндрюс", 1979);

        System.out.println("\nDouglas Adams books: ");
        Book.booksByCriterion(books, "Дуглас Адамс");

        System.out.println("\nBooks for 1980: ");
        Book.booksByCriterion(books, 1980);
        System.out.println("\nBooks for 1982: ");
        Book.booksByCriterion(books, 1982);

        System.out.println("\nCompare books: ");
        Book.compareBooks(books.get(0), books.get(3));

        Book specialBook = new Book("Михаил Булгаков", "Мастер и Маргарита");
        books.add(specialBook);
        System.out.println("\nSpecial: \n" + specialBook);
        specialBook.setPublish(1966);
        specialBook.setAmountIssuance(80000000);
        System.out.println("Edited special: \n" + specialBook);

        System.out.println("All books: \n");
        Book.showBooks(books);
    }
}
