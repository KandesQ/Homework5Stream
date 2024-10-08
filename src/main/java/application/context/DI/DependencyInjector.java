package application.context.DI;

import application.context.DI.annotations.Dependency;
import application.context.DI.annotations.InjectDependency;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**

 Класс, реализующий DI это ядро контекста

 **/

public class DependencyInjector {
    private final Set<Object> dependencyContext = new HashSet<>();

    public void initialize(Class<?> configClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object configInstance = configClass.getDeclaredConstructor().newInstance();

        // создание и регистрация зависимостей в контекст
        for (Method method: configClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Dependency.class)) {
                Object dependency = method.invoke(configInstance);
                dependencyContext.add(dependency);
            }
        }
    }

    // Возвращает инстанс зависимости (бина), если его нету в контексте - null
    public <T> T getDependency(Class<T> type) {
        for (Object dependency: dependencyContext) {
            if (type.isInstance(dependency)) {
                return type.cast(dependency);
            }
        }
        return null;
    }

    public <T> void injectDependenciesTo(T injectToClass) throws Exception {
        for (Field field: injectToClass.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectDependency.class)) {
                Optional<Object> injectable = Optional.ofNullable(getDependency(field.getType()));

                if (injectable.isPresent()) {
                    field.setAccessible(true);
                    field.set(injectToClass, injectable.get());
                } else {
                    throw new Exception("Зависимость " + field.getType().getName() + " не содержится в контексте");
                }
            }
        }
    }
}
