import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Player player1 = new Player(1, "Александр", 200);
    Player player2 = new Player(2, "Иван", 190);
    Player player3 = new Player(3, "Алексей", 210);
    Player player4 = new Player(4, "Пётр", 180);
    Player player5 = new Player(5, "Дмитрий", 190);
    Player player6 = new Player(6, "Иван", 185);
    Player player7 = new Player(7, "Алексей", 195);


    @Test
    void shouldFindFirstPlayerStrongest() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        int expected = 1;
        int actual = game.round("Иван", "Пётр");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldFindSecondPlayerStrongest() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);

        int expected = 2;
        int actual = game.round("Александр", "Алексей");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldFindEqualInStrengthPlayers() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Иван", "Дмитрий");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void oneOfPlayersUnRegister() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Иван", "Дмитрий");
        });

    }

    @Test
    void noPlayersIsRegister() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player6);
        game.register(player7);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Пётр", "Дмитрий");
        });

    }

}