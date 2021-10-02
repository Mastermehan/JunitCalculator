import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Calculator calc;

     @BeforeEach
     void setup(){
         calc = new Calculator();
         System.out.println("Начало теста");
     }

     @AfterEach
     void tearDown() {
         System.out.println("Конец теста");
     }

    @Test
    @DisplayName("Тестируем сложение")
    void plus() {
        int x = 3;
        int y = 2;
        int expected = 5;
        final int actual = calc.plus.apply(x, y);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Тестируем вычитание")
    @MethodSource("factoryMinus")
    void minus(int x, int y, int expected) {

        final int actual = calc.minus.apply(x, y);
        assertEquals(expected, actual);
    }
        protected static Stream<Arguments> factoryMinus(){
            return Stream.of(
                    Arguments.of(2,1,1),
                    Arguments.of(6,2,4),
                    Arguments.of(-1,1,-2),
                    Arguments.of(-3,6,-9),
                    Arguments.of(4,-4,8)
            );
    }

    @Test
    @DisplayName("Тестируем умножение")
    void multiply() {
        int x = 3;
        int y = 2;
        int expected = 6;
        final int actual = calc.multiply.apply(x, y);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тестируем деление")
    void devide() {
        int x = 6;
        int y = 2;
        int expected = 3;
        final int actual = calc.devide.apply(x, y);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тестируем деление на ноль")
    void devideZero() {
        int x = 6;
        int y = 0;
        int expected = Integer.MAX_VALUE;
        final int actual = calc.devide.apply(x, y);
        assertEquals(expected,actual);
    }


    @Test
    @DisplayName("Тестируем возведение в степень")
    void pow() {
        int x = 6;
        int expected = 36;
        final int actual = calc.pow.apply(x);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Тестируем число на положительный результат ")
    void isPositive() {
        int x = 6;
        final boolean actual = calc.isPositive.test(x);
        assertTrue(actual);
    }

    @ParameterizedTest
    @DisplayName("Тестируем модуль числа")
    @MethodSource("factory")
    void absParams(int x, int expected){

        final int actual = calc.abs.apply(x);
        assertEquals(expected,actual);

    }
    public static Stream<Arguments> factory(){
        return Stream.of(
                Arguments.of(2,2),
                Arguments.of(6,6),
                Arguments.of(-1,1),
                Arguments.of(-3,3),
                Arguments.of(4,4)
        );
    }
}