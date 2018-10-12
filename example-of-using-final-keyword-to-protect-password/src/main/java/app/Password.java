package app;

public final class Password {

    private static final int KEY = 1_748_576_362;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        return password ^ KEY;
    }

    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public final boolean letMeIn(int givenPassword) {
        if (encryptDecrypt(givenPassword) == this.encryptedPassword) {
            System.out.println("Welcome, your password is correct");
            return true;
        } else {
            System.out.println("Nope, your password: " + givenPassword + " is incorrect, you cannot come in");
            return false;
        }
    }
}
