package screens;

import javax.swing.*;
import java.awt.*;

public class MenuScreen {
    // ChatGPT utilizado para aprender a centralizar componentes
     static public JPanel getPanel(CardLayout cl, JFrame mainFrame) {
        JPanel mainPanel = new JPanel();

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        JPanel buttonsPanel = new JPanel();
        JButton button1 = new JButton("Abrir Conjunto de Dados");
        JButton button2 = new JButton("Ajustar Modelo");
        button2.addActionListener(_ -> cl.show(mainFrame.getContentPane(), "ApplyModel"));

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("SuiteAI");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(200));
        principalPanel.add(buttonsPanel);
        wrapperPanel.add(principalPanel);
        mainPanel.add(wrapperPanel, BorderLayout.CENTER);

        return mainPanel;
    }
}
