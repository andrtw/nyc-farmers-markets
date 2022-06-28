package com.andrtw.nycfarmersmarkets.core.network.model

import com.andrtw.nycfarmersmarkets.core.network.serializer.StringBooleanSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkFarmersMarket(
    val borough: String? = null,
    @SerialName("marketname") val marketName: String? = null,
    @SerialName("streetaddress") val streetAddress: String? = null,
    @SerialName("community_district") val communityDistrict: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    @SerialName("daysoperation") val daysOperation: String? = null,
    @SerialName("hoursoperations") val hoursOperations: String? = null,
    @SerialName("seasondates") val seasonDates: String? = null,
    @SerialName("accepts_ebt") @Serializable(StringBooleanSerializer::class) val acceptsEbt: Boolean = false,
    @SerialName("open_year_round") @Serializable(StringBooleanSerializer::class) val openYearRound: Boolean = false,
    @SerialName("nyc_dept_of_health_cooking") @Serializable(StringBooleanSerializer::class) val nycDeptOfHealthCooking: Boolean = false,
    @Serializable(StringBooleanSerializer::class) val kids: Boolean = false,
)
