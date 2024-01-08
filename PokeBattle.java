package project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class PokeBattle {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private Pokedex pokedex = new Pokedex();

    public void addPokemonToGame() {
        String name;
        int hitPoints;
        int speed;
        String moveName;
        int movePower;

        System.out.println("Add a Pokemon.");
        System.out.println("-".repeat(30));
        while (true) {
            System.out.println("Enter new Pokemon name\nOr press 'q' then 'Enter' to quit.");
            name = scanner.nextLine();
            if (name.toLowerCase().equals("q")) {
                break;
            }
            System.out.printf("Enter %s's HP: ", name);
            hitPoints = Integer.parseInt(scanner.nextLine());
            System.out.printf("Enter %s's Speed: ", name);
            speed = Integer.parseInt(scanner.nextLine());
            Pokemon pokemon = new Pokemon(name, hitPoints, speed);
            while (true) {
                System.out.println("*".repeat(30));
                System.out.printf("\tEnter a %s move, or 'q' to quit.", name);
                System.out.println("\tEnter the move's name: ");
                moveName = scanner.nextLine();
                if (moveName.toLowerCase().equals("q")) {
                    break;
                }
                System.out.printf("\tEnter %s's Power: ", moveName);
                movePower = Integer.parseInt(scanner.nextLine());
                Move move = new Move(moveName, movePower);
                pokemon.addMove(move);
            }
            pokedex.addPokemon(pokemon);
            System.out.println();
        }
        System.out.println();
    }

    public void displayPokeList() {
        ArrayList<Pokemon> pokeList = pokedex.getPokeList();
        for (int i = 0; i < pokeList.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, pokeList.get(i).getPokemonInfo());
            System.out.printf("\t%-20s%s\n", "Move", "Power");
            System.out.printf("\t%s\n", "-".repeat(25));

            for (Move move : pokeList.get(i).getMovesList()) {
                System.out.printf("\t%-20s%d\n", move.getMoveName(), move.getMovePower());
            }
            System.out.println();
        }
    }

    public Pokemon selectPlayerPokemon() {
        displayPokeList();
        //calls Pokedex's selectPokemon() method
        ArrayList<Pokemon> pokeList = pokedex.getPokeList();
        System.out.println("Enter number of your selected Pokemon: ");
        int n = Integer.parseInt(scanner.nextLine());
        return pokedex.selectPokemon(n);
    }

    public Pokemon selectComputerPokemon(Pokemon playerPokemon) {
        return pokedex.getRandomPokemon(playerPokemon);
    }

    private void updateHitPoints(Pokemon pokemon, int power) {
        pokemon.setHitPoints(pokemon.getHitPoints() - power);
    }

    public void battlePokemon(Pokemon playerPokemon, Pokemon computerPokemon) {
        System.out.println("Welcome to Pokemon Battle - Player vs. Computer!\n");
        System.out.println("Select your Pokemon's move.");
        String playerMoveName = scanner.nextLine();
        int playerPower = playerPokemon.getMoveByName(playerMoveName).getMovePower();
        String computerMoveName = pokedex.getRandomMove(computerPokemon);
        int computerPower = computerPokemon.getMoveByName(computerMoveName).getMovePower();

        while (true) {
            if (playerPokemon.getSpeed() == computerPokemon.getSpeed()) {
                int num = random.nextInt(1);
                if (num == 1) {
                    playerPokemon.setSpeed(playerPokemon.getSpeed() + 1);
                } else {
                    computerPokemon.setSpeed(computerPokemon.getSpeed() + 1);
                }
            }

            if (playerPokemon.getSpeed() > computerPokemon.getSpeed()) {
                updateHitPoints(computerPokemon, playerPower);
                if (computerPokemon.getHitPoints() <= 0) {
                    System.out.println("You win!");
                    break;
                }
                updateHitPoints(playerPokemon, computerPower);
                if (playerPokemon.getHitPoints() <= 0) {
                    System.out.println("You lose!");
                    break;
                }
            } else {
                updateHitPoints(playerPokemon, computerPower);
                if (playerPokemon.getHitPoints() <= 0) {
                    System.out.println("You lose!");
                    break;
                }
                updateHitPoints(computerPokemon, playerPower);
                if (computerPokemon.getHitPoints() <= 0) {
                    System.out.println("You win!");
                    break;
                }
            }
        }
    }
}



