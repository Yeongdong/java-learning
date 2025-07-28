package chat.server;

import java.io.IOException;

public interface CommandManager {
    public void execute(String totalMessage, Session session) throws IOException;
}
