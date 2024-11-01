package com.oneune.sharing.rest.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Log4j2
public final class BeanUtil {

    public static String getBeanName(Method beanFactoryMethod) {
        Bean annotation = beanFactoryMethod.getAnnotation(Bean.class);
        boolean isBeanNamedByAnnotation = annotation.value().length > 0 && !annotation.value()[0].isEmpty();
        return isBeanNamedByAnnotation ? annotation.value()[0] : beanFactoryMethod.getName();
    }

    public static List<String> getBeanNames(Class<?> configurationClass) {
        return Arrays.stream(configurationClass.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Bean.class))
                .map(BeanUtil::getBeanName)
                .toList();
    }

    public static void informAboutCreatingByConfig(Class<?> configurationClass) {
        List<String> beanNames = getBeanNames(configurationClass);
        switch (beanNames.size()) {
            case 0 -> log.info("Beans were not created from {}", configurationClass);
            case 1 -> log.info(
                    "Bean {} successfully created from {}",
                    String.join("; ", beanNames),
                    configurationClass
            );
            default -> log.info(
                    "Beans {} successfully created from {}",
                    String.join("; ", beanNames),
                    configurationClass
            );
        }
    }

    public static void informAboutCreatingByProperties(Object configurationPropertiesInstance) {
        log.info("Bean {} successfully initialized", configurationPropertiesInstance);
    }

    public static void informAboutCreatingByProperties(Class<?> configurationPropertiesClass) {
        informAboutCreatingByConfig(configurationPropertiesClass);
    }
}
