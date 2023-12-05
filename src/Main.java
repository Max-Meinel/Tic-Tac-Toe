import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

        return false;

    }
    private static String[][] playerInput(String[][] spielFeld, String player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player " + player + ":");
        System.out.print("X:");
        int p1_input_x = scanner.nextInt();
        System.out.print("Y:");
        int p1_input_y = scanner.nextInt();
        if (spielFeld[p1_input_x][p1_input_y].equals(" ")) {
            spielFeld[p1_input_x][p1_input_y] = player;
            return spielFeld;
        }
        else {
            System.out.println("Wrong input!!!");
            playerInput(spielFeld, player);
        }
        return null;
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
}

