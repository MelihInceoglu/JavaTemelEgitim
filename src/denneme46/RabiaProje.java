package denneme46;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RabiaProje {

    private static final String USERNAME = "rabia";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        // Login ekranı
        JFrame loginFrame = new JFrame("Hoşgeldin Sultanım Rabia - Lütfen Giriş Yap");
        loginFrame.setSize(400, 250); // biraz daha büyük yaptık
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new GridBagLayout()); // daha şık bir düzen
        loginFrame.getContentPane().setBackground(new Color(255, 228, 225)); // açık pembe arka plan

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Kullanıcı Adı:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField userText = new JTextField(15);

        JLabel passLabel = new JLabel("Şifre:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JPasswordField passText = new JPasswordField(15);

        JButton loginButton = new JButton("Giriş");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(255, 182, 193));
        loginButton.setOpaque(true);

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginFrame.add(userLabel, gbc);
        gbc.gridx = 1;
        loginFrame.add(userText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginFrame.add(passLabel, gbc);
        gbc.gridx = 1;
        loginFrame.add(passText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginFrame.add(loginButton, gbc);

        loginFrame.setLocationRelativeTo(null); // ekran ortası
        loginFrame.setVisible(true);

        // Login butonu işlemi
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String pass = new String(passText.getPassword());

                if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                    loginFrame.dispose(); // login ekranını kapat
                    showImageWindow();   // resim ve sonraki ekranı göster
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Hatalı kullanıcı adı veya şifre!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private static void showImageWindow() {
        JFrame imageFrame = new JFrame("Hayatımın Anlamı"); // Başlığı değişti
        imageFrame.setSize(600, 600);
        imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageFrame.setLayout(new BorderLayout());


        ImageIcon icon = new ImageIcon("C:\\Users\\melih\\IdeaProjects\\JavaTemelEgitimMelih\\WhatsApp Image 2025-09-26 at 16.55.46.jpeg");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(550, 450, Image.SCALE_SMOOTH); // pencereye sığacak şekilde
        icon = new ImageIcon(scaledImg);

        JLabel picLabel = new JLabel(icon);
        picLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton nextButton = new JButton("İleri");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setBackground(new Color(255, 182, 193));
        nextButton.setOpaque(true);

        imageFrame.add(picLabel, BorderLayout.CENTER);
        imageFrame.add(nextButton, BorderLayout.SOUTH);

        imageFrame.setLocationRelativeTo(null);
        imageFrame.setVisible(true);

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(imageFrame, "Seni Çok Seviyorum!!!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}