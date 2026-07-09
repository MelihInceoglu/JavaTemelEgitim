import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, String[]> users = new HashMap<>();
    private static final String FILE_NAME = "users.txt";

    public static void main(String[] args) {
        loadUsers();
        showLoginScreen();
    }

    private static void showLoginScreen() {
        JFrame frame = new JFrame("Giriş Ekranı");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(240, 245, 255));

        JLabel title = new JLabel("Giriş Yap", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(100, 20, 200, 40);
        frame.add(title);

        JLabel userLabel = new JLabel("Kullanıcı Adı:");
        userLabel.setBounds(60, 80, 100, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(160, 80, 180, 25);
        frame.add(userText);

        JLabel passLabel = new JLabel("Şifre:");
        passLabel.setBounds(60, 120, 100, 25);
        frame.add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(160, 120, 180, 25);
        frame.add(passText);

        JButton loginBtn = new JButton("Giriş");
        loginBtn.setBounds(80, 180, 100, 30);
        loginBtn.setBackground(new Color(100, 149, 237));
        loginBtn.setForeground(Color.WHITE);
        frame.add(loginBtn);

        JButton signUpBtn = new JButton("Kayıt Ol");
        signUpBtn.setBounds(220, 180, 100, 30);
        signUpBtn.setBackground(new Color(60, 179, 113));
        signUpBtn.setForeground(Color.WHITE);
        frame.add(signUpBtn);

        loginBtn.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passText.getPassword());

            if (users.containsKey(username) && users.get(username)[1].equals(password)) {
                JOptionPane.showMessageDialog(frame, "Giriş başarılı! Hoşgeldin, " + username + "!");
                frame.dispose();
                showHomeScreen(username);
            } else {
                JOptionPane.showMessageDialog(frame, "Kullanıcı adı veya şifre hatalı!");
            }
        });

        signUpBtn.addActionListener(e -> {
            frame.dispose();
            showSignUpScreen();
        });

        frame.setVisible(true);
    }

    private static void showSignUpScreen() {
        JFrame frame = new JFrame("Kayıt Ol");
        frame.setSize(450, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245, 250, 240));

        JLabel welcome = new JLabel("Kayıt Ekranına Hoşgeldiniz!", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        welcome.setBounds(50, 20, 350, 40);
        frame.add(welcome);

        JLabel userLabel = new JLabel("Kullanıcı Adı:");
        userLabel.setBounds(60, 90, 120, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(180, 90, 180, 25);
        frame.add(userText);

        JLabel mailLabel = new JLabel("Mail:");
        mailLabel.setBounds(60, 130, 120, 25);
        frame.add(mailLabel);

        JTextField mailText = new JTextField();
        mailText.setBounds(180, 130, 180, 25);
        frame.add(mailText);

        JLabel passLabel = new JLabel("Şifre:");
        passLabel.setBounds(60, 170, 120, 25);
        frame.add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(180, 170, 180, 25);
        frame.add(passText);

        JButton registerBtn = new JButton("Kayıt Oluştur");
        registerBtn.setBounds(150, 240, 150, 35);
        registerBtn.setBackground(new Color(60, 179, 113));
        registerBtn.setForeground(Color.WHITE);
        frame.add(registerBtn);

        JButton backBtn = new JButton("Geri Dön");
        backBtn.setBounds(170, 290, 100, 30);
        backBtn.setBackground(new Color(220, 53, 69));
        backBtn.setForeground(Color.WHITE);
        frame.add(backBtn);

        registerBtn.addActionListener(e -> {
            String username = userText.getText().trim();
            String mail = mailText.getText().trim();
            String password = new String(passText.getPassword()).trim();

            if (username.isEmpty() || mail.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Lütfen tüm alanları doldur!");
                return;
            }

            if (users.containsKey(username)) {
                JOptionPane.showMessageDialog(frame, "Bu kullanıcı adı zaten kayıtlı!");
                return;
            }

            users.put(username, new String[]{mail, password});
            saveUsers();
            JOptionPane.showMessageDialog(frame, "Kayıt oluşturuldu!");
            frame.dispose();
            showLoginScreen();
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            showLoginScreen();
        });

        frame.setVisible(true);
    }

    private static void showHomeScreen(String username) {
        JFrame frame = new JFrame("Ana Sayfa");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Hoşgeldin, " + username + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(welcomeLabel);

        frame.setVisible(true);
    }

    private static void loadUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Format: username : mail : password
                String[] parts = line.split(" : ");
                if (parts.length == 3)
                    users.put(parts[0], new String[]{parts[1], parts[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveUsers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String[]> entry : users.entrySet()) {
                pw.println(entry.getKey() + " : " + entry.getValue()[0] + " : " + entry.getValue()[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





