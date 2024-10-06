# BattleShip Game

This is a command-line-based implementation of the classic BattleShip game. The game is designed for two players who take turns firing missiles at each other's ships, with the goal of destroying all of the opponent's ships.

## Game Features

- Playable in a grid-based battlefield of size NxN.
- Each player controls half of the battlefield, and the number of ships for both players is equal.
- Players take turns firing missiles at random coordinates on the opponent's field.
- The game ends when one player's entire fleet is destroyed.

## Requirements

1. **Battlefield Setup**:
  - The battlefield is an NxN grid.
  - Players each control NxN/2 grids.
  - Ship size and locations are provided by the players.
  - Ships are square-shaped and cannot overlap, but they can touch boundaries.

2. **Gameplay**:
  - Each player fires one missile at a random coordinate in the opponent’s field.
  - A missile may either hit or miss an opponent's ship.
  - The game ends when all ships of one player are destroyed.

3. **API Functions**:
  - **`initGame(N)`**: Initializes a battlefield of size NxN.
  - **`addShip(id, size, xA, yA, xB, yB)`**: Adds a ship of a given size at specified coordinates for both players.
  - **`startGame()`**: Begins the game with PlayerA firing the first missile.
  - **`viewBattleField()`** (Optional): Displays the battlefield grid and shows ship positions.

## Usage

### Initializing the Game
Start by initializing the game with the size of the battlefield:
```sh
>> initGame(6)
>> addShip("SH1", 2, 1, 5, 4, 4)
>> startGame()
PlayerA's turn: Missile fired at (3, 0): "Miss"
PlayerB's turn: Missile fired at (1, 1): "Miss"
PlayerA's turn: Missile fired at (5, 3): "Hit" B-SH2 destroyed
GameOver. PlayerA wins.
