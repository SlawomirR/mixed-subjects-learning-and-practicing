public class ShirtShop {

    public static void main(String[] args) {
        Tshirt tshirt = new Tshirt();

        tshirt.setSize(Size.MDEIUM);

        System.out.println(tshirt.getSize());
        System.out.println(tshirt.getSize().getDescription());
        System.out.println(System.lineSeparator() + "Available t-shirt sizes: ");

        for (Size size : Size.values()) {
            System.out.print(size + " - ");
            System.out.print(size.getDescription() + System.lineSeparator());
        }
    }
}
