public interface Standard {
    //Метод по умолчанию
    //используется, если класс, реализующий данный интерфейс, не реализует метод
    default String getStandard() {
        return "AAPP"; //NATO Allied Acquisition Practices Publications.
    }
    void setStandard(String standard);
}
