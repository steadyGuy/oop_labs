/**
 * Интерфейс, который определяет функционал для задания/получения
 * некого стандарта производства (может быть использован в любом классе,
 * где есть стандарт)
 * @author Сопронюк Юрій
 * @version 1.0
 */
public interface Standard {
    //Метод по умолчанию
    //используется, если класс, реализующий данный интерфейс, не реализует метод
    default String getStandard() {
        return "AAPP"; //NATO Allied Acquisition Practices Publications.
    }
    void setStandard(String standard);
}
