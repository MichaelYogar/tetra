package game;

import com.michaelyogar.tetra.app.game.Game;
import com.michaelyogar.tetra.app.game.GameRepository;
import com.michaelyogar.tetra.app.game.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    @InjectMocks
    GameService gameService;

    @Mock
    GameRepository gameRepository;

    @Test
    void testCreateOrSaveGame() {
        Game game = new Game();
        try {
            gameService.createGame(game);
        } catch (Exception e) {
            fail("Failed to create game");
        }
        verify(gameRepository, times(1)).save(game);
    }
}
