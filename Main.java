package project3;

public class Main {
    public static void main(String[] args) {

        PokeBattle pokeBattle = new PokeBattle();

        pokeBattle.addPokemonToGame();
        Pokemon playerPokemon = pokeBattle.selectPlayerPokemon();
        Pokemon computerPokemon = pokeBattle.selectComputerPokemon(playerPokemon);
        pokeBattle.battlePokemon(playerPokemon, computerPokemon);
    }
}
