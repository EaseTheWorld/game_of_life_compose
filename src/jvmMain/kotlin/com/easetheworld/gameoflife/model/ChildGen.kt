package com.easetheworld.gameoflife.model

import androidx.compose.runtime.derivedStateOf
import kotlin.math.max
import kotlin.math.min

class ChildGen(
    override val h: Int,
    override val w: Int,
    private val parent: Gen,
    private val name: String? = null
    ): Gen {
    private val data = Array(h) { y ->
        Array(w) { x ->
            ChildCell(
                parent.cell(y, x), parent.neighbors(y, x),
                name="$name($y,$x)"
            )
        }
    }

    override fun cell(y: Int, x: Int) = data[y][x]

    class ChildCell(
        private val prevSelf: Cell,
        private val prevNeighbors: Set<Cell>,
        private val name: String? = null
    ): Cell {
        override val life = derivedStateOf {
            val ret = calculate()
            if (name != null)
                println("calculate $name $ret")
            ret
        }

        private fun calculate(): Boolean {
            val aliveNeighbors: Int = prevNeighbors.count {
                it.alive
            }
            return if (prevSelf.alive) {
                aliveNeighbors in 2..3
            } else {
                aliveNeighbors == 3
            }
        }
    }
}

private fun Gen.neighbors(y: Int, x: Int): Set<Cell> {
    return buildSet {
        for (_y in max(y-1, 0)..min(y+1, h-1)) {
            for (_x in max(x-1, 0)..min(x+1, w-1)) {
                if (_y != y || _x != x)
                    add(cell(_y, _x))
            }
        }
    }
}

fun Gen.populate(name: String? = null): Gen {
    return ChildGen(h, w, this, name)
}
