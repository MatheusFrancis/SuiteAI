package screens;

import org.example.Menu;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ShowResults {
    static private JButton continueButton;

    static public JPanel getPanel(CardLayout cl, JFrame mainFrame, Menu menu) {
        JPanel frame = new JPanel();

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        JLabel titleLabel = new JLabel("Resultado");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<JLabel> resultsLabelList = new ArrayList<>();
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.PAGE_AXIS));
        resultsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (double[] resultArr : menu.getResult()) {
            double result = resultArr[0];

            JLabel resultLabel = new JLabel("" + result);
            resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            resultsLabelList.add(resultLabel);
            resultsPanel.add(resultLabel);
            resultsPanel.add(Box.createVerticalStrut(20));
        }

        JScrollPane scrollPane = new JScrollPane(resultsPanel);
        scrollPane.setPreferredSize(new Dimension(250, 300));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton backButton = new JButton("Voltar para Menu");
        backButton.addActionListener(_ -> cl.show(mainFrame.getContentPane(), "MenuScreen"));

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton saveButton = new JButton("Salvar Resultados");
        saveButton.addActionListener(_ -> saveResultsToFile(menu));
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(200));
        principalPanel.add(scrollPane);
        principalPanel.add(Box.createVerticalStrut(20));
        principalPanel.add(saveButton);
//        principalPanel.add(continueButton);
        principalPanel.add(backButton);
        wrapperPanel.add(principalPanel);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        return frame;
    }

    static private void saveResultsToFile(Menu menu) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resultados.txt"))) {
            for (double[] resultArr : menu.getResult()) {
                for (double value : resultArr) {
                    writer.write(value + " ");
                }
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Resultados salvos em 'resultados.txt'", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
