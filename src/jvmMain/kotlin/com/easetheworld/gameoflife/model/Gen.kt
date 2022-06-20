package com.easetheworld.gameoflife.model

interface Gen {
    val h: Int
    val w: Int
    fun cell(y: Int, x: Int): Cell
    companion object
}
