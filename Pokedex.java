package project3;

import java.util.ArrayList;
import java.util.Random;

public class Pokedex {
    public static int pokeCount = 0;
    private ArrayList<Pokemon> pokeList = new ArrayList<>();
    private Random random = new Random();

    public  void addPokemon(Pokemon pokemon) {
        pokeList.add(pokemon);
        countPoke();
    }

   private static void countPoke() {
        pokeCount++;
    }

    public ArrayList<Pokemon> getPokeList() {
        return pokeList;
    }

    //for Player (who selects a Pokemon)
    public Pokemon selectPokemon(int number) {
        return pokeList.get(number - 1);
    }

    //random selection of Pokemon for Computer
    public Pokemon getRandomPokemon(Pokemon playerPokemon) {
        int playerIndex = pokeList.indexOf(playerPokemon);
        int randomNumber = random.nextInt(pokeList.size());
        if (randomNumber == playerIndex) {
            if (randomNumber == pokeList.size() - 1) {
                randomNumber = 0;
            } else {
                randomNumber += 1;
            }
        }
        return pokeList.get(randomNumber);
    }

    public String getRandomMove(Pokemon computerPokemon) {
        int randomNumber = random.nextInt(computerPokemon.getMovesList().size()); //method chaining
        return computerPokemon.getMovesList().get(randomNumber).getMoveName();
        //       pokemon ->   returns movesList -> return a Move move  ->  return name
    }
}


