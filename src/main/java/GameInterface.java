
import java.io.*;
import java.util.Scanner;

public class GameInterface {

    private SingleGem actualGame;
    private Scanner scanner;


    public GameInterface(){
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    public boolean initGem() {
        Player one = new Player("Server");
        Player two = new Player("Receiver");
        actualGame = new SingleGem( one, two);
        return true;
    }

    public boolean displayRules() {
        System.out.println("TENIS GEM SIMULATOR");
        System.out.println("Press right key to define which player is going to win, please.");
        System.out.println("Server = 1");
        System.out.println("Receiver = 2");
        return true;
    }


    public boolean displayWinner() {

        switch ( actualGame.setWinnerOfGem()){
            case 1:
                System.out.println("Server wins");
                return true;
            case 2:
                System.out.println("Receiver wins");
                return true;
            default:
                return false;
        }
    }

    public void startGame() {
        initGem();
        displayRules();

        while ( !actualGame.isOver() ){
            System.out.println("Actual score:");
            System.out.println(actualGame.displayScore());
            System.out.println("Please choose the player that wins the poin: ");
            System.out.print("#");
            actualGame.setBallWinner(scanner.nextInt());
        }
        displayWinner();
        System.out.println("Press Enter to exit");
        try {
            System.in.read();
        }catch (IOException exception){
            System.out.println("Error");
        }
    }

}
