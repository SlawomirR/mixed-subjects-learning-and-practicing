package app;

public class Main {

    public static void main(String[] args) {
        int pass = 674312;
        Password password = new Password(pass);
        /*Password password = new BrokenExtendedPassword(pass); <<=== because Password class is final*/
        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(523266);
        password.letMeIn(9773);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(674312);
    }
}
