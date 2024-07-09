package com.example.studyactivitylifecyl.Model

import android.net.Uri
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.URI
import java.util.*
import kotlin.collections.ArrayList

data class TestHero (@SerializedName("global") val global: PlayerInf,
                     @SerializedName("legends")val legends: AllLegends)

data class  PlayerInf (val name: String, val uid: Long, val avatar: String, val platform: String,
val  level: Int, val toNextLevelPercent: Int, val internalUpdateCount: Int, val bans: BanInf, val rank: RankInf)

data class BanInf (val isActive: Boolean, val remainingSeconds: Int)

data class RankInf (val rankScore: Int, val rankName: String, val rankDiv: Int, val rankImg: String)


data class AllLegends (@SerializedName("all") val all : Revenant, @SerializedName("all") val all2: Horizon)

data class Revenant (val ImgAssets: String)
data class Horizon (val data : ArrayList<Rang>, val ImgAssets: String)

data class Rang (val t0 : Rang0)
data class Rang0 (val name: String, val value: Int, val key: String)