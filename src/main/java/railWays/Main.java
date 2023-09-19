package railWays;

import railWays.builder.runner.Runner;
import railWays.ui.BaseUI;
import railWays.builder.builders.UserBuilder;

import java.util.Scanner;

public class Main {
    public static Scanner scannerInt = new Scanner(System.in);
    public static Scanner scannerStr = new Scanner(System.in);
    public static void main(String[] args) {


        Runner.runCode();


        BaseUI baseUI = new BaseUI();
        baseUI.start();

    }

}
