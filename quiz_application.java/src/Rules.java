
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading text
        JLabel heading = new JLabel("Welcome " + name + " to Skin Deep Secrets ˚˖𓍢ִ໋🌷͙֒✧🩷˚.🎀༘⋆");
        heading.setBounds(150, 20, 1200, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 36));
        heading.setForeground(new Color(255, 105, 180));
        add(heading);

        // Rules text
        JLabel rules = new JLabel();
        rules.setBounds(150, 100, 1200, 500);
        rules.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        rules.setForeground(new Color(255, 182, 193));
        rules.setText(
            "<html>" + 
            "1) You are allowed (and encouraged) to play in your pajamas, but bonus points if you add a tiara!🎀" + "<br><br>" +
            "2) If you are unsure about a question, just answer with something pink. It is always a good choice!🌷" + "<br><br>" +
            "3) If you get a question right, you must do a little happy dance. Celebrate every victory!🎀⋆" + "<br><br>" +
            "4) Keep your snacks close by. Quizzing is hard work, and you deserve a treat!🩰" + "<br><br>" +
            "5) If a question stumps you, just remember: unicorns would get it wrong too. And that is okay!🐇" + "<br><br>" +
            "6) Whether you get 100% or just 1%, every quiz completion deserves a celebration. Confetti is optional!🎧" + "<br><br>" +
            "</html>"
        );
        add(rules);

        // Back button
        back = new JButton("Back");
        back.setBounds(500, 600, 150, 40);
        back.setBackground(new Color(254, 1, 154));
        back.setForeground(Color.PINK);
        back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        back.setOpaque(true); // Ensure background is visible
        back.setBorderPainted(false); // Remove border for better look
        back.addActionListener(this);
        add(back);

        // Start button
        start = new JButton("Start❀");
        start.setBounds(800, 600, 150, 40);
        start.setBackground(new Color(254, 1, 154));
        start.setForeground(Color.PINK);
        start.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        start.setOpaque(true);
        start.setBorderPainted(false);
        start.addActionListener(this);
        add(start);

        // Set size and location to match the quiz window
        setSize(1440, 850);
        setLocation(50, 0); // Position the window consistently
        setVisible(true);
    }

    // Handle button actions
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(); // Start the quiz when "Start❀" is clicked
        } else {
            setVisible(false);
            new Login(); // Go back to login when "Back" is clicked
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
