package nl.kmartin.civiliancpr.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import nl.kmartin.civiliancpr.model.Message

@Database(entities = [Message::class], version = 4, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}
