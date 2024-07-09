package com.example.apextracker.model.entities.youtube

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



    @Parcelize
    data class AllVideo(
        val etag: String,
        val items: List<Item>,
        val kind: String,
        val nextPageToken: String,
        val pageInfo: PageInfo
    ):Parcelable

    @Parcelize
    data class Default(
        val height: Int,
        val url: String,
        val width: Int
    ):Parcelable

    @Parcelize
    data class High(
        val height: Int,
        val url: String,
        val width: Int
    ):Parcelable

    @Parcelize
    data class Item(
        val etag: String,
        val id: String,
        val kind: String,
        val snippet: Snippet
    ):Parcelable

    @Parcelize
    data class Maxres(
        val height: Int,
        val url: String,
        val width: Int
    ):Parcelable

    @Parcelize
    data class Medium(
        val height: Int,
        val url: String,
        val width: Int
    ):Parcelable

    @Parcelize
    data class PageInfo(
        val resultsPerPage: Int,
        val totalResults: Int
    ):Parcelable

    @Parcelize
    data class ResourceId(
        val kind: String,
        val videoId: String
    ):Parcelable

    @Parcelize
    data class Snippet(
        val channelId: String,
        val channelTitle: String,
        val description: String,
        val playlistId: String,
        val position: Int,
        val publishedAt: String,
        val resourceId: ResourceId,
        val thumbnails: Thumbnails,
        val title: String,
        val videoOwnerChannelId: String,
        val videoOwnerChannelTitle: String
    ):Parcelable

    @Parcelize
    data class Standard(
        val height: Int,
        val url: String,
        val width: Int
    ):Parcelable

    @Parcelize
    data class Thumbnails(
        val default: Default,
        val high: High,
        val maxres: Maxres,
        val medium: Medium,
        val standard: Standard
    ):Parcelable
