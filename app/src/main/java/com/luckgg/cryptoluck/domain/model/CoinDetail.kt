package com.luckgg.cryptoluck.domain.model

import com.luckgg.cryptoluck.data.remote.dto.TeamMember
import java.io.FileDescriptor

data class CoinDetail (
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)