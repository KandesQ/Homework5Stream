package appconfig;


import application.context.DI.annotations.Dependency;
import application.context.management.interfaces.*;
import application.context.management.realisations.UserAccountManager;

public class ApplicationConfig {

    // отвечает за регистрацию, авторизацию и тп, короче все что связано с идентификацией пользователя
//    @Dependency
//    public RegistrationManager registrationManager() {
//        return new UserRegistrationManager();
//    }

    // отвечает за управление аккаунтом пользователя
    @Dependency
    public AccountManager AccountManager() {
        return new UserAccountManager();
    }

//    // отвечает за CRuD операции привычек
//    @Dependency
//    public HabitsManager habitsManager() {
//        return new UserHabitsManager();
//    }
//
//    // отвечает за отслеживание и выполнение привычек
//    @Dependency
//    public HabitsTrackManager habitsTrackManager() {
//        return new UserHabitsTrackManager();
//    }
//
//    // отвечает и за статистику и за анализ
//    @Dependency
//    public AnalyticsManager analysisManager() {
//        return new UserAnalyticsManager();
//    }
//
//    // отвечает за уведомление о необходимости выполнения и тп
//    @Dependency
//    public ReminderManager reminderManager() {
//        return new UserReminderManager();
//    }
//
//    // отвечает за администраторские полномочия (помотреть список пользователей или привычек и тп), деятельность админа
//    @Dependency
//    public AdministrationManager administrationManager() {
//        return new UserAdministrationManager();
//    }
}
