# game_of_life_compose
Implement Conway's Game-of-Life with [Jetpack Compose Desktop]([url](https://www.jetbrains.com/lp/compose-desktop/))
- Each cell is a `State<Boolean>`
- Cells in root(0) gen( are `mutableState`
- Cells in child(1 and later) gen are `derivedState` of prev gen

Inspired by https://dev.to/zachklipp/scoped-recomposition-jetpack-compose-what-happens-when-state-changes-l78

![GameOfLife_Screenshot](https://user-images.githubusercontent.com/1066923/174559548-d061d290-27dd-4700-a5db-22efa5a65819.gif)
