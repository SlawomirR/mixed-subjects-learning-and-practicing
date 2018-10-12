package app;

public class BrokenExtendedPassword extends Password {

    private int decryptedPassword;

    public BrokenExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    @Override
    public void storePassword() {
        super.storePassword();
        System.out.println("Original password: " + this.decryptedPassword);
    }
}
