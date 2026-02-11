public class Game {
    private Player[] players = new Player[0];

    private Player[] addToArray(Player[] current, Player player) {

        Player[] tmp = new Player[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = player;
        return tmp;
    }

    public void register(Player player) {
        players = addToArray(players, player);
    }

    public Player[] findAll() {
        return players;
    }

    public int round(String playerName1, String playerName2) {
        boolean foundPlayer1 = false;
        boolean foundPlayer2 = false;
        int indexPlayer1 = -1;
        int indexPlayer2 = -1;

        for (int i = 0; i < players.length; i++) {
            if (players[i].getName().equals(playerName1) && !foundPlayer1) {
                foundPlayer1 = true;
                indexPlayer1 = i;
            }
            if (players[i].getName().equals(playerName2) && !foundPlayer2) {
                foundPlayer2 = true;
                indexPlayer2 = i;
            }
        }

        if (foundPlayer1 && foundPlayer2) {

            if (players[indexPlayer1].getStrength() > players[indexPlayer2].getStrength()) {
                return 1;
            } else if (players[indexPlayer1].getStrength() < players[indexPlayer2].getStrength()) {
                return 2;
            } else {
                return 0;
            }
        } else throw new NotRegisteredException("Один из игроков не зарегистрирован");
    }
}
