package com.andrtw.nycfarmersmarkets.core.network.serializer

import com.google.common.truth.Truth.assertThat
import kotlinx.serialization.json.Json
import org.junit.Test

class StringBooleanSerializerTest {

    @Test
    fun `yes is deserialized to true`() {
        assertThat(Json.decodeFromString(StringBooleanSerializer, """"Yes"""")).isTrue()
    }

    @Test
    fun `no is deserialized to false`() {
        assertThat(Json.decodeFromString(StringBooleanSerializer, """"No"""")).isFalse()
    }

    @Test
    fun `unknown string is deserialized to false`() {
        assertThat(Json.decodeFromString(StringBooleanSerializer, """"hello"""")).isFalse()
    }
}
