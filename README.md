# game_of_life_compose
Implement Conway's Game-of-Life with Jetpack Compose Desktop
- Each cell is a `State<Boolean>`
- Cells in root gen are `mutableState`
- Cells in child gen are `derivedState` of prev gen

Inspired by https://dev.to/zachklipp/scoped-recomposition-jetpack-compose-what-happens-when-state-changes-l78
