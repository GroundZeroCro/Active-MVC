package com.groundzero.activemvc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View {

    private val model = Model()
    private val controller = Controller(this, model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        increment_button.setOnClickListener { controller.onIncrementClick() }
    }

    override fun setIncrementer() {
        CoroutineScope(Main).launch {
            model.channelNumber.consumeEach {
                incremented_text.text = it.toString()
            }
        }
    }

    override fun getCurrentIncrement(): CharSequence {
        return incremented_text.text
    }
}
