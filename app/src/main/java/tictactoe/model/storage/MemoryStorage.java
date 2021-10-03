import tictactoe.model.login.LoginData;
public class MemoryStorage {

    private static MemoryStorage memoryStorage;

    public static MemoryStorage getInstance(){
        if (memoryStorage == null) {
            memoryStorage = new MemoryStorage();
        }
        return memoryStorage;
    }

    public LoginData loginData;

}
