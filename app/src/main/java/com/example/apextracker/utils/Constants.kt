package com.example.apextracker.utils

object Constants {
    // CONSTANTS FOR APEX LEGENDS API
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
    // END

    //CONSTANTS FOR YOUTUBE API
    const val BASE_YOUTUBE_URL: String = "https://www.googleapis.com/"
    const val API_YOUTUBE_ENDPOINT: String = "youtube/v3/playlistItems?part=snippet"
    const val API_YOUTUBE_PLAYLIST_ID: String = "playlistId"
    const val API_YOUTUBE_PLAYLIST_ID_VALUE: String = "UURf_VKcYH_8sha9rb1--erA"
    const val API_YOUTUBE_KEY: String = "key"
    const val API_YOUTUBE_KEY_VALUE: String = "AIzaSyAXlWrr7JDZRv--WV3uo98MsQIygExkFiQ"
    //END
}