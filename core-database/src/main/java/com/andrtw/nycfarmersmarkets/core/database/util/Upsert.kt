package com.andrtw.nycfarmersmarkets.core.database.util

suspend fun <T> upsert(
    entities: List<T>,
    onInsert: suspend (entities: List<T>) -> List<Long>,
    onUpdate: suspend (List<T>) -> Unit,
) {
    val inserted = onInsert(entities)
    val toUpdate = entities
        .zip(inserted)
        .mapNotNull { (entity, insertedId) ->
            // Insert operation will return a -1 ID for conflicting entities
            if (insertedId == -1L) entity
            else null
        }
    if (toUpdate.isNotEmpty()) {
        onUpdate(toUpdate)
    }
}
