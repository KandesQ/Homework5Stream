import application.context.DI.annotations.InjectDependency;
import application.context.management.interfaces.*;

import java.util.TreeMap;

/**

 Для дальнейшего удобства я решил реализовать свой собственный механизм
 Dependency Injection, поэтому просто буду вешать аннотации на методы

 **/

// сам класс тоже зависимость исполняемого класса :))
public class HabitsTrackApplication {
    // внедрение зависимостей для удобства и дальнейшей поддержки
    @InjectDependency
    private AccountManager accountManager;

//    @InjectDependency
//    private AnalyticsManager analyticsManager;
//
//    @InjectDependency
//    private HabitsManager habitsManager;
//
//    @InjectDependency
//    private HabitsTrackManager habitsTrackManager;
//
//    @InjectDependency
//    private RegistrationManager registrationManager;


    public void start() {
        // основная абстрактная логика
        // типа цикл-сервер для приложения
        System.out.println("HMM");
        System.out.println(accountManager.sayHi());
        // РАБОООТАЕТЕЕЕТ
    }
}
