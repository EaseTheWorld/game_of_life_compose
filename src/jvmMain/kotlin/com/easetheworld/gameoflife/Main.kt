// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.easetheworld.gameoflife.model.Gen
import com.easetheworld.gameoflife.model.createGenList
import com.easetheworld.gameoflife.view.GenView

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App(gens: List<Gen>) {
    MaterialTheme {
        LazyVerticalGrid(
            cells = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            itemsIndexed(gens) { index, grid ->
                Column {
                    Text("$index gen")
                    GenView(grid)
                }
            }
        }
    }
}

fun main() = application {
    val h = 15
    val w = 15
    val age = 8
    val gens = remember {
        Gen.createGenList(h, w, age) {
            val y = h/2
            val x = w/2
            cell(y, x-1).toggle()
            cell(y, x).toggle()
            cell(y, x+1).toggle()
        }
    }
    Window(
        title = "Game of Life",
        state = rememberWindowState(width = 1200.dp, height = 700.dp),
        onCloseRequest = ::exitApplication,
    ) {
        App(gens)
    }
}
