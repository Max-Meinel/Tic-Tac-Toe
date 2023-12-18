import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWithUI extends JFrame {
    private char aPlayerXorO;//Variable holds the value of the current Player
    private JButton[] aButtons;//Declarates Buttons

    public GameWithUI() {
        setTitle("Tic-Tac-Toe  Player versus Player"); //Title of the Window
        setSize(getScreenDimension()); //Set the size of the window to the size of the screen

        aPlayerXorO = 'X'; //Player "X" begins
        aButtons = new JButton[9];  //creates Buttons

        setLayout(new GridLayout(3, 3)); //Set the Gridlayout for the game table
        setDefaultCloseOperation(EXIT_ON_CLOSE);//End the Application if the window is closed

        initializeButtons();//Initialize the play buttons

        setExtendedState(MAXIMIZED_BOTH); // maximize window

        setVisible(true);
    }
    private Dimension getScreenDimension() { //Function to get the screen size of the current
        return Toolkit.getDefaultToolkit().getScreenSize(); //library operation to get the screen size
    }
    public void initializeButtons() {//Initialize the buttons
        for (int i = 0; i <= 8; i++) {
            aButtons[i] = new JButton();//create new button
            aButtons[i].setText("");//set the text of the button
            aButtons[i].setFont(new Font("Arial", Font.BOLD, 70));  // set the font size for the text
            aButtons[i].setFocusable(false);//The method specifies wheter the button can be selected or react to user inputs
            aButtons[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent event) {//the method actionPerformed() is part of the ActionListener Interfaced, it handels events involving buttons and others
                    JButton buttonClicked = (JButton) event.getSource();
                    buttonClicked.setText(String.valueOf(aPlayerXorO));
                    buttonClicked.setEnabled(false);

                    if(gameDone()){
                        //if the game ends the players can decide to play another round, without restarting the whole Application, a pop up lets the player decide
                        int option = JOptionPane.showConfirmDialog(null, "Player " + aPlayerXorO + " won! Would you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                        if(option == JOptionPane.YES_OPTION){//in case they want to play another round, the game table gets resetted
                            resetButtons();//resets the game table
                        } else {
                            System.exit(0);//ends the application
                        }
                    }else{
                        // Switch Players
                        switchPlayer();
                    }
                }
            });
            add(aButtons[i]);//Adds the button
        }
    }
    public boolean gameDone() {
        // Check horizontal lines.
        for (int i = 0; i < 9; i += 3)
            if (checkLine(i, i + 1, i + 2))
                return true;

        // Check vertical lines.
        for (int i = 0; i < 3; ++i)
            if (checkLine(i, i + 3, i + 6))
                return true;
    }

    public boolean checkLine(int a, int b, int c) {//checks the line wheter all three buttons are occupied by one user
        return aButtons[a].getText().equals(aButtons[b].getText()) && aButtons[b].getText().equals(aButtons[c].getText()) && !aButtons[a].getText().equals("");
    }

    public void switchPlayer() {//Method to switch players
        aPlayerXorO = (aPlayerXorO == 'X') ? 'O' : 'X';//if the current player is "X" it changes to "O" and the other way around
    }
    private void resetButtons(){//method to reset the text of the buttons, as well as reenable them
        for(int i = 0; i < 9; i++) {
            aButtons[i].setText("");
            aButtons[i].setEnabled(true);
        }
        aPlayerXorO = 'X';  // Set 'X' as starting player for the next game
    }
}
