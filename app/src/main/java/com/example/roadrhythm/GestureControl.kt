package com.example.roadrhythm

import android.content.Context
import android.media.AudioManager
import androidx.compose.ui.input.pointer.PointerInputChange

class GestureControl(context: Context) {
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

    fun adjustVolume(change: PointerInputChange, dragAmount: Float) {
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        val delta = maxVolume / 10 // Change volume by 10% of max volume

        if (dragAmount > 0) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - delta, 0)
            println("DECREASE VOLUME")
        } else {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + delta, 0)
            println("INCREASE VOLUME")
        }

        change.consume()
    }
}