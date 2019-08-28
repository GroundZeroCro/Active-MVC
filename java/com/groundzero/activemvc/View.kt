package com.groundzero.activemvc

interface View {
    fun setIncrementer()
    fun getCurrentIncrement(): CharSequence
}