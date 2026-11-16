package com.cutozmie.oaster.core.audio

import com.cutozmie.oaster.core.domain.model.Track
import kotlinx.coroutines.flow.StateFlow

enum class RepeatMode { OFF, ALL, ONE }

interface PlaybackController {
    val isPlaying: StateFlow<Boolean>
    val currentTrack: StateFlow<Track?>
    val queue: StateFlow<List<Track>>
    val progressMs: StateFlow<Long>

    suspend fun play(track: Track)
    suspend fun playQueue(tracks: List<Track>, startIndex: Int = 0)
    fun togglePlayPause()
    fun next()
    fun previous()
    fun seekTo(positionMs: Long)
    fun setShuffle(enabled: Boolean)
    fun setRepeat(mode: RepeatMode)
    fun addToQueue(track: Track)
    fun moveQueueItem(from: Int, to: Int)
    fun removeQueueItem(index: Int)
    fun clearQueue()
}
