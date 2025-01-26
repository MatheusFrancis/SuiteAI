package screens;

import screens.applyModel.ApplyModelParameterScreen;
import screens.applyModel.ApplyModelSelectDirectoryScreen;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    static public void showMainFrame() {
        JFrame frame = new JFrame("SuiteAI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Stack Overflow - https://stackoverflow.com/questions/11570356/jframe-in-full-screen-java
        frame.setLayout(new CardLayout());

        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();

        frame.add(MenuScreen.getPanel(cl, frame), "MenuScreen");
        frame.add(ApplyModelFlowOptionsScreen.getPanel(cl, frame), "ApplyModel");
        frame.add(ApplyModelParameterScreen.getPanel(cl, frame), "ApplyModelParameter");
        frame.add(ApplyModelSelectDirectoryScreen.getPanel(cl, frame), "ApplyModelDirectory");

        frame.setVisible(true);
    }
}
