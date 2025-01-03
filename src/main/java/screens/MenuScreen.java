package screens;

import javax.swing.*;
import java.awt.*;

public class MenuScreen {
    // ChatGPT utilizado para aprender a centralizar componentes
     static public void showScreen() {
        JFrame frame = new JFrame("SuiteAI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Stack Overflow - https://stackoverflow.com/questions/11570356/jframe-in-full-screen-java

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        JPanel buttonsPanel = new JPanel();
        JButton button1 = new JButton("Abrir Conjunto de Dados");
        JButton button2 = new JButton("Aplicar Modelo");
        JButton button3 = new JButton("Plotar Dados");

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("SuiteAI");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(200));
        principalPanel.add(buttonsPanel);
        wrapperPanel.add(principalPanel);
        frame.getContentPane().add(wrapperPanel, BorderLayout.CENTER);
    }
}
