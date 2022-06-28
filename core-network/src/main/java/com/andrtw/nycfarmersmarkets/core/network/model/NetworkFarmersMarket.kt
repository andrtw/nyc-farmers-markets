package com.andrtw.nycfarmersmarkets.core.network.model

import com.andrtw.nycfarmersmarkets.core.network.serializer.StringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkFarmersMarket(
    val borough: String?,
    @SerialName("marketname") val marketName: String,
    @SerialName("streetaddress") val streetAddress: String?,
    @SerialName("community_district") val communityDistrict: String?,
    val latitude: String?,
    val longitude: String?,
    @SerialName("daysoperation") val daysOperation: String?,
    @SerialName("hoursoperations") val hoursOperations: String?,
    @SerialName("seasondates") val seasonDates: String?,
    @SerialName("accepts_ebt") @Serializable(StringBooleanSerializer::class) val acceptsEbt: Boolean,
    @SerialName("open_year_round") @Serializable(StringBooleanSerializer::class) val openYearRound: Boolean,
    @SerialName("nyc_dept_of_health_cooking") @Serializable(StringBooleanSerializer::class) val nycDeptOfHealthCooking: Boolean,
    @Serializable(StringBooleanSerializer::class) val kids: Boolean,
)
