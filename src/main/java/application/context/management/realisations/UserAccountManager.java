package application.context.management.realisations;

import application.context.management.interfaces.AccountManager;

public class UserAccountManager implements AccountManager {
    @Override
    public String sayHi() {
        return "Hello I'm an account manager!";
    }
}
