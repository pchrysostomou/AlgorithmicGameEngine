# AlgorithmicGameEngine
**Interactive Game Logic & Computational Decision Systems**

This repository presents a structured implementation of an interactive Android game focused on algorithmic logic, real-time decision processes, and clean software design.

The project demonstrates the ability to design modular software components, implement rule-based game mechanics, and produce maintainable, well-documented code suitable for reproducible execution. Developed with emphasis on clarity, robustness, and extensibility, it highlights fundamental software engineering principles applicable to larger interactive or AI-driven systems.

---

## Key Objectives

- Design clear game logic with well-defined rules
- Implement modular and maintainable Java code for Android
- Ensure reproducible execution without hidden dependencies
- Structure software following good engineering practices
- Provide readable documentation and consistent code style
- Support future extensions (AI players, simulations, evaluation metrics)

---

## Features

- Clean separation between game logic and execution flow
- Deterministic and reproducible behaviour
- Animated sprite system (multi-frame bird animation)
- Dynamic difficulty scaling across 3 levels (score-based)
- Sound effect integration (wing, point, hit)
- Scrolling parallax background per level
- Firebase Authentication integration
- Game Over screen with score display
- Easily extendable architecture

---

## Project Structure

```
AlgorithmicGameEngine/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/mygame/
│   │       │   ├── AppConstants.java       # Global constants & initialisation
│   │       │   ├── BackgroundImage.java    # Scrolling background logic
│   │       │   ├── Bird.java               # Player entity & physics
│   │       │   ├── BitmapBank.java         # Asset loading & management
│   │       │   ├── GameActivity.java       # Game Activity host
│   │       │   ├── GameEngine.java         # Core game loop & collision logic
│   │       │   ├── GameOver.java           # Game Over screen
│   │       │   ├── GameThread.java         # Dedicated render/update thread
│   │       │   ├── GameView.java           # SurfaceView canvas rendering
│   │       │   ├── MainActivity.java       # Entry point & menu
│   │       │   ├── SoundBank.java          # Sound effect management
│   │       │   └── Tube.java               # Obstacle entity
│   │       ├── res/                        # Drawables, layouts, sounds, themes
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## Requirements

- **Android Studio** Hedgehog (2023.1.1) or later
- **Java** 8+
- **Android SDK** — compile SDK 34, minimum SDK 28 (Android 9.0 Pie)
- **Gradle** 8.2

---

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Makis666/AlgorithmicGameEngine.git
   ```

2. **Open in Android Studio:**
   - Launch Android Studio
   - Select **File → Open** and choose the cloned project folder
   - Wait for Gradle sync to complete

3. **Run the app:**
   - Connect an Android device (API 28+) or start an emulator
   - Press **Run ▶** or use `Shift + F10`

Alternatively, install the pre-built APK directly:
```
app/release/app-release.apk
```

---

## Gameplay

The game is a side-scrolling arcade game where the player controls a bird navigating through tube obstacles. Difficulty increases automatically with score:

| Level | Score Range | Tube Speed |
|-------|-------------|------------|
| 1     | 0 – 4       | Normal     |
| 2     | 5 – 7       | Fast       |
| 3     | 8+          | Fastest    |

Each level features a distinct scrolling background. A collision with a tube ends the game and displays the final score.

---

## Design Principles

The implementation follows fundamental software engineering principles:

- **Modularity:** Each class has a clear, single responsibility — rendering, physics, asset management, and game state are fully separated.
- **Readability:** Methods are structured to be easily understood and reviewed.
- **Reproducibility:** The system executes deterministically given the same inputs.
- **Extensibility:** The architecture allows straightforward integration of:
  - AI agents
  - Heuristic decision strategies
  - Performance evaluation metrics
  - Graphical interface enhancements

---

## Possible Extensions

- AI opponent or auto-play agent
- Minimax or reinforcement learning agents
- Leaderboard via Firebase Firestore
- Performance benchmarking
- Automated test suite
- Multiplayer support
- Simulation experiments

---

## Technical Stack

| Component        | Technology                          |
|------------------|-------------------------------------|
| Language         | Java 8                              |
| Platform         | Android (API 28+)                   |
| Build System     | Gradle 8.2 (Kotlin DSL)             |
| Rendering        | Android Canvas / SurfaceView        |
| Authentication   | Firebase Auth                       |
| UI               | XML Layouts + custom SurfaceView    |
| Audio            | Android SoundPool                   |

---

## Author

Developed as part of ongoing software engineering practice and portfolio development.

Focus areas include:

- Algorithmic thinking
- Structured programming
- Reproducible experimentation
- Software design clarity
