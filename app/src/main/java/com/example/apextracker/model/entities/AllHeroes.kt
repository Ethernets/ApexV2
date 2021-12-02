package com.example.apextracker.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

object AllHeroes{
data class Heroes(
    val global: Global,
    val legends: Legends,
    val realtime: Realtime
)

@Parcelize
data class Global(
    val arena: Arena,
    val avatar: String,
//    val badges: List<Badge>,
    val bans: Bans,
    val internalUpdateCount: Int,
    val level: Int,
    val name: String,
    val platform: String,
    val rank: Rank,
    val toNextLevelPercent: Int,
    val uid: Long
):Parcelable

@Parcelize
data class Legends(
    val all: Map<String, All> = emptyMap()
):Parcelable

data class Realtime(
    val canJoin: Int,
    val currentState: String,
    val currentStateAsText: String,
    val currentStateSinceTimestamp: Int,
    val isInGame: Int,
    val isOnline: Int,
    val lobbyState: String,
    val partyFull: Int,
    val selectedLegend: String
)

@Parcelize
data class Arena(
    val ladderPosPlatform: Int,
    val rankDiv: Int,
    val rankImg: String,
    val rankName: String,
    val rankScore: Int,
    val rankedSeason: String
):Parcelable

@Parcelize
data class Badge(
    val name: String,
    val value: Int
):Parcelable

@Parcelize
data class Bans(
    val isActive: Boolean,
    val last_banReason: String,
    val remainingSeconds: Int
):Parcelable

@Parcelize
data class Rank(
    val ladderPosPlatform: Int,
    val rankDiv: Int,
    val rankImg: String,
    val rankName: String,
    val rankScore: Int,
    val rankedSeason: String
):Parcelable

@Parcelize
data class All(
    val data: List<Data>? = emptyList(),
    val ImgAssets: ImgAssets
):Parcelable

@Parcelize
data class ImgAssets(
    val banner: String,
    val icon: String
):Parcelable

@Parcelize
data class Data(
    val key: String,
    val name: String,
    val value: Int
):Parcelable

}