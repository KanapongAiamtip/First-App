import android.util.Log;
import tictactoe.controller.BaseController;
import tictactoe.model.game.GameData;
import tictactoe.model.game.GameInteractor;
import tictactoe.model.game.GameState;
import tictactoe.model.game.Step;
import tictactoe.model.login.LoginData;
import tictactoe.model.storage.MemoryStorage;
import tictactoe.view.game.GameView;
public class GameController extends BaseController<GameView> {

    private LoginData loginData = MemoryStorage.getInstance().loginData;
    private GameData gameData = new GameData(loginData.playerOne);
    private GameInteractor gameInteractor = new GameInteractor();

    @Override
    public void onAttach(GameView gameView) {
        super.onAttach(gameView);
        gameView.render(loginData, gameData);
    }

    public void onPressStep(Step step) {
        Log.d("tag", "onPressStep: player: " + gameData.stepOwner + ";" + step.x + ":" + step.y);
        int[][] newTable = gameInteractor.makeStep(gameData.table, gameData.stepOwner, step);

        if (gameInteractor.isGameFinished(gameData.table)) {
            gameData.gameState = gameInteractor.checkGameResult(gameData.table, gameData.stepOwner);
        } else {
            if (gameInteractor.isNeedNextPlayer(gameData.table, step)) {
                gameData.stepOwner = gameInteractor.nextPlayer(loginData, gameData.stepOwner);
            }
        }
        gameData.table = newTable;
        render();
    }

    public void onGameReset() {
        loginData.playerOne.countWin = 0;
        loginData.playerTwo.countWin = 0;
        onNewGame();
    }

    public void onNewGame() {
        gameData.table = gameInteractor.newTable();
        gameData.gameState = GameState.IN_PROGRESS;
        gameData.stepOwner = gameData.stepOwner.sign == loginData.playerOne.sign
            ? loginData.playerTwo
            : loginData.playerOne;
        render();
    }

    private void render() {
        isAttached(v -> v.render(loginData, gameData));
    }
}
