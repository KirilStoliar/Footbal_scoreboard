⚽️ Football World Cup Scoreboard

📄 Description

A simple, lightweight Java library to manage live Football World Cup matches and scores.

✨ Features

Start a new game (initial score 0–0)

Finish an existing game

Update the score of a match

Get a summary of all games, ordered by:

Highest total score (descending)

Most recent game first (in case of a tie)

📋 Example Summary Output

1. Uruguay 6 – Italy 6
2. Spain 10 – Brazil 2
3. Mexico 0 – Canada 5
4. Argentina 3 – Australia 1
5. Germany 2 – France 2

👨‍💻 Assumptions

A match is uniquely identified by the home and away team names

Team names must not be empty, null, or identical

Scores cannot be negative

Matches are ordered by score, then by start time (recorded in nanoseconds)

🖥️ Tech Stack

Java 17 or newer

JUnit 5 for unit/integration testing

Maven for build and dependency management

📅 Setup & Usage

1. Clone the repository

git clone https://github.com/your-username/worldcup-scoreboard.git
cd worldcup-scoreboard

2. Build and run tests

mvn clean test

3. Use the library

Import and use the Scoreboard class in your Java application:

Scoreboard scoreboard = new Scoreboard();
scoreboard.startGame("Spain", "Brazil");
scoreboard.updateScore("Spain", "Brazil", 2, 1);

📁 Project Structure

src/
  main/
    java/com/worldcup/scoreboard/
      Scoreboard.java
  test/
    java/com/worldcup/scoreboard/
      ScoreboardTest.java
pom.xml

📄 License

MIT License (or adapt to your project requirements)
