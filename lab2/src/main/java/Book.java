import java.time.Year;
import java.util.ArrayList;

/**
 * Класс библиотечной книги со свойствами <b>author</b>, <b>name</b>,
 * <b>publish</b>, <b>amountIssuance</b> и <b>averageIssuance</b>.
 * @author Сопронюк Юрій
 * @version 1.0
 */
public class Book implements Bookish {

    /** Поле автор книги */
    private String author;

    /** Поле название книги */
    private String name;

    /** Поле дата публикации книги */
    private int publish;

    /** Поле общее количество выдачи книги читателям */
    private long amountIssuance;

    /** Поле среднее количество выдачи книги за 1 год */
    private int averageIssuance;

    /**
     * Конструктор по умолчанию - создание нового объекта
     * @see Book#Book()
     */
    public Book() {
        this.author = "anonymous";
        this.name = "unknown";
        setPublish(0);
        setAverageIssuance(0);
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param author - автор книги
     * @param name - название книги
     * @param publish - дата публикации книги
     * @param amountIssuance - общее количество выдачи книги читателям
     * @see Book#Book(String, String, int, long)
     */
    public Book(String author, String name, int publish, long amountIssuance) {
        setAuthor(author);
        setName(name);
        setPublish(publish);
        setAmountIssuance(amountIssuance);
        calcAverageIssuance(); //задает поле averageIssuance
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param author - автор книги
     * @param name - название книги
     * @see Book#Book(String, String)
     */
    public Book(String author, String name) {
        setAuthor(author);
        setName(name);
        setPublish(0);
        setAmountIssuance(0);
        setAverageIssuance(0);
    }

    @Override
    public String toString() {
        return "Book{ " +
                "author = '" + author + '\'' +
                ", name = '" + name + '\'' +
                ", publish = " + ((publish == 0) ? "unknown date of publishing" : publish) +
                ", total number of books issued to readers = " + amountIssuance +
                ", average number of issues per year = " + averageIssuance +
                " }\n";
    }

    /**
     * Функция получения значения поля {@link Book#publish}
     * @return возвращает дату публикации книги
     */
    public int getPublish() {
        return publish;
    }

    /**
     * Процедура определения даты публикации {@link Book#publish}
     * @param publish - дата публикации ()
     */
    public void setPublish(int publish) {
        //Первая точно датированная печатная книга — буддийская «Алмазная сутра» — была издана 11 мая 868 года
        //если указан 0, то неизвестаня дата публикации
        if(publish < 868 && publish > getCurrentYear() && publish != 0) {
            System.out.println("Incorrect date of publication");
            return;
        }
        this.publish = publish;
    }

    /**
     * Функция получения значения поля {@link Book#amountIssuance}
     * @return возвращает общее количество выдачи книги читателям
     */
    public long getAmountIssuance() {
        return amountIssuance;
    }

    /**
     * Процедура определения общего числа выдачи книги читателям {@link Book#amountIssuance}
     * @param amountIssuance - общее число выдачи книги читателям (за все года)
     */
    public void setAmountIssuance(long amountIssuance) {
        //общее количество выдачи книги читателям (то есть книг, вышедших в тираж может быть больше миллиарда)
        //если брать большой промежуток времени и популярную книгу
        if(amountIssuance >= 0) this.amountIssuance = amountIssuance;
    }

    /**
     * Функция получения значения поля {@link Book#averageIssuance}
     * @return возвращает среднее количество выдачи книги за 1 год
     */
    public int getAverageIssuance() {
        return averageIssuance;
    }

    /**
     * Процедура <b>установки</b> среднего количество выдачи книги за 1 год {@link Book#averageIssuance}
     * Эта функция будет использована только в том случае, если дата публикации не известна (равна 0)
     * @param averageIssuance - среднее количество выдачи книги за 1 год
     */
    public void setAverageIssuance(int averageIssuance) {
        if(averageIssuance >= 0) this.averageIssuance = averageIssuance;
    }

    /**
     * Приватная процедура <b>определения</b> среднего количество выдачи книги за 1 год {@link Book#amountIssuance}
     */
    private void calcAverageIssuance() {
        if (publish == 0) {
            averageIssuance = 0; //либо в производственном коде используйте setAverageIssuance со своим значением
            return;
        }
        int amount = getCurrentYear() - publish;
        if (amount == 0) averageIssuance = 0;
        averageIssuance = (int) Math.floor((float)amountIssuance / amount);
    }

    /**
     * Внутренняя функция для получения значения текущего года
     * @return возвращает текущий год в виде числа
     */
    private int getCurrentYear() {
        return Year.now().getValue();
    }

    /**
     * Функция получения значения поля {@link Book#author}
     * @return возвращает имя автора книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Процедура для установки автора книги {@link Book#author}
     * @param author - автор книги
     */
    public void setAuthor(String author) {
        if (author.length() > 40) {
            System.out.println("The author name is too long.");
            return;
        }
        this.author = author;
    }

    /**
     * Функция получения значения поля {@link Book#name}
     * @return возвращает имя книги
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура для установки имени книги {@link Book#name}
     * @param name - имя книги
     */
    public void setName(String name) {
        if (name.length() > 100) {
            System.out.println("The book name is too long.");
            return;
        }
        this.name = name;
    }

    /**
     * Перегруженный статический метод для вывода книг по критериям
     * {@link Book#author}, {@link Book#publish}
     * @param arr - список книг класса Book
     * @param author - критерий - имя автора
     * @param publish - критерий - дата публикации
     */
    public static void booksByCriterion(ArrayList<Book> arr, String author, int publish) {
        for(Book key: arr) {
            if(key.getAuthor().equals(author) && key.getPublish() == publish) {
                System.out.print(key);
            }
        }
    }

    /**
     * Перегруженный статический метод для вывода книг по критериям
     * {@link Book#author}
     * @param arr - список книг класса Book
     * @param author - критерий - имя автора
     */
    public static void booksByCriterion(ArrayList<Book> arr, String author) {
        for(Book key: arr) {
            if(key.getAuthor().equals(author)) {
                System.out.print(key);
            }
        }
    }

    /**
     * Перегруженный статический метод для вывода книг по критериям
     * {@link Book#publish}
     * @param arr - список книг класса Book
     * @param publish - критерий - дата публикации
     */
    public static void booksByCriterion(ArrayList<Book> arr, int publish) {
        for(Book key: arr) {
            if(key.getPublish() == publish) {
                System.out.print(key);
            }
        }
    }

    /**
     * Статический метод для сравнения двух книг по их двум полям:
     * {@link Book#amountIssuance}, {@link Book#averageIssuance}
     * @param b1 - первая книга для сравнения
     * @param b2 - вторая книга для сравнения
     */
    public static void compareBooks(Book b1, Book b2) {
        long diffIssuanceAmount = b1.getAmountIssuance() - b2.getAmountIssuance();
        int diffIssuanceAverage = b1.getAverageIssuance() - b2.getAverageIssuance();

        System.out.println("The difference between \"" + b1.getName() + "\" and \"" + b2.getName() + "\" are:");

        System.out.println(b1.getName() + " : " + b1.getAmountIssuance());
        System.out.println(b2.getName() + " : " + b2.getAmountIssuance());
        System.out.println("difference in total number of books issued to readers : " + Math.abs(diffIssuanceAmount));

        System.out.println(b1.getName() + " : " + b1.getAverageIssuance());
        System.out.println(b2.getName() + " : " + b2.getAverageIssuance());
        System.out.println("difference in average number of issues per year : " + Math.abs(diffIssuanceAverage));
    }

    /**
     * Статический метод для вывода списка книг в консоле
     * @param books - список книг
     */
    public static void showBooks(ArrayList<Book> books) {
        for(Book value: books) {
            System.out.print("Book name: " + value.getName());
            System.out.print(" | Author: " + value.getAuthor());
            System.out.print(" | Publish: " + value.getPublish());
            System.out.println();
        }
    }
}