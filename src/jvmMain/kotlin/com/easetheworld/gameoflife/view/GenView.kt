package com.easetheworld.gameoflife.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.easetheworld.gameoflife.model.Cell
import com.easetheworld.gameoflife.model.Gen
import com.easetheworld.gameoflife.model.RootGen
import com.easetheworld.gameoflife.tools.recomposeHighlighter

private const val CELL_SIZE_DP: Int = 16

@Composable
fun GenView(gen: Gen) {
    for (y in 0 until gen.h) {
        Row {
            for (x in 0 until gen.w) {
                Column {
                    CellView(gen.cell(y, x))
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyGenView(gen: Gen) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(gen.w),
        modifier = Modifier.width((CELL_SIZE_DP * gen.w).dp)
    ) {
        for (y in 0 until gen.h) {
            for (x in 0 until gen.w) {
                item {
                    CellView(gen.cell(y, x))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CellView(cell: Cell) {
    Surface(
        onClick = {
            if (cell is RootGen.RootCell) {
                cell.toggle()
            }
        },
        modifier = Modifier.size(CELL_SIZE_DP.dp).recomposeHighlighter(),
        color = if (cell.alive) Color.Black else Color.White,
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        //println("Cell $y,$x")
    }
}

