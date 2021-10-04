import java.util.List;
import tictactoe.model.login.LoginData;
import tictactoe.model.Difficult;

public interface LoginView {
    void showDifficulty(List<Difficult> values);

    void render(LoginData loginData);

    void routeToGame();
}
