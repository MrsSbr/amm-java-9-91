package ru.arsentev.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat("Whiskers", 3, 4.5, Color.BLACK, Gender.MALE, true);
    }

    @Test
    void testDefaultConstructor() {
        Cat defaultCat = new Cat();
        assertNull(defaultCat.getName());
        assertEquals(0, defaultCat.getAge());
        assertEquals(0.0, defaultCat.getWeight());
        assertNull(defaultCat.getColor());
        assertNull(defaultCat.getGender());
        assertFalse(defaultCat.getIsPleased());
    }

    @Test
    void testGetters() {
        assertEquals("Whiskers", cat.getName());
        assertEquals(3, cat.getAge());
        assertEquals(4.5, cat.getWeight());
        assertEquals(Color.BLACK, cat.getColor());
        assertEquals(Gender.MALE, cat.getGender());
        assertTrue(cat.getIsPleased());
    }

    @ParameterizedTest
    @CsvSource({
            "Mittens, 5, 6.0, WHITE, FEMALE, false",
            "Shadow, 2, 3.2, GRAY, MALE, true"
    })
    void testSetters(String name, int age, double weight, Color color, Gender gender, boolean isPleased) {
        cat.setName(name);
        cat.setAge(age);
        cat.setWeight(weight);
        cat.setColor(color);
        cat.setGender(gender);
        cat.setIsPleased(isPleased);

        assertEquals(name, cat.getName());
        assertEquals(age, cat.getAge());
        assertEquals(weight, cat.getWeight());
        assertEquals(color, cat.getColor());
        assertEquals(gender, cat.getGender());
        assertEquals(isPleased, cat.getIsPleased());
    }

}