# Game of Life with Compose Desktop
![Animation2](https://user-images.githubusercontent.com/1066923/175045538-59cb0644-be70-4d7a-b5fb-1a3890b71225.gif)
Implement Conway's Game-of-Life with [Jetpack Compose Desktop]([url](https://www.jetbrains.com/lp/compose-desktop/))
- Each cell is a `State<Boolean>`
- Cells in root(0) geneneration are `mutableState`
- Cells in child(1 and later) genenerations are `derivedState` of prev gen

Inspired by https://dev.to/zachklipp/scoped-recomposition-jetpack-compose-what-happens-when-state-changes-l78

# The reason I chose Compose Desktop
- I never used Compose so I wanted to try
- To click each cell, desktop is better than mobile.

# Performance note
- Each generation looks Row x Column but actually LazyVerticalGrid to limit the composition scope to each cell.
- When I marked only one cell in Gen0, it dies in Gen1, so I expected derivedState doesn't calculate in Gen2 and later, but it actually does calculate for all Gen. why?
