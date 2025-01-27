package screens;

import org.example.Menu;

import javax.swing.*;
import java.awt.*;

// TODO: Precisa de parametros referentes a quantidade de colunas, ver Menu.runModel()

public class SelectParameter {
    static public JPanel getPanel(CardLayout cl, JFrame mainFrame, Menu menu) {
        JPanel frame = new JPanel();

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        JLabel titleLabel = new JLabel("Selecionar Parâmetro");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Digite o valor do parâmetro theta");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField thetaInput = new JTextField();
        thetaInput.setMaximumSize(new Dimension(200, 30));
        thetaInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        thetaInput.setHorizontalAlignment(JTextField.CENTER);

        JButton continueButton = new JButton("Continuar");
        continueButton.addActionListener(_ -> continueClick(cl, mainFrame, thetaInput.getText(), menu));

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(_ -> cl.show(mainFrame.getContentPane(), "ApplyModel"));

        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(200));
        principalPanel.add(subtitleLabel);
        principalPanel.add(Box.createVerticalStrut(40));
        principalPanel.add(thetaInput);
        principalPanel.add(continueButton);
        principalPanel.add(backButton);
        wrapperPanel.add(principalPanel);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        return frame;
    }

    static private void continueClick(CardLayout cl, JFrame mainFrame, String parameter, Menu menu) {
        if (parameter.isEmpty()) {
            JOptionPane.showMessageDialog(mainFrame, "Necessário valor", "Erro", JOptionPane.ERROR_MESSAGE);

            return;
        }

        menu.setParameter(parameter);
        cl.show(mainFrame.getContentPane(), "Normalize");
    }
}
