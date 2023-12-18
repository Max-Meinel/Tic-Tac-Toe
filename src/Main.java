import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private char aPlayerXorO;
    private JButton[] aButtons;

    public void main(String[] args) {
        aPlayerXorO = 'X';
        aButtons = new JButton[9];

        setSize(getScreenDimension()); // set size to full screen
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initializeButtons();

        setExtendedState(MAXIMIZED_BOTH); // maximize window

        setVisible(true);
    }

    private Dimension getScreenDimension() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public void initializeButtons() {
        for (int i = 0; i <= 8; i++) {
            aButtons[i] = new JButton();
            aButtons[i].setText("");
            aButtons[i].setFont(new Font("Arial", Font.BOLD, 70));  // set the font size here
            aButtons[i].setFocusable(false);
            aButtons[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    JButton buttonClicked = (JButton) e.getSource();
                    buttonClicked.setText(String.valueOf(aPlayerXorO));
                    buttonClicked.setEnabled(false);
                    winCheck();
                    switchPlayer();
                }
            });

            add(aButtons[i]);
        }
    }

    public void winCheck() {
        // Check horizontal lines.
        for (int i = 0; i < 9; i += 3)
            if (checkLine(i, i + 1, i + 2))
                endGame(aButtons[i].getText());

        // Check vertical lines.
        for (int i = 0; i < 3; ++i)
            if (checkLine(i, i + 3, i + 6))
                endGame(aButtons[i].getText());

        // Check the diagonals.
        if (checkLine(0, 4, 8) || checkLine(2, 4, 6))
            endGame(aButtons[4].getText());
    }

    public boolean checkLine(int a, int b, int c) {
        return aButtons[a].getText().equals(aButtons[b].getText()) && aButtons[b].getText().equals(aButtons[c].getText()) && !aButtons[a].getText().equals("");
    }

    public void endGame(String winner) {
        JOptionPane.showConfirmDialog(null, String.format("%s wins", winner), "Game Over", JOptionPane.DEFAULT_OPTION);
        System.exit(0);
    }

    public void switchPlayer() {
        aPlayerXorO = (aPlayerXorO == 'X') ? 'O' : 'X';
    }

}
