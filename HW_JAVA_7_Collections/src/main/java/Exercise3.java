import java.util.List;
import java.util.stream.Collectors;

/* Требования:
1. Метод getUniqueNumbers должен вернуть коллекцию которая содержит только уникальные элементы из переданного на вход списка
 */

public class Exercise3 {
    public List<Integer> getUniqueNumbers(List<Integer> integers) {
        return integers.stream().distinct().collect(Collectors.toList());
    }
}
