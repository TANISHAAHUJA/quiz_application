
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton rules, back;
    JTextField tfName;

    Login() {
        setBounds(50, 0, 1440, 850);  // Set the window size to match the quiz window
        getContentPane().setBackground(new Color(255, 182, 193)); // Pink background to match the quiz
        setLayout(null);

        // Adding image on the left side
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image scaledImage = i1.getImage().getScaledInstance(700, 850, Image.SCALE_SMOOTH); // Resize image
        JLabel image = new JLabel(new ImageIcon(scaledImage));
        image.setBounds(0, 0, 600, 850);  // Adjust image to match window height
        add(image);

        // Set heading text (same as the quiz style)
        JLabel heading = new JLabel("Skin Deep Secrets🦩💕");
        heading.setBounds(700, 60, 500, 60);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 50));
        heading.setForeground(new Color(254, 1, 154));
        add(heading);

        // Name label and text field
        JLabel name = new JLabel("Enter your ⋆˚࿔ NAME 𝜗𝜚˚⋆");
        name.setBounds(700, 200, 400, 40);
        name.setFont(new Font("Times New Roman", Font.BOLD, 30));
        name.setForeground(new Color(254, 1, 154));
        add(name);

        tfName = new JTextField();
        tfName.setBounds(700, 250, 500, 40);
        tfName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(tfName);

        // Rules button
        rules = new JButton("Rules❀");
        rules.setBounds(700, 350, 200, 40);
        rules.setBackground(new Color(255, 105, 180));  // Same pink as in quiz
        rules.setForeground(Color.WHITE);
        rules.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        rules.setOpaque(true);
        rules.setBorderPainted(false);
        rules.addActionListener(this);
        add(rules);

        // Back button
        back = new JButton("Back");
        back.setBounds(1000, 350, 200, 40);
        back.setBackground(new Color(255, 105, 180));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.addActionListener(this);
        add(back);

        // Set frame visibility
        setVisible(true);
    }

    // Handle button actions
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfName.getText();
            setVisible(false);
            new Rules(name);  // Pass the name to Rules class

        } else if (ae.getSource() == back) {
            setVisible(false);  // Close the login window
        }
    }

    public static void main(String[] args) {
        new Login();  // Launch the Login page
    }
}
