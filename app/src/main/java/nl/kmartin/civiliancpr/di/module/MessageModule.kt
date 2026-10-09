package nl.kmartin.civiliancpr.di.module

import nl.kmartin.civiliancpr.repository.IMessageRepository
import nl.kmartin.civiliancpr.repository.MessageRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class MessageModule {
    @Binds
    abstract fun bindIMessageRepository(messageRepositoryImpl: MessageRepositoryImpl): IMessageRepository
}
