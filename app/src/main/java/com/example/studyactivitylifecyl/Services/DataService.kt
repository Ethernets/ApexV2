package com.example.studyactivitylifecyl.Services

import com.example.studyactivitylifecyl.Model.HeroesList
import com.example.studyactivitylifecyl.Model.PlayerInfo
import com.example.studyactivitylifecyl.Model.TestHero
import com.google.gson.annotations.SerializedName

object DataService {

    data class TestikHero (@SerializedName("realtime") val  realtime: timeR,
                         @SerializedName("global") val global: Herio)

    data class  Herio (val name: String, val uid: Long, val avatar: String, val platform: String,
                       val  level: Int, val toNextLevelPercent: Int, val internalUpdateCount: Int)

    data class timeR (val lobbyState: String, val isOnline: Int, val isInGame: Int, val canJoin: Int,
                      val partyFull: Int, val selectedLegend: String)

    val lisik = listOf<Herio>()

}