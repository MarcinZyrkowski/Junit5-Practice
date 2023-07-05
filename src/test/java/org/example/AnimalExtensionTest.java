package org.example;

import org.example.annotation.CreateAnimal;
import org.example.dto.Animal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimalExtensionTest {

    @Test
    @DisplayName("Default animal extension test")
    public void defaultAnimalExtensionTest(@CreateAnimal Animal animal) {
        Animal defaultAnimal = Animal.builder()
                .name("Default")
                .age(5)
                .build();

        assertThat(animal.getName()).isEqualTo(defaultAnimal.getName());
        assertThat(animal.getAge()).isEqualTo(defaultAnimal.getAge());
    }

    @Test
    @DisplayName("Custom animal extension test")
    public void customAnimalExtensionTest(@CreateAnimal(name = "Fluffy", age = 1) Animal animal) {
        Animal customAnimal = Animal.builder()
                .name("Fluffy")
                .age(1)
                .build();

        assertThat(animal.getName()).isEqualTo(customAnimal.getName());
        assertThat(animal.getAge()).isEqualTo(customAnimal.getAge());
    }

}
