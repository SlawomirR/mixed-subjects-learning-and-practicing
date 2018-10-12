package inner_classes;

public class Main {

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);

        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.weelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.weelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.weelSpeed(6000));
    }
}
