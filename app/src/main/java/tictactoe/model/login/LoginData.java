import tictactoe.model.Difficult;
import tictactoe.model.Player;

public class LoginData {
    public Player playerOne;
    public Player playerTwo;
    public Difficult difficult;
    public boolean singlePlayer;

    public LoginData(Player playerOne, Player playerTwo, Difficult difficult, boolean singlePlayer) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.difficult = difficult;
        this.singlePlayer = singlePlayer;
    }
}
