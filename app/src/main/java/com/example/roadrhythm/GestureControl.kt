package com.example.roadrhythm

import android.content.Context
import android.media.AudioManager
import android.os.*
import androidx.annotation.RequiresApi
import androidx.compose.ui.input.pointer.PointerInputChange

class GestureControl(context: Context) {

    // LONG PRESS VIBRATION
    private val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    @RequiresApi(Build.VERSION_CODES.S)
    private val vibratorManager =
        context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager

    fun vibrate() {
        if (Build.VERSION.SDK_INT >= 31) {
            vibratorManager.vibrate(
                CombinedVibration.createParallel(
                    VibrationEffect.createOneShot(
                        50,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            )
        } else if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(50)
        }
    }

    // ADJUST VOLUME
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
    private var lastVolumeAdjustmentTime = 0L
    private val volumeAdjustmentInterval = 200L

    fun adjustVolume(change: PointerInputChange, dragAmount: Float) {
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        val delta = maxVolume / 15

        val currentTime = System.currentTimeMillis()
        if (currentTime - lastVolumeAdjustmentTime < volumeAdjustmentInterval) {
            return
        }

        if (dragAmount > 0) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - delta, 0)
        } else {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + delta, 0)
        }

        lastVolumeAdjustmentTime = currentTime
        change.consume()
    }
}