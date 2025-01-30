package screens;

import org.example.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Precisa de parametros referentes a quantidade de colunas, ver Menu.runModel()

public class SelectParameter {
    static public JPanel getPanel(CardLayout cl, JFrame mainFrame, Menu menu) {
        JPanel frame = new JPanel();

        System.out.println(menu.getModel());

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        JLabel titleLabel = new JLabel("Selecionar Parâmetro");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Digite o valor do parâmetro theta");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<JTextField> inputs = new ArrayList<>();

        JPanel inputsPanel = new JPanel();
        inputsPanel.setLayout(new BoxLayout(inputsPanel, BoxLayout.PAGE_AXIS));
        inputsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        int inputCount = menu.getTrainSetLength();

        for (int i = 0; i < inputCount; i++) {
            JLabel inputLabel = new JLabel("Parâmetro " + (i + 1) + ":");
            inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JTextField inputField = new JTextField();
            inputField.setMaximumSize(new Dimension(200, 30));
            inputField.setAlignmentX(Component.CENTER_ALIGNMENT);
            inputField.setHorizontalAlignment(JTextField.CENTER);

            inputs.add(inputField);
            inputsPanel.add(inputLabel);
            inputsPanel.add(Box.createVerticalStrut(10));
            inputsPanel.add(inputField);
            inputsPanel.add(Box.createVerticalStrut(20));
        }

        // uso do chat gpt para aprender a fazer scrollavel
        JScrollPane scrollPane = new JScrollPane(inputsPanel);
        scrollPane.setPreferredSize(new Dimension(250, 300));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton continueButton = new JButton("Continuar");
        continueButton.addActionListener(_ -> continueClick(cl, mainFrame, inputs, menu));

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(_ -> cl.show(mainFrame.getContentPane(), "ModelType"));

        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(200));
        principalPanel.add(subtitleLabel);
        principalPanel.add(Box.createVerticalStrut(40));
        principalPanel.add(scrollPane);
        principalPanel.add(continueButton);
        principalPanel.add(backButton);
        wrapperPanel.add(principalPanel);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        return frame;
    }

    static private void continueClick(CardLayout cl, JFrame mainFrame, List<JTextField> inputs, Menu menu) {
        JTextField[] inputsArray = inputs.toArray(new JTextField[0]);
        double[][] parameterList = new double[inputsArray.length][1];

        for (int i = 0; i < inputsArray.length; i++) {
            String actualParameter = inputsArray[i].getText();

            if (actualParameter.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Digite todos os parâmetros", "Erro", JOptionPane.ERROR_MESSAGE);

                return;
            }

            parameterList[i][0] = Double.parseDouble(actualParameter);
        }
        System.out.println(Arrays.deepToString(parameterList));
        menu.setParameter(parameterList);
        cl.show(mainFrame.getContentPane(), "Normalize");
    }
}
