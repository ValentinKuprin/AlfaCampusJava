package vehicles;

/* Требования:
1. Класс SportCar должен быть потомком класса Car
2. В классе должно быть приватное final поле int minimalDrivingExperience = 10
3. В классе должен быть реализован метод writeQualificationDriverInfoToFile:
Параметры:
String fileText
String fileName
Функция должна записывать переданную строку в файл, находящийся по пути
src/main/resources/<fileName>
Запись в файл должна быть реализована классом FileWriter, с помощью конструкции try-catch-finally
4. В классе должен быть переопределен метод start:
Если у водителя недостаточный стаж, метод start() должен сначала записать в файл DriverWithOutQualificationInfo.txt текст в соответствии с примером:
<ФИО водителя> недостаточно квалифицирован, требуемый стаж: <значение>, стаж водителя: <значение>,
а потом вернуть ошибку NoSuchQualificationException, которая в стектрейсе должна вывести тот же текст, что и записали в файл
Если у водителя со стажем все в порядке должен вернуть результат работы родительского метода start()

PS: Не забываем про super
 */

public class SportCar {
    //Пишем код здесь
}
