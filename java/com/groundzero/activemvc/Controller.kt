package com.groundzero.activemvc

class Controller(private val view: View, private val model: Model) {

    init {
        view.setIncrementer()
    }

    fun onIncrementClick() {
        model.changeChannelNumber(view.getCurrentIncrement().toString().toInt()+1)
    }
}