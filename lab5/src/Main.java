import java.lang.annotation.Annotation;
import java.lang.reflect.*;


public class Main {

    private static void showClassNameAndModifiers(Object obj) {
        System.out.println("Имя класса " + obj.getClass().getName());
        System.out.print("Модификаторы класса: " + Modifier.toString(obj.getClass().getModifiers()));
        try {
            String parent = Modifier.toString(obj.getClass().getSuperclass().getModifiers());
            //У всех родитель Object, поэтому даже классы которые не наследуют, будут иметь модификатор от Object
            System.out.println(", родительский: " + parent);
        } catch (Exception err) {
            System.out.println("\nВы передали объект типа Object");
            System.exit(1);
        }
    }

    private static void showConstructorsOfObject(Class cls) {
        Constructor [] constructors = cls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.print("Имя конструктора + модификатор доступа: " +
                    Modifier.toString(constructor.getModifiers()) + " " + constructor.getName() + "\n - параметры: ");
            for (Parameter parameter : constructor.getParameters()) {
                System.out.print(parameter.getType() + " " + parameter.getName() + " ");
            }
            System.out.println();
        }
    }

    public static void showDeepConstructors(Class cls) {
        showConstructorsOfObject(cls);
        if (cls.getSuperclass() == Object.class) {
            System.out.println("У класа нет базового пользовательського класа (кроме Object)");
            return;
        } else {
            showConstructorsOfObject(cls.getSuperclass());
        }
    }

    private static void runByReflection(Object obj, double ... numbers) {
        Method [] methods = obj.getClass().getDeclaredMethods();
        for(Method method: methods){
            Annotation annotation = method.getAnnotation(InfoAnnotation.class);
            if (annotation != null && annotation.annotationType() == InfoAnnotation.class){
                Class<?>[] pType  = method.getParameterTypes();
                Object[] params = new Object[pType.length];
                for (int i = 0; i < pType.length; i++) {
                    if(pType[i].toString().equals("double")){
                        params[i] = numbers[i];
                    }
                }
                try {
                    method.invoke(obj, params);
                    System.out.println("Вызванный метод: " + method.getName());
                    System.out.println("Информация о методе: " + method.getAnnotation(InfoAnnotation.class).info() +
                            "; версия: "            + method.getAnnotation(InfoAnnotation.class).version());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    System.exit(1);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

    public static void main(String[] args){
        //Завдання 1
        double x = Double.parseDouble(args[0]), y = Double.parseDouble(args[1]),
                radiusX = Double.parseDouble(args[2]), radiusY = Double.parseDouble(args[3]);
        Point dot = new Point(x, y);
        System.out.println(dot);
        Ellipse ellipse = new Ellipse(x, y, radiusX, radiusY);
        System.out.println(ellipse);
        //Завдання 2
        System.out.println("Отмеченные анотацие методы класса Point: ");
        runByReflection(dot, 5, 10);
        System.out.println("Отмеченные анотацие методы класса Ellipse: ");
        runByReflection(ellipse, 4, 3, 3.22, 2.28);
        //Завдання 3.1
        System.out.println("\nСписок конструкторов с их параметрамы класса Point: ");
        showConstructorsOfObject(dot.getClass());
        System.out.println("\nСписок конструкторов с их параметрамы класса Ellipse: ");
        showDeepConstructors(ellipse.getClass());
        //Завдання 3.2
        System.out.println();
        showClassNameAndModifiers(dot);
        System.out.println();
        showClassNameAndModifiers(ellipse);
    }
}