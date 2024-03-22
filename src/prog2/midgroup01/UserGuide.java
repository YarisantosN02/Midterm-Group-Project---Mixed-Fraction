package prog2.midgroup01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGuide extends JFrame {

    public UserGuide() {
        super("Fraction Calculator User Guide");
        createComponents();
    }

    private void createComponents() {
        setPreferredSize(new Dimension(500, 340));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the background color for the entire window (frame)
        getContentPane().setBackground(new java.awt.Color(253, 202, 64)); // Yellow color (RGB)

        // Create a main panel (optional, can be removed)
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(253, 202, 64)); // Remove if using frame background

        // Instructions
        JTextArea instructions = new JTextArea(
                "Welcome to the Fraction Calculator!\n\n" +
                        "Here's how to get started:\n\n" +
                        "1. Enter fractions (including whole numbers) in the text fields provided.\n" +
                        "2. Select the operation from the dropdown menu.\n" +
                        "3. Click the 'Compute' button to see the result.\n" +
                        "4. Use the 'Clear' button to reset the input fields.\n\n" +
                        "**Tip:** If no whole number is present, simply enter '0' in the whole number field."
        );
        instructions.setEditable(false);
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        instructions.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(instructions);
        scrollPane.setBorder(null); // Remove default scrollpane border for cleaner look

        // Add components to the main panel (optional)
      mainPanel.add(scrollPane, BorderLayout.CENTER);
      //mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame (optional)
      add(mainPanel);

        // Use the frame's content pane directly for components if not using mainPanel
        add(scrollPane, BorderLayout.CENTER); // Add scrollpane directly to frame

        // Create a button with styled look
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window when OK is clicked
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(getContentPane().getBackground()); // Match background color
        buttonPanel.add(okButton);

        add(buttonPanel, BorderLayout.SOUTH); // Add button panel directly to frame


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
