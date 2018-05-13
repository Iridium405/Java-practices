package iridiumdev;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner eventMenu = new Scanner(System.in);
    static Dice mainDice = new Dice();

    public static void main(String[] args) {
        boolean combatEvent;
        boolean npcEvent;

        Mechanics m = new Mechanics();


        Player player = new Player("Dust", 100, 100, 100,
                5, 5, 1, 5, 5, 1);


        player.equipment.inventoryContent();

        ArrayList<Character> actionQueue = new ArrayList<>();

        while (player.getLevel() <= 3 && player.isAlive()) {
            player.levelChecking();

            Enemy enemy = Enemy.randomEnemy(player.getLevel(), m.dice(3));

            System.out.println("\n                         Enemy: " + enemy.getName() + "\n");
            System.out.println("   Initiative:");

            m.actionOrder(player, enemy, actionQueue);

            System.out.println("\n   Action order: \n" + actionQueue.get(0) + "\n" + actionQueue.get(1) + "\n");
            System.out.println("\n   BATTLE LOG: \n");

            m.combat(actionQueue.get(0), actionQueue.get(1));

            m.addExperience(player, enemy.getExpGivenWhenDead());
            actionQueue.clear();
            player.levelChecking();

            System.out.println(player.getName() + " has " + player.getExperience() + " exp and level "
                    + player.getLevel() + ".\n--------------------------------------------------------------------------\n"+
                                          "--------------------------------------------------------------------------\n");
        }


/*      while (player.isAlive()) {                      // [game body]

            TODO: randomEventMenu();                        // podstawowe menu akcji w grze

                TODO: 1. randomEvent();                         // losowe spotkania - NPC, Enemy lub Item
                        TODO: 1.1 randomNpcEncounter();             // później również baza danych NPC (ludzie i istoty)
                                    1.1.1 conversation();
                                    1.1.2 quest();
                                    1.1.3 trade();
                        TODO: 1.2 randomEnemyEncounter();           // później również baza danych Enemy
                                    1.2.1 combat();
                                    1.2.2 flee();
                        TODO: 1.3 randomItemDrop();                 // później również baza danych Item
                                    1.3.1 checkItem();
                                    1.3.2 take();
                                    1.3.3 leave();

                TODO: 2. inventoryContent();
                        TODO: 2.1 equip();          // jedno-elementowe tablice w ekwipunku - do każdej można przypisać jeden przedmiot danego TYPU
                        TODO: 2.2 unequip();        // usunięcie przedmiotu z AKTYWNEGO ekwipunku, pod warunkiem, że jest wolne miejsce
                        TODO: 2.3 remove();         // zniszczenie przedmiotu

                TODO: 3. quitGame();

          }

            while(combatEvent) {

            }
*/


    }

    public static void randomEventMenu(){
        System.out.println("\n1. Continue your journey." +
                           "\n2. Check your inventory." +
                           "\n3. Quit.");
        int x = eventMenu.nextInt();

    }
}

/*
TODO: Generator losowych wydarzeń -> Spotkanie przeciwnika, spotkanie NPC, znalezienie przedmiotu.
TODO: Action Points -> gracz może wykonać określoną ilość czynności w trakcie tury.
 */
