# Football World Cup Scoreboard

This project is a simple Java library that implements a live Football World Cup Scoreboard.

## Features

The scoreboard supports the following operations:

1. **Start a game**  
   When a game starts, record the home team and away team with an initial score of 0–0.

2. **Finish a game**  
   Remove a match from the scoreboard.

3. **Update score**  
   Given new home and away scores, update the match score.

4. **Get a summary of games**  
   Return the list of games ordered by:
    - Total score (descending)
    - If scores are equal, the most recently added game comes first

## Example Summary Output

```bash
1. Uruguay 6 – Italy 6
2. Spain 10 – Brazil 2
3. Mexico 0 – Canada 5
4. Argentina 3 – Australia 1
5. Germany 2 – France 2
```

## Technical Details

- Implemented as a standalone Java library.
- Uses in-memory data storage via standard collections.
- Written following Test-Driven Development (TDD) principles.
- Clean object-oriented design adhering to SOLID principles.
- Includes unit tests using JUnit 5.

### What the tests cover

The included JUnit test suite validates the following functionality:

- Starting a new game initializes the score to 0–0 and adds it to the scoreboard
- Finishing a game removes it from the scoreboard
- Updating the score of a specific game reflects the correct values
- Summary of games is correctly sorted by total score and recency
- Edge cases such as updating or finishing non-existent games are handled

## How to Run Tests

You can run the tests using your preferred IDE or via terminal:

```bash
mvn test
```

## Assumptions

- A game is uniquely identified by its home and away team combination.
- Only one active game can exist between the same pair of teams at a time.
- Scores cannot be negative.
- Summary order is based on total score descending, then most recently added.

## Requirements

- Java 17 or later
- JUnit 5

## Project Structure

- `FootballScoreboard` – core class to manage games and scores.
- `Game` – represents an individual match between two teams.
- `FootballScoreboardTest` – test suite validating all functionality.

## License

This project is provided for assessment purposes and does not include a specific license.
