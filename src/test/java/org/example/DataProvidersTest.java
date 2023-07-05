package org.example;

import org.assertj.core.api.Assertions;
import org.example.dto.Animal;
import org.example.dto.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class DataProvidersTest {

    @MethodSource("provideAnimals")
    @ParameterizedTest(name = "{1}")
    @DisplayName("Data provider from method test")
    public void dataProviderFromMethodTest(Animal animal, String testName) {
        Assertions.assertThat(animal.getAge() >= 3)
                .withFailMessage("Animal age should be greater or equal 3")
                .isTrue();
    }

    private static Stream<Arguments> provideAnimals() {
        return Stream.of(
                Arguments.of(new Animal("Cat", 3), "Test with cat animal"),
                Arguments.of(new Animal("Dog", 5), "Test with dog animal")
        );
    }

    @ParameterizedTest(name = "Test with primitive value : {0}")
    @ValueSource(ints = {5, 2, 3})
    @DisplayName("Data provider test with primitives")
    public void dataProviderWithPrimitives(int value) {
        System.out.println(value);
    }

    @ParameterizedTest(name = "Country for testing : {0}")
    @EnumSource(Country.class)
    @DisplayName("Data provider test with enum")
    public void dataProviderWithEnum(Country country) {
        System.out.println(country.getName());
    }

}
