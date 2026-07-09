package days46_Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class HelloGui {
    public static void main(String[] args) {
        // GUI kodunu EDT (Event Dispatch Thread) içinde çalıştırmak iyi pratiktir
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Selam");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 150);
            frame.setLocationRelativeTo(null); // ekran ortası

            JLabel label = new JLabel("Ayşegül Gündoğdu merhaba", SwingConstants.CENTER);
            label.setFont(label.getFont().deriveFont(18f)); // yazıyı biraz büyüt

            frame.add(label);
            frame.setVisible(true);
        });
    }
}