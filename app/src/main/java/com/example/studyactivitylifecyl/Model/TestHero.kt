package com.example.studyactivitylifecyl.Model

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class TestHero ( @SerializedName("realtime") val  realtime: timeR)

data class  Herio (val name: String, val uid: Int, val avatar: String, val platform: String,
val  level: Int, val toNextLevelPercent: Int, val internalUpdateCount: Int)

data class timeR (val lobbyState: String, val isOnline: Int, val isInGame: Int, val canJoin: Int,
val partyFull: Int, val selectedLegend: String)