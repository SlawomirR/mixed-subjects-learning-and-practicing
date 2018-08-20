public class JavaLogicalOperatorsBehavior {

    public static void main(String[] args) {
        System.out.println("// OR");
        System.out.println("TRUE  || TRUE ===> " + (true || true));     // true   ||
        System.out.println("TRUE  || FALSE ==> " + (true || false));    // true   ||
        System.out.println("FALSE || TRUE ===> " + (false || true));    // true   ||
        System.out.println("FALSE || FALSE ==> " + (false || false));   // false  ||

        System.out.println("// AND");
        System.out.println("TRUE  && TRUE ===> " + (true && true));     // true   &&
        System.out.println("TRUE  && FALSE ==> " + (true && false));    // false  &&
        System.out.println("FALSE && TRUE ===> " + (false && true));    // false  &&
        System.out.println("FALSE && FALSE ==> " + (false && false));   // false  &&

        System.out.println("// XOR");
        System.out.println("TRUE  ^ TRUE ===> " + (true ^ true));       // false  ^
        System.out.println("TRUE  ^ FALSE ==> " + (true ^ false));      // true   ^
        System.out.println("FALSE ^ TRUE ===> " + (false ^ true));      // true   ^
        System.out.println("FALSE ^ FALSE ==> " + (false ^ false));     // false  ^
    }
}
