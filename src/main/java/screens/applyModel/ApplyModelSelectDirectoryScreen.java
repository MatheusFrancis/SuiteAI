package screens.applyModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ApplyModelSelectDirectoryScreen {
    static public JPanel getPanel(CardLayout cl, JFrame mainFrame) {
        JPanel frame = new JPanel();

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.PAGE_AXIS));

        JLabel titleLabel = new JLabel("Selecione um Diretório");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel directoryLabel = new JLabel("Nenhum diretório selecionado");
        directoryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        directoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton selectButton = new JButton("Selecionar Diretório");
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        selectButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(mainFrame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                directoryLabel.setText("Diretório Selecionado: " + selectedDirectory.getAbsolutePath());
            } else {
                directoryLabel.setText("Nenhum diretório selecionado");
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> cl.show(mainFrame.getContentPane(), "ApplyModelParameter"));

        principalPanel.add(titleLabel);
        principalPanel.add(Box.createVerticalStrut(100));
        principalPanel.add(directoryLabel);
        principalPanel.add(Box.createVerticalStrut(40));
        principalPanel.add(selectButton);
        principalPanel.add(Box.createVerticalStrut(20));
        principalPanel.add(backButton);

        wrapperPanel.add(principalPanel);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        return frame;
    }
}
