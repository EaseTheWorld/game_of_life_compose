package com.easetheworld.gameoflife.model

import androidx.compose.runtime.State

interface Cell {
    val life: State<Boolean>
    val alive: Boolean
        get() = life.value
}