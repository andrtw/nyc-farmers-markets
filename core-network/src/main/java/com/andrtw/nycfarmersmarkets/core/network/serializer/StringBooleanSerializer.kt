package com.andrtw.nycfarmersmarkets.core.network.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object StringBooleanSerializer : KSerializer<Boolean> {
    override val descriptor = PrimitiveSerialDescriptor(
        serialName = "StringBooleanSerializer",
        kind = PrimitiveKind.STRING,
    )

    override fun deserialize(decoder: Decoder): Boolean {
        return decoder.decodeString().toBoolean()
    }

    override fun serialize(encoder: Encoder, value: Boolean) {
        encoder.encodeBoolean(value)
    }

    private fun String?.toBoolean() = when (this?.lowercase()) {
        "yes" -> true
        "no" -> false
        else -> false
    }
}
