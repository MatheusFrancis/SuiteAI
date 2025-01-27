package screens;

import org.example.Menu;

import javax.swing.*;
import java.awt.*;
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

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(200));
        principalPanel.add(scrollPane);
        principalPanel.add(Box.createVerticalStrut(20));
//        principalPanel.add(continueButton);
        principalPanel.add(backButton);
        wrapperPanel.add(principalPanel);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        return frame;
    }

    static private void continueButtonClick(CardLayout cl, JFrame mainFrame, Menu menu) {
        cl.show(mainFrame.getContentPane(), "Hypothesis");
    }
}
