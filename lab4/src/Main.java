public class Main {
    public static void main(String[] args) {
        System.out.println("Количество аргументов: " + args.length);

        System.out.println("Исходные данные (аргументы) из консоли: ");
        System.out.println(StringHandler.getArgumentsInStr(args, true));

        System.out.println("Результаты работы программы (строка символов, содержащихся в аргументах): ");
        StringHandler.showResultOfHandler(args);
    }
}