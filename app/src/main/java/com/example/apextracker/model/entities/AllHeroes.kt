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
    val badges: List<Badge>,
    val bans: Bans,
    val internalUpdateCount: Int,
    val level: Int,
    val name: String,
    val platform: String,
    val rank: Rank,
    val toNextLevelPercent: Int,
    val uid: Long
):Parcelable

data class Legends(
    val all: Map<String, All> = emptyMap(),
    val selected: Selected
)

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


data class All(
    val data: List<Data>? = emptyList(),
    val ImgAssets: ImgAssets
)

data class AdapterListHero(
    val name: String,
    val data: All
)

data class Selected(
    val ImgAssets: ImgAssetsXXXXXXXXXXXXXXXXXXX,
    val LegendName: String,
    val `data`: List<DataXXXXXXXXXXXX>,
    val gameInfo: GameInfoX
)


data class ImgAssets(
    val banner: String,
    val icon: String
)

data class Data(
    val key: String,
    val name: String,
    val value: Int
)


data class ImgAssetsXXXXXXXXXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXXXXXXXXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class GameInfoX(
    val badges: List<BadgeXX>,
    val frame: String,
    val frameRarity: String,
    val intro: String,
    val introRarity: String,
    val pose: String,
    val poseRarity: String,
    val skin: String,
    val skinRarity: String
)

data class BadgeXX(
    val category: String,
    val name: String,
    val value: Int
)

}