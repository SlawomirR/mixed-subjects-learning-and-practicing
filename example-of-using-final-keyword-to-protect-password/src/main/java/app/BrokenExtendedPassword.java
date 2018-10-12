package app;

public class BrokenExtendedPassword /*extends Password <<=== because Password class is final*/ {

    private int decryptedPassword;

    public BrokenExtendedPassword(int password) {
        /*super(password); <<=== because Password class is final*/
        this.decryptedPassword = password;
        System.out.println("Original password: " + this.decryptedPassword);
    }

/*  // because storePassword() is final
    @Override
    public void storePassword() {
        super.storePassword();
        System.out.println("Original password: " + this.decryptedPassword);
    }
*/

/*  // because letMeIn() is final
    @Override
    public boolean letMeIn(int givenPassword) {
        super.storePassword();
        System.out.println("Original password: " + this.decryptedPassword);
        return super.letMeIn(givenPassword);
    }
*/
}
