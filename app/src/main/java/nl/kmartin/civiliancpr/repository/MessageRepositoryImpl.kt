package nl.kmartin.civiliancpr.repository

import androidx.annotation.WorkerThread
import nl.kmartin.civiliancpr.database.MessageDao
import nl.kmartin.civiliancpr.model.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(private val messageDao: MessageDao) :
    IMessageRepository {

    override val allMessages: Flow<List<Message>> = messageDao.getAll()

    @WorkerThread
    override suspend fun insert(message: Message) {
        messageDao.insert(message)
    }

    @WorkerThread
    override suspend fun insert(messages: List<Message>) {
        messageDao.insert(messages)
    }

    @WorkerThread
    override suspend fun delete(message: Message) {
        messageDao.delete(message)
    }

    @WorkerThread
    override suspend fun delete(messages: List<Message>) {
        messageDao.delete(messages)
    }

    override suspend fun deleteAll() {
        messageDao.deleteAll()
    }

}