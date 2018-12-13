import java.util.Scanner;

public class chooseVersionUI extends UI{
    public static int getVersion(){
        int version;
        Scanner sc = new Scanner(System.in);
        System.out.println("Give game version 1 or 2: ");

        while (true){
            try {
                version = Integer.parseInt(sc.nextLine());
                if (version!=1 && version!=2){
                    clearScreen();
                    System.out.println("You have to chose one of the two versions.");
                    System.out.println("Try again:\n");
                    continue;
                }
                break;
            }
            catch (NumberFormatException nfe) {
                clearScreen();
                System.out.println("You have to chose one of the two versions.");
                System.out.println("Try again:\n");
            }
        }
        clearScreen();
        return version;
    }
}
