import appconfig.ApplicationConfig;
import application.context.DI.DependencyInjector;

import java.lang.reflect.InvocationTargetException;

public class StartHabitsTrackApplication {
    // точка входа в приложение
    public static void main(String[] args) throws Exception {
        // перед стартом приложения будет запускаться инжектор зависимостей
        // чтобы инициалиировать все зависимости, помеченные как @Dependency
        // в инжектор передается файл конфигурации проекта
        DependencyInjector dependencyInjector = new DependencyInjector();
        dependencyInjector.initialize(ApplicationConfig.class);

        HabitsTrackApplication habitsTrackApplication = new HabitsTrackApplication();

        // после этого кода в habitsTrackApp внедряться все зависимости
        dependencyInjector.injectDependenciesTo(habitsTrackApplication);


        // Старт приложения )
        habitsTrackApplication.start();
    }
}
