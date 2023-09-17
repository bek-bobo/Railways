package railWays;

import railWays.ui.AdminUI;
import railWays.user.userBuilder.UserBuilder;

import java.util.Scanner;

public class Main {
    public static Scanner scannerInt = new Scanner(System.in);
    public static Scanner scannerStr = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
//        BaseUI baseUI = new BaseUI();
//        baseUI.start();



        UserBuilder userBuilder = new UserBuilder();
        userBuilder.start();

        Thread.sleep(3000);
        AdminUI.start();
    }

}
