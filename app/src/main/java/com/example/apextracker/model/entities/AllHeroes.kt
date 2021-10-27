package com.example.apextracker.model.entities

object AllHeroes{
data class Heroes(
    val global: Global,
    val legends: Legends,
    val realtime: Realtime
)

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
)

data class Legends(
    val all: All,
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


data class Arena(
    val ladderPosPlatform: Int,
    val rankDiv: Int,
    val rankImg: String,
    val rankName: String,
    val rankScore: Int,
    val rankedSeason: String
)

data class Badge(
    val name: String,
    val value: Int
)

data class Bans(
    val isActive: Boolean,
    val last_banReason: String,
    val remainingSeconds: Int
)



data class Rank(
    val ladderPosPlatform: Int,
    val rankDiv: Int,
    val rankImg: String,
    val rankName: String,
    val rankScore: Int,
    val rankedSeason: String
)


data class All(
    val Ash: Ash,
    val Bangalore: Bangalore,
    val Bloodhound: Bloodhound,
    val Caustic: Caustic,
    val Crypto: Crypto,
    val Fuse: Fuse,
    val Gibraltar: Gibraltar,
    val Horizon: Horizon,
    val Lifeline: Lifeline,
    val Loba: Loba,
    val Mirage: Mirage,
    val Octane: Octane,
    val Pathfinder: Pathfinder,
    val Rampart: Rampart,
    val Revenant: Revenant,
    val Seer: Seer,
    val Valkyrie: Valkyrie,
    val Wattson: Wattson,
    val Wraith: Wraith
)

data class Selected(
    val ImgAssets: ImgAssetsXXXXXXXXXXXXXXXXXXX,
    val LegendName: String,
    val `data`: List<DataXXXXXXXXXXXX>,
    val gameInfo: GameInfoX
)

data class Ash(
    val ImgAssets: ImgAssets
)

data class Bangalore(
    val ImgAssets: ImgAssetsX,
    val `data`: List<Data>
)

data class Bloodhound(
    val ImgAssets: ImgAssetsXX,
    val `data`: List<DataX>
)

data class Caustic(
    val ImgAssets: ImgAssetsXXX
)

data class Crypto(
    val ImgAssets: ImgAssetsXXXX,
    val `data`: List<DataXX>
)

data class Fuse(
    val ImgAssets: ImgAssetsXXXXX,
    val `data`: List<DataXXX>
)

data class Gibraltar(
    val ImgAssets: ImgAssetsXXXXXX
)

data class Horizon(
    val ImgAssets: ImgAssetsXXXXXXX,
    val `data`: List<DataXXXX>
)

data class Lifeline(
    val ImgAssets: ImgAssetsXXXXXXXX,
    val `data`: List<DataXXXXX>
)

data class Loba(
    val ImgAssets: ImgAssetsXXXXXXXXX,
    val `data`: List<DataXXXXXX>
)

data class Mirage(
    val ImgAssets: ImgAssetsXXXXXXXXXX
)

data class Octane(
    val ImgAssets: ImgAssetsXXXXXXXXXXX,
    val `data`: List<DataXXXXXXX>,
    val gameInfo: GameInfo
)

data class Pathfinder(
    val ImgAssets: ImgAssetsXXXXXXXXXXXX
)

data class Rampart(
    val ImgAssets: ImgAssetsXXXXXXXXXXXXX,
    val `data`: List<DataXXXXXXXX>
)

data class Revenant(
    val ImgAssets: ImgAssetsXXXXXXXXXXXXXX
)

data class Seer(
    val ImgAssets: ImgAssetsXXXXXXXXXXXXXXX,
    val `data`: List<DataXXXXXXXXX>
)

data class Valkyrie(
    val ImgAssets: ImgAssetsXXXXXXXXXXXXXXXX,
    val `data`: List<DataXXXXXXXXXX>
)

data class Wattson(
    val ImgAssets: ImgAssetsXXXXXXXXXXXXXXXXX
)

data class Wraith(
    val ImgAssets: ImgAssetsXXXXXXXXXXXXXXXXXX,
    val `data`: List<DataXXXXXXXXXXX>
)

data class ImgAssets(
    val banner: String,
    val icon: String
)

data class ImgAssetsX(
    val banner: String,
    val icon: String
)

data class Data(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXX(
    val banner: String,
    val icon: String
)

data class DataX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXX(
    val banner: String,
    val icon: String
)

data class ImgAssetsXXXX(
    val banner: String,
    val icon: String
)

data class DataXX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXXX(
    val banner: String,
    val icon: String
)

data class ImgAssetsXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class ImgAssetsXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXXXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class GameInfo(
    val badges: List<BadgeX>
)

data class BadgeX(
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class ImgAssetsXXXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXXXXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class ImgAssetsXXXXXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXXXXXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXXXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXXXXXXXX(
    val key: String,
    val name: String,
    val value: Int
)

data class ImgAssetsXXXXXXXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class ImgAssetsXXXXXXXXXXXXXXXXXX(
    val banner: String,
    val icon: String
)

data class DataXXXXXXXXXXX(
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

data class RateLimit(
    val current_req: String,
    val max_per_second: Int
)

data class Kd(
    val name: String,
    val value: String
)

data class Kills(
    val name: String,
    val value: Int
)

data class KillsSeason5(
    val name: String,
    val value: Int
)

data class KillsSeason7(
    val name: String,
    val value: Int
)

data class SpecialEventDamage(
    val name: String,
    val value: Int
)

data class SpecialEventKills(
    val name: String,
    val value: Int
)

data class SpecialEventWins(
    val name: String,
    val value: Int
)

data class WinsSeason5(
    val name: String,
    val value: Int
)

data class WinsSeason7(
    val name: String,
    val value: Int
)
}