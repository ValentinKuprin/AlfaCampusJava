import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Exercise3Tests {

    @Test
    void checkIsValuesUnique() {
        Exercise3 exercise3 = new Exercise3();
        Random random = new Random();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            integers.add(random.nextInt(50));
        }
        Assertions.assertTrue(exercise3.getUniqueNumbers(integers).size() == integers.stream().distinct().collect(Collectors.toSet()).size(),
                "В коллекции присутствуют неуникальные элементы");
    }
}
