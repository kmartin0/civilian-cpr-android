package nl.kmartin.civiliancpr.repository

import nl.kmartin.civiliancpr.model.Message
import kotlinx.coroutines.flow.Flow

interface IMessageRepository {
    val allMessages: Flow<List<Message>>
    suspend fun insert(message: Message)
    suspend fun insert(messages: List<Message>)
    suspend fun delete(message: Message)
    suspend fun delete(messages: List<Message>)
    suspend fun deleteAll()
}