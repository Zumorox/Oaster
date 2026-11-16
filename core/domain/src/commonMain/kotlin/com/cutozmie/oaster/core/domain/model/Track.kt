package com.cutozmie.oaster.core.domain.model

data class Track(
    val id: String,
    val title: String,
    val artist: String?,
    val album: String?,
    val durationMs: Long,
    val uri: String,
    val artworkUri: String? = null
)
