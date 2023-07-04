package org.example.annotation.extension;

import org.example.annotation.CreateAnimal;
import org.example.dto.Animal;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CreateAnimalExtension implements BeforeTestExecutionCallback, ParameterResolver {

    public static final ExtensionContext.Namespace ANIMAL_NAMESPACE =
            ExtensionContext.Namespace.create(CreateAnimalExtension.class);

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        extensionContext.getStore(ANIMAL_NAMESPACE)
                .put("Default", new Animal("Default", 5));
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter()
                .isAnnotationPresent(CreateAnimal.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        CreateAnimal operation = parameterContext.getParameter()
                .getAnnotation(CreateAnimal.class);
        Animal animalFromNamespace = (Animal) extensionContext.getStore(ANIMAL_NAMESPACE)
                .get("Default");

        var age = operation.age();
        var name = operation.name();

        Animal animal;
        if (!name.isBlank()) {
            animal = new Animal(name, age);
        } else {
            animal = animalFromNamespace;
        }

        return animal;
    }

}

