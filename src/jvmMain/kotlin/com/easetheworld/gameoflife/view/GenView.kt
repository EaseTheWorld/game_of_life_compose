package com.easetheworld.gameoflife.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.easetheworld.gameoflife.model.Gen
import com.easetheworld.gameoflife.model.RootGen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GenView(gen: Gen) {
    for (y in 0 until gen.h) {
        Row {
            for (x in 0 until gen.w) {
                Column {
                    val cell = gen.cell(y, x)
                    Surface(
                        onClick = {
                            if (cell is RootGen.RootCell) {
                                cell.toggle()
                            }
                        },
                        modifier = Modifier.size(16.dp),
                        color = if (cell.alive) Color.Black else Color.White,
                        border = BorderStroke(1.dp, Color.Gray)
                    ) {
                        //println("Cell $y,$x")
                    }
                }
            }
        }
    }
}
