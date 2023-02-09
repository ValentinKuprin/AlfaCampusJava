package secrets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rectangle.Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

    Rectangle rectangle = new Rectangle(10, 15);

    @Test
    @DisplayName("Тест на метод измерения площади прямоугольника")
    void calculateAreaTest() {
    assertEquals(150, rectangle.calculateArea());
    }

    @Test
    @DisplayName("Тест на метод измерения периметра прямоугольника")
    void calculatePerimeterTest() {
        assertEquals(50, rectangle.calculatePerimeter());
    }
}
