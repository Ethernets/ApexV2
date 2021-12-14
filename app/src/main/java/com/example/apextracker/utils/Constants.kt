package com.example.apextracker.utils

object Constants {
    const val APEX_AVATAR_SOURCE_LOCAL = "Local"
    const val APEX_AVATAR_SOURCE_ONLINE = "Online"

    const val BASE_URL: String = "https://api.mozambiquehe.re"
    const val API_ENDPOINT: String =  "bridge/?version=5" //"bridge/?version=5&platform=PC&player=ethernetss&auth=Gxbp4SE2e5kScsUmwevA"
    const val API_PLATFORM: String = "platform"
    const val API_PLAYER: String = "player"
    const val API_KEY: String = "auth"
    const val API_KEY_VALUE: String = "Gxbp4SE2e5kScsUmwevA"
    const val API_PLATFORM_VALUE: String = "PC"
    var API_PLAYER_VALUE: String = ""
    var CHECK_BOX_STATE: Boolean = false

    const val NOTIFICATION_ID = "ApexLegends_notification_id"
    const val NOTIFICATION_NAME = "ApexLegends"
    const val NOTIFICATION_CHANNEL = "ApexLegends_channel_01"
}