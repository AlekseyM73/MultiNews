package com.alekseymakarov.multinews.model

data class ChannelsResponse(
    val sources: List<Channel>,
    val status: String
)