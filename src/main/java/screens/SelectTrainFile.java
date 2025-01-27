package screens;

import org.example.Menu;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SelectTrainFile {
    static private String filePath = "";
    static private JButton continueButton;

    static public JPanel getPanel(CardLayout cl, JFrame mainFrame, Menu menu) {
        JPanel frame = new JPanel();

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        JLabel titleLabel = new JLabel("Selecione um Arquivo de Treino");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel directoryLabel = new JLabel("Nenhum arquivo selecionado");
        directoryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        directoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        continueButton = new JButton("Continuar");
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        continueButton.addActionListener(_ -> continueButtonClick(cl, mainFrame, menu));
        continueButton.setVisible(false);

        JButton selectButton = new JButton("Selecionar Arquivo");
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        selectButton.addActionListener(_ -> selectButtonClick(directoryLabel, mainFrame));

        JButton backButton = new JButton("Voltar");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> cl.show(mainFrame.getContentPane(), "MenuScreen"));

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(100));
        principalPanel.add(directoryLabel);
        principalPanel.add(Box.createVerticalStrut(40));
        principalPanel.add(selectButton);
        principalPanel.add(Box.createVerticalStrut(5));
        principalPanel.add(continueButton);
        principalPanel.add(Box.createVerticalStrut(20));
        principalPanel.add(backButton);

        wrapperPanel.add(principalPanel);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        return frame;
    }

    static public void continueButtonClick(CardLayout cl, JFrame mainFrame, Menu menu) {
        try {
            menu.openTrainDataset(filePath);

            cl.show(mainFrame.getContentPane(), "TestFile");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(mainFrame, "Arquivo não suportado", "Erro", JOptionPane.ERROR_MESSAGE);

            return;
        }
    }

    static public void selectButtonClick(JLabel directoryLabel, JFrame mainFrame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(mainFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            filePath = selectedDirectory.getAbsolutePath();
            directoryLabel.setText("Arquivo Selecionado: " + filePath);
            continueButton.setVisible(true);
        } else {
            directoryLabel.setText("Nenhum arquivo selecionado");
            filePath = "";
            continueButton.setVisible(false);
        }
    }
}
