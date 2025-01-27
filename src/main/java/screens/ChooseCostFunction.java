package screens;

import org.example.Menu;

import javax.swing.*;
import java.awt.*;

public class ChooseCostFunction {
    static private JButton continueButton;

    static public JPanel getPanel(CardLayout cl, JFrame mainFrame, Menu menu) {
        JPanel frame = new JPanel();

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        String[] optionsLinear = {"MSE (Mean Squared Error)"};
        String[] optionsLogistic = {"Cross-Entropy"};
        JComboBox<String> dropdown = new JComboBox<>(menu.getModel() == 1 ? optionsLinear : optionsLogistic);
        dropdown.setMaximumSize(new Dimension(200, 30));
        dropdown.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Função de Custo");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Escolha uma Função de Custo");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        continueButton = new JButton("Continuar");
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        continueButton.addActionListener(_ -> continueButtonClick(cl, mainFrame, menu));

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(_ -> cl.show(mainFrame.getContentPane(), "Normalize"));

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(200));
        principalPanel.add(subtitleLabel);
        principalPanel.add(Box.createVerticalStrut(40));
        principalPanel.add(dropdown);
        principalPanel.add(Box.createVerticalStrut(20));
        principalPanel.add(continueButton);
        principalPanel.add(backButton);
        wrapperPanel.add(principalPanel);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        return frame;
    }

    static private void continueButtonClick(CardLayout cl, JFrame mainFrame, Menu menu) {
        cl.show(mainFrame.getContentPane(), "Optimizer");
    }
}
