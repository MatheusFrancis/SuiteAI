package screens;

import javax.swing.*;
import java.awt.*;
import org.example.Menu;

public class MainFrame {
    static public void showMainFrame() {
        JFrame frame = new JFrame("SuiteAI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Stack Overflow - https://stackoverflow.com/questions/11570356/jframe-in-full-screen-java
        frame.setLayout(new CardLayout());

        Menu menu = new Menu();

        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();

        frame.add(MenuScreen.getPanel(cl, frame), "MenuScreen");
        frame.add(SelectModelType.getPanel(cl, frame, menu), "ModelType");
        frame.add(SelectParameter.getPanel(cl, frame, menu), "Parameter");
        frame.add(SelectTrainFile.getPanel(cl, frame, menu), "TrainFile");
        frame.add(SelectTestFile.getPanel(cl, frame, menu), "TestFile");

        frame.setVisible(true);
    }
}
