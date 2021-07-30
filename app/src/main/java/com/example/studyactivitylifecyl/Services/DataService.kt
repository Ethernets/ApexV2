package com.example.studyactivitylifecyl.Services

import com.example.studyactivitylifecyl.Model.HeroesList
import com.example.studyactivitylifecyl.Model.PlayerInfo

object DataService {
    val heroesList = listOf(
        HeroesList("Wraith", 1200, "png_main"),
        HeroesList("Octane", 500, "png_main"),
        HeroesList("Lifeline", 760, "png_img")
    )
    val playerList = listOf(
        PlayerInfo("Ethernetss","pc"),
        PlayerInfo("Ethernetts", "pc")
    )
}