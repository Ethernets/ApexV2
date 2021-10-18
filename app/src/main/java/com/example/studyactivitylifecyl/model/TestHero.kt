package com.example.studyactivitylifecyl.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class TestHero (@SerializedName("global") val global: PlayerInf,
                     @SerializedName("legends")val legends: AllLegends)

data class  PlayerInf (val name: String, val uid: Long, val avatar: String, val platform: String,
val  level: Int, val toNextLevelPercent: Int, val internalUpdateCount: Int, val bans: BanInf, val rank: RankInf)

data class BanInf (val isActive: Boolean, val remainingSeconds: Int)

data class RankInf (val rankScore: Int, val rankName: String, val rankDiv: Int, val rankImg: String)


data class AllLegends (@SerializedName("all") val all: Map<String, LegendWrapper> = emptyMap())


@Parcelize
data class LegendWrapper(val data: List<PlayerPerformance>? = emptyList(), val ImgAssets: ImgAssets): Parcelable

@Parcelize
data class PlayerPerformance(val name: String, val value: Int, val key: String): Parcelable

@Parcelize
data class TestList(val name: String, val data: LegendWrapper): Parcelable

@Parcelize
data class ImgAssets (val icon: String, val banner: String): Parcelable
