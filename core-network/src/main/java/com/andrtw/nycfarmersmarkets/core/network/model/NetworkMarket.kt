package com.andrtw.nycfarmersmarkets.core.network.model

import com.andrtw.nycfarmersmarkets.core.network.serializer.StringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkMarket(
    val borough: String?,
    @SerialName("marketname") val marketName: String?,
    @SerialName("streetaddress") val streetAddress: String?,
    @SerialName("community_district") val communityDistrict: String?,
    val latitude: String?,
    val longitude: String?,
    @SerialName("daysoperation") val daysOperation: String?,
    @SerialName("hoursoperations") val hoursOperations: String?,
    @SerialName("seasondates") val seasonDates: String?,
    @Serializable(StringBooleanSerializer::class) val accepts_ebt: Boolean,
    @Serializable(StringBooleanSerializer::class) val open_year_round: Boolean,
    @Serializable(StringBooleanSerializer::class) val nyc_dept_of_health_cooking: Boolean,
    @Serializable(StringBooleanSerializer::class) val kids: Boolean,
)
