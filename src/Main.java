import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
        while(gameRunning){

            String[][] spielFeld = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

            boolean finished = false;
            String player = "X";

            do {
                if (player == "X") {
                    player = "O";
                }
                else {
                    player = "X";
                }
                drawArray(spielFeld);
                playerInput(spielFeld, player);

            } while (!gameDone(spielFeld, player));

            drawArray(spielFeld);

            System.out.println("Replay Game? Y/N");
            String repeatGame = scanner.next();
            if(!repeatGame.equalsIgnoreCase("Y")){
                gameRunning = false;
            }

        }

    }

    private static boolean gameDone(String[][] spielFeld, String player) {

        for (int i = 0; i < 3; i++) {
            if (spielFeld[i][0].equals(player) && spielFeld[i][1].equals(player) && spielFeld[i][2].equals(player)) {
                System.out.println("Player " + player + " won!");
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielFeld[0][i].equals(player) && spielFeld[1][i].equals(player) && spielFeld[2][i].equals(player)) {
                System.out.println("Player " + player + " won!");
                return true;
            }
        }
        if (spielFeld[0][0].equals(player) && spielFeld[1][1].equals(player) && spielFeld[2][2].equals(player)) {
            System.out.println("Player " + player + " won!");
            return true;
        }
        if (spielFeld[2][0].equals(player) && spielFeld[1][1].equals(player) && spielFeld[0][2].equals(player)) {
            System.out.println("Player " + player + " won!");
            return true;
        }

        return false;

    }
    private static String[][] playerInput(String[][] spielFeld, String player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player " + player + ":");
        System.out.print("X:");
        int p1_input_x = playerInput("X");
        System.out.print("Y:");
        int p1_input_y = playerInput("Y");
        spielFeld[p1_input_x][p1_input_y] = player;
        return spielFeld;
    }
    private static void drawArray(String[][] array) {
        System.out.println("   0  1  2");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("[" + array[i][j] + "]");
            }
            System.out.println();
        }
    }
    private static int playerInput(String lineOrColumn){
    Scanner scanner = new Scanner(System.in); //Initialize Scanner
    while(true){ //The While statement runs indefinetly and breaks only if the player puts in the correct values
        int entry = scanner.nextInt();//Scans player input
        if(0<=entry && entry<=2){//Checks the input for the correct value
            return entry;
        }else{
            System.out.println("Only values between 0 and 2 are permitted, please write the value for "+ lineOrColumn+" again"); //Message with explenation incase of an wrong input
        }
    }

}
}


