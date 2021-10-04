import java.util.Arrays;
import java.util.stream.Collectors;
import tictactoe.controller.BaseController;
import tictactoe.model.Difficult;
import tictactoe.model.login.LoginData;
import tictactoe.model.Player;
import tictactoe.model.Sign;
import tictactoe.model.storage.MemoryStorage;
import tictactoe.view.main.LoginView;
public class LoginController extends BaseController<LoginView> {

    private LoginData loginData = new LoginData(
        new Player("? 1", Sign.X),
        new Player("? 2", Sign.O),
        Difficult.EASY,
        false
    );

    @Override
    public void onAttach(LoginView loginView) {
        super.onAttach(loginView);
        isAttached(view -> {
            view.showDifficulty(Arrays.stream(Difficult.values()).collect(Collectors.toList()));
            render();
        });
    }

    private void render(){
        isAttached(view -> view.render(loginData));
    }

    public void onSelectDifficult(Difficult difficult) {
        loginData.difficult = difficult;
    }

    public void onChangePlayerOneName(String playerNameOne) {
        loginData.playerOne.name = playerNameOne;
        render();
    }

    public void onChangePlayerTwoName(String playerNameTwo) {
        loginData.playerTwo.name = playerNameTwo;
        render();
    }

    public void onChangePlayerOneSign(Sign sign) {
        loginData.playerOne.sign = sign;
        loginData.playerTwo.sign = sign.another();
        render();
    }

    public void onChangePlayerTwoSign(Sign sign) {
        loginData.playerTwo.sign = sign;
        loginData.playerOne.sign = sign.another();
        render();
    }

    public void onSelectSinglePlayer(boolean singlePlayer) {
        loginData.singlePlayer = singlePlayer;
        render();
    }

    public void onClickStart() {
        MemoryStorage.getInstance().loginData = loginData;
        isAttached(LoginView::routeToGame);
    }
}
