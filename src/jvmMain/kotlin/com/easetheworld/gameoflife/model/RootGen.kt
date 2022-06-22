package com.easetheworld.gameoflife.model

import androidx.compose.runtime.mutableStateOf

class RootGen(
    override val h: Int,
    override val w: Int,
    private val name: String? = null
): Gen {
    private val data = Array(h) { y ->
        Array(w) { x ->
            RootCell(name="$name($y,$x)")
        }
    }

    override fun cell(y: Int, x: Int) = data[y][x]

    class RootCell(
        private val name: String? = null
    ): Cell {
        override val life = mutableStateOf(false)

        fun toggle() {
            life.value = !life.value
        }
    }
}

fun Gen.Companion.createGenList(h: Int, w: Int, age: Int, seed: RootGen.() -> Unit): List<Gen> {
    val root = RootGen(h, w, "G0").apply {
        seed()
    }
    return buildList {
        add(root)
        for (i in 1 until age) {
            add(last().populate("G$i"))
        }
    }
}
