package com.shatrov.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
/**
 * Интерфейс, который позволяет работать с консольным меню(ввод и ввывод данных)
 */

public interface InputOutput {

    /**
     * Метод, который обязателен к реализации. Получает строку у пользователя
     *
     * @param prompt - строка с информацией, сообщение пользователю
     * @return возвращает строку, введённую пользователем
     */
    String getString(String prompt);

    /**
     * Метод, который выводит на дисплей сообщения в одну строку
     * @param text - строка с информацией, сообщение пользователю
     */
    void display(String text);

    /**
     * Метод, который выводит на дисплей сообщение с переносом на следующую строку
     *
     * @param text  - строка с информацией, сообщение пользователю
     */
    default void displayLine(String text){
        display(text + "\n");
    }

    /**
     * Метод, который преобразует строку введенную пользователем в объект определённого типа
     *
     * @param prompt - строка с информацией, сообщение пользователю
     * @param promptException - сообщение пользователю об ошибке
     * @param parser - функция, преобразует строку в объект типа R
     * @param <R> - тип результата метода (определяется исходя из функции)
     * @return объект полученный из строки функцией parser
     */
    default <R> R getObject(String prompt, String promptException, Function<String, R> parser){
        while (true) {
            try {
                return parser.apply(getString(prompt));
            } catch (Exception e) {
                displayLine(promptException);
            }
        }
    }

    /**
     * Метод, который позволяет получить новый obj определенного типа
     * @param promptException - строка - исключение
     * @param predicate - функциональный интерфейс для проверки obj
     * @param supplier - функциональный интерфейс для получения нового obj
     * @param <R> - типизация возвращаемого obj
     * @return R obj
     */
    default <R> R getObject(String promptException, Predicate<R> predicate, Supplier<R> supplier) {
        do  {
            R obj = supplier.get();
            if(predicate.test(obj)) return obj;
            displayLine(promptException);
        } while(true);
    }

    /**
     * Метод, который запрашивает у пользователя строку(число) и преобразовывает строку в целое число
     * @param prompt - строка с информацией, сообщение пользователю
     * @return возвращает целое число
     */
    default Integer getInteger(String prompt) {
        return getObject(prompt, "Number format incorrect", (str) -> Integer.parseInt(str));
    }

    /**
     * Метод, который запрашивает у пользователя строку(число) и преобразовывает строку в вещественное число
     * @param prompt  - строка с информацией, сообщение пользователю
     * @return возвращает вещественное число
     */
    default Double getDouble(String prompt) {
        return getObject(prompt, "Number format incorrect", (str) -> Double.parseDouble(str));
    }

    /**
     * Метод, который запрашивает у пользователя строку(дата) и преобразовывает в указанный в параметрах метода формат
     * @param prompt  - строка с информацией, сообщение пользователю
     * @param formatter - формат
     * @return возвращает дату в формате formatter или выводит на дисплей строку с исключением
     */
    default LocalDate getDate(String prompt, DateTimeFormatter formatter){
        return getObject(prompt, "Invalid date format " + formatter.toString(), (str) -> LocalDate.parse(str, formatter));
    }


    /**
     * Метод, который запрашивает у пользователя строку(число) и проверяет удовлетворяет ли число утверждению
     * @param prompt  - строка с информацией, сообщение пользователю
     * @param predicate - функциональный интерфейс для проверки строки(число)
     * @return возвращает только то вещественное значение, которая удовлетворяет утверждению
     */
    default Double getDouble(String prompt, Predicate<Double> predicate) {
        return getObject("Значение не удовлетворяет утверждению", predicate, () -> getDouble(prompt));
    }

    /**
     * Метод, который запрашивает у пользователя строку и проверяет удовлетворяет ли строка утверждению
     * @param prompt  - строка с информацией, сообщение пользователю
     * @param predicate - функциональный интерфейс для проверки строки
     * @return возвращает только ту строку, которая удовлетворяет утверждению
     */

    default String getString(String prompt, Predicate<String> predicate){
        return getObject("Строка не удовлетворяет утверждению", predicate, () -> getString(prompt));
    }

    /**
     * Метод, который запрашивает у пользователя дату в указанном диапазоне
     * @param prompt  - строка с информацией, сообщение пользователю
     * @param from - от(включая)
     * @param to - до(не включая)
     * @return возвращает дату
     */

    default LocalDate getDate(String prompt, LocalDate from, LocalDate to){
        return getObject("Дата не в диапазоне от " + from + " до " + to,
                date -> date.isAfter(from.minusDays(1)) && date.isBefore(to),
                () -> getDate(prompt));
    }

    /**
     * Метод, который запрашивает у пользователя число в указанном диапазоне
     * @param prompt  - строка с информацией, сообщение пользователю
     * @param from - от(включая)
     * @param to  - до(не включая)
     * @return возвращает число(int)
     */
    default Integer getInteger(String prompt, int from, int to) {
        return getObject("число не в диапазоне от " + from + " до " + to,
                n -> n >= from && n < to,
                () -> getInteger(prompt));
    }


    /**
     * Метод предлагает пользователю выбор из указанных вариантов options
     * @param prompt  - строка с информацией, сообщение пользователю
     * @param options - набор опций
     * @return возвращает выбранную строку или null
     */

    default String getString(String prompt, Set<String> options){
        return options != null ? getString(prompt, (str) -> options.contains(str)) : null;
    }

    /**
     * Метод, который запрашивает у пользователя дату
     * @param prompt  - строка с информацией, сообщение пользователю
     * @return возвращает дату
     */

    default LocalDate getDate(String prompt){
        return getDate(prompt, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
