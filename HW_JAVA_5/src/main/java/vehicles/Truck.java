package vehicles;

/* Требования:
1. Класс Truck должен быть потомком класса Car
2. В классе должно быть приватное поле int loadCapacity
3. В классе должен быть реализован метод writeTrackInfoToFile:
Параметры:
String fileText
String fileName
Функция должна записывать переданную строку в файл, находящийся по пути
src/main/resources/<fileName>
Запись в файл должна быть реализована классом FileWriter, с помощью конструкции try-with-resources
4. В классе должен быть переопределен метод toString который сначала записывает в файл TruckInfo.txt, а потом возвращает строку с информацией о грузовике в соответствии с примером:
Truck info:
Type: <значение>; Weight: <значение>; Engine manufacturer: <значение>; Engine power: <значение>; loadCapacity: <значение>

PS: Не забываем про super
 */

public class Truck {
    //Пишем код здесь
}
