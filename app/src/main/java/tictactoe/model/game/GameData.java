import tictactoe.model.Player;
public class GameData {

    public GameState gameState = GameState.IN_PROGRESS;

    public int[][] table = {
        {-1, -1, -1},
        {-1, -1, -1},
        {-1, -1, -1}
    };

    public Player stepOwner;


    public GameData(Player stepOwner) {
        this.stepOwner = stepOwner;
    }
}
