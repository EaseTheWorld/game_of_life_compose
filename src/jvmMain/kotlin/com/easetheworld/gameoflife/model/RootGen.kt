package com.easetheworld.gameoflife.model

import androidx.compose.runtime.mutableStateOf

class RootGen(
    override val h: Int,
    override val w: Int
): Gen {
    private val data = Array(h) {
        Array(w) {
            RootCell()
        }
    }

    override fun cell(y: Int, x: Int) = data[y][x]

    class RootCell: Cell {
        override val life = mutableStateOf(false)

        fun toggle() {
            life.value = !life.value
        }
    }
}

fun Gen.Companion.createGenList(h: Int, w: Int, age: Int, seed: RootGen.() -> Unit): List<Gen> {
    val root = RootGen(h, w).apply {
        seed()
    }
    return buildList {
        add(root)
        for (i in 1 until age) {
            add(last().populate())
        }
    }
}
