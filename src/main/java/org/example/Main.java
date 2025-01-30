package org.example;
import screens.MainFrame;

import java.util.Scanner;
import java.io.FileNotFoundException;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //MainFrame.showMainFrame();
        Menu myMenu = new Menu();
        myMenu.openDataset();
        myMenu.applyModel();
        //myMenu.plotDataset();

    }
}