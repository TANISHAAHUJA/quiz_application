import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    String[][] questions = new String[5][5];
    String[][] userAnswers = new String[5][1];
    ButtonGroup optionsGroup;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton next, submit;
    JLabel qnoLabel, questionLabel;
    int currentQuestion = 0;

    Quiz() {
        setBounds(50, 0, 1600, 850);
        getContentPane().setBackground(new Color(255, 182, 193)); // Pink background
        setLayout(null);

        // Adding image banner aligned to the left
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/skincare.jpg"));

        // Set the broader width and height for the image
        int newWidth = 600; // Adjust to make the image broader
        int newHeight = 600; // You can adjust the height as needed

        // Scale the image to the new dimensions
        Image scaledImage = i1.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(scaledImage));

        // Set the new bounds to align the image to the left
        image.setBounds(0, 100, newWidth, newHeight);  // Adjust the position if needed
        add(image);

        // Questions and answer options
        questions[0][0] = "How does your skin feel after cleansing?";
        questions[0][1] = "Tight or dry";
        questions[0][2] = "Normal";
        questions[0][3] = "Oily or greasy";
        questions[0][4] = "Sensitive or irritated";

        questions[1][0] = "How often do you experience breakouts?";
        questions[1][1] = "Rarely";
        questions[1][2] = "Occasionally";
        questions[1][3] = "Frequently";
        questions[1][4] = "Often with redness";

        questions[2][0] = "How does your skin feel throughout the day?";
        questions[2][1] = "Dry and flaky";
        questions[2][2] = "Comfortable";
        questions[2][3] = "Shiny in the T-zone";
        questions[2][4] = "Itchy or inflamed";

        questions[3][0] = "What happens when you use new skincare products?";
        questions[3][1] = "Feels irritated";
        questions[3][2] = "No noticeable change";
        questions[3][3] = "Skin becomes greasy";
        questions[3][4] = "Skin reacts with redness";

        questions[4][0] = "How does your skin look under natural light?";
        questions[4][1] = "Dull and dry";
        questions[4][2] = "Even and balanced";
        questions[4][3] = "Shiny and oily";
        questions[4][4] = "Red and blotchy";

        // Answer group and radio buttons to the right of the image
        qnoLabel = new JLabel();
        qnoLabel.setBounds(650, 150, 50, 50);
        qnoLabel.setFont(new Font("Times New Roman", Font.BOLD, 28)); // Increased font size
        add(qnoLabel);

        questionLabel = new JLabel();
        questionLabel.setBounds(700, 150, 800, 50);
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 28)); // Increased font size
        add(questionLabel);

        opt1 = new JRadioButton();
        opt1.setBounds(700, 250, 800, 40);
        opt1.setFont(new Font("Times New Roman", Font.PLAIN, 22)); // Increased font size
        opt1.setBackground(new Color(255, 182, 193)); // Pink background
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(700, 300, 800, 40);
        opt2.setFont(new Font("Times New Roman", Font.PLAIN, 22)); // Increased font size
        opt2.setBackground(new Color(255, 182, 193));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(700, 350, 800, 40);
        opt3.setFont(new Font("Times New Roman", Font.PLAIN, 22)); // Increased font size
        opt3.setBackground(new Color(255, 182, 193));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(700, 400, 800, 40);
        opt4.setFont(new Font("Times New Roman", Font.PLAIN, 22)); // Increased font size
        opt4.setBackground(new Color(255, 182, 193));
        add(opt4);

        optionsGroup = new ButtonGroup();
        optionsGroup.add(opt1);
        optionsGroup.add(opt2);
        optionsGroup.add(opt3);
        optionsGroup.add(opt4);

        // Next button
        next = new JButton("Next");
        next.setBounds(1000, 550, 200, 40);
        next.setBackground(new Color(255, 105, 180)); // Hot pink button
        next.setForeground(Color.WHITE);
        next.setOpaque(true); // Ensure background color is visible
        next.setBorderPainted(false); // Remove border for better look
        next.addActionListener(this);
        add(next);

        // Submit button
        submit = new JButton("Submit");
        submit.setBounds(1000, 550, 200, 40);
        submit.setBackground(new Color(255, 105, 180)); // Hot pink button
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true); // Ensure background color is visible
        submit.setBorderPainted(false); // Remove border for better look
        submit.addActionListener(this);
        submit.setVisible(false);
        add(submit);

        loadQuestion(currentQuestion);

        setVisible(true);
    }

    public void loadQuestion(int questionIndex) {
        qnoLabel.setText((questionIndex + 1) + ".");
        questionLabel.setText(questions[questionIndex][0]);
        opt1.setText(questions[questionIndex][1]);
        opt2.setText(questions[questionIndex][2]);
        opt3.setText(questions[questionIndex][3]);
        opt4.setText(questions[questionIndex][4]);

        // Clear previous selections
        optionsGroup.clearSelection();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            // Prevent moving to next if no option is selected
            if (!opt1.isSelected() && !opt2.isSelected() && !opt3.isSelected() && !opt4.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select an answer before proceeding!", 
                                              "No Selection", JOptionPane.WARNING_MESSAGE);
            } else {
                // Capture the answer
                if (opt1.isSelected()) userAnswers[currentQuestion][0] = "1";
                else if (opt2.isSelected()) userAnswers[currentQuestion][0] = "2";
                else if (opt3.isSelected()) userAnswers[currentQuestion][0] = "3";
                else if (opt4.isSelected()) userAnswers[currentQuestion][0] = "4";
                else userAnswers[currentQuestion][0] = ""; // No answer selected

                currentQuestion++;

                if (currentQuestion == 4) {
                    next.setVisible(false);
                    submit.setVisible(true);
                }
                if (currentQuestion < 5) {
                    loadQuestion(currentQuestion);
                }
            }
        } else if (ae.getSource() == submit) {
            // Prevent submission if no option is selected
            if (!opt1.isSelected() && !opt2.isSelected() && !opt3.isSelected() && !opt4.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select an answer before submitting!", 
                                              "No Selection", JOptionPane.WARNING_MESSAGE);
            } else {
                // Capture the final answer before submitting
                if (opt1.isSelected()) userAnswers[currentQuestion][0] = "1";
                else if (opt2.isSelected()) userAnswers[currentQuestion][0] = "2";
                else if (opt3.isSelected()) userAnswers[currentQuestion][0] = "3";
                else if (opt4.isSelected()) userAnswers[currentQuestion][0] = "4";
                else userAnswers[currentQuestion][0] = ""; // No answer selected

                calculateSkinType();
            }
        }
    }

    public void calculateSkinType() {
        int dry = 0, normal = 0, oily = 0, sensitive = 0;

        for (int i = 0; i < 5; i++) {
            if (userAnswers[i][0].equals("1")) dry++;
            else if (userAnswers[i][0].equals("2")) normal++;
            else if (userAnswers[i][0].equals("3")) oily++;
            else if (userAnswers[i][0].equals("4")) sensitive++;
        }

        String skinType;
        if (dry >= 3) skinType = "Dry Skin";

        else if (normal >= 3) skinType = "Normal Skin";
        else if (oily >= 3) skinType = "Oily Skin";
        else skinType = "Sensitive Skin";
        showResultDialog(skinType);
    }

        // Display result in a girly dialog box, no icon (null)
        private void showResultDialog(String skinType) {
            JDialog dialog = new JDialog(this, "Skincare Quiz Result", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(400, 200);
            dialog.setLocationRelativeTo(this);
    
            JLabel resultLabel = new JLabel("<html><h2 style='color: #FF69B4; font-family: Arial;'>Your Skin Type is: " + skinType + "!</h2>"
                    + "<p style='color: #FFB6C1; font-size: 14px;'>Thanks for taking the skincare quiz! "
                    + "Check out skincare tips for " + skinType + " for glowing skin.</p></html>", SwingConstants.CENTER);
            resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    
            JButton closeButton = new JButton("Close");
            closeButton.setBackground(new Color(255, 105, 180));
            closeButton.setForeground(Color.WHITE);
            closeButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            closeButton.setFocusPainted(false); // Remove focus border
            closeButton.setOpaque(true); // Ensure background color is visible
            closeButton.setBorderPainted(false); // Remove border for better look
            closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                    System.exit(0);
                }
            });
    
            dialog.add(resultLabel, BorderLayout.CENTER);
            dialog.add(closeButton, BorderLayout.SOUTH);
            dialog.setVisible(true);
        }
    public static void main(String[] args) {
        new Quiz();
    }
}