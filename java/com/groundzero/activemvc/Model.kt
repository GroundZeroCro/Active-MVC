package com.groundzero.activemvc

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.launch

class Model {

    var channelNumber = BroadcastChannel<Int>(10)

    fun changeChannelNumber(number: Int) {
        CoroutineScope(IO).launch {
            channelNumber.send(number)
        }
    }
}