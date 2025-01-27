package screens;

import org.example.Menu;

import javax.swing.*;
import java.awt.*;

public class ChooseNormalize {
    static public JPanel getPanel(CardLayout cl, JFrame mainFrame, Menu menu) {
        JPanel frame = new JPanel();

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        JPanel buttonsPanel = new JPanel();
        JButton button1 = new JButton("Sim");
        button1.addActionListener(_ -> buttonClick(true, cl, mainFrame, menu));
        JButton button2 = new JButton("Não");
        button2.addActionListener(_ -> buttonClick(false, cl, mainFrame, menu));

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Normalizar");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Deseja Normalizar?");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(_ -> cl.show(mainFrame.getContentPane(), "MenuScreen"));

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(200));
        principalPanel.add(subtitleLabel);
        principalPanel.add(Box.createVerticalStrut(40));
        principalPanel.add(buttonsPanel);
        principalPanel.add(Box.createVerticalStrut(20));
        principalPanel.add(backButton);
        wrapperPanel.add(principalPanel);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        return frame;
    }

    static private void buttonClick(boolean normalize, CardLayout cl, JFrame mainFrame, Menu menu) {
        menu.setNormalize(normalize);

        mainFrame.add(ChooseCostFunction.getPanel(cl, mainFrame, menu), "CostFunction");

        cl.show(mainFrame.getContentPane(), "CostFunction");
    }
}
