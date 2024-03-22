package prog2.midgroup01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGuide extends JFrame {

    // Constructor to create the user guide window
    public UserGuide() {
        super("Fraction Calculator User Guide"); // Set the window title
        createComponents(); // Call the method to create GUI components
    }

    // Method to create and arrange the GUI components
    private void createComponents() {
        // Set the preferred size of the window
        setPreferredSize(new Dimension(500, 340));

        // Specify that the window should be closed when the user clicks the "X" button
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the background color for the entire window (frame) to a yellow color
        getContentPane().setBackground(new java.awt.Color(253, 202, 64));

        // Create a main panel (optional, can be removed if components are added directly to the frame)
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // Use BorderLayout for basic layout

        // Create a text area to display the instructions
        JTextArea instructions = new JTextArea(
                "Welcome to the Fraction Calculator!\n\n" +
                        "Here's how to get started:\n\n" +
                        "1. Enter fractions (including whole numbers) in the text fields provided.\n" +
                        "2. Select the operation from the dropdown menu.\n" +
                        "3. Click the 'Compute' button to see the result.\n" +
                        "4. Use the 'Clear' button to reset the input fields.\n\n" +
                        "**Tip:** If no whole number is present, simply enter '0' in the whole number field."
        );
        instructions.setEditable(false); // Make the text area non-editable
        instructions.setLineWrap(true); // Enable line wrapping
        instructions.setWrapStyleWord(true); // Wrap lines on word boundaries
        instructions.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a clear font for better readability

        // Create a scroll pane to hold the text area for better scrolling
        JScrollPane scrollPane = new JScrollPane(instructions);

        // Add the scroll pane to either the main panel or directly to the frame
        mainPanel.add(scrollPane, BorderLayout.CENTER); // Option 1: Add to main panel

        // Add the main panel to the frame
        add(mainPanel);

        // Create an "OK" button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window when the "OK" button is clicked
            }
        });

        // Create a button panel to hold the "OK" button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(getContentPane().getBackground()); // Match background color
        buttonPanel.add(okButton);

        // Add the button panel to the bottom of the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Finalize window layout and display
        pack(); // Adjust window size to fit components
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Show the window
    }
}
