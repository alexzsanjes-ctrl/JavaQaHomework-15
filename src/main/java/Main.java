public class Main {
    public static void main(String[] args) {

        Player player1 = new Player(1, "Александр", 200);
        Player player2 = new Player(2, "Иван", 190);
        Player player3 = new Player(3, "Алексей", 210);
        Player player4 = new Player(4, "Пётр", 180);
        Player player5 = new Player(5, "Дмитрий", 190);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.round("Иван", "Андрей");
    }
}