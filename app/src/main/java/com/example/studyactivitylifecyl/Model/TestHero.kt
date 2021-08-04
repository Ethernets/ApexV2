package com.example.studyactivitylifecyl.Model

import android.net.Uri
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.URI
import java.util.*
import kotlin.collections.ArrayList

data class TestHero ( @SerializedName("realtime") val  realtime: timeR,
                      @SerializedName("global") val global: Herio)

data class  Herio (val name: String, val uid: Long, val avatar: String, val platform: String,
val  level: Int, val toNextLevelPercent: Int, val internalUpdateCount: Int)

data class timeR (val lobbyState: String, val isOnline: Int, val isInGame: Int, val canJoin: Int,
val partyFull: Int, val selectedLegend: String)