import tictactoe.model.game.GameData;
import tictactoe.model.login.LoginData;

public interface GameView {
    void render(LoginData loginData, GameData gameData);
}
