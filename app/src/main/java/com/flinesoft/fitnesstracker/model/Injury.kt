package com.flinesoft.fitnesstracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flinesoft.fitnesstracker.globals.utility.TimeInterval
import com.flinesoft.fitnesstracker.globals.utility.days
import com.flinesoft.fitnesstracker.globals.utility.hours
import org.joda.time.DateTime

@Entity(tableName = "Injuries")
data class Injury(
    var type: Type,
    var startDate: DateTime
): Recoverable {
    enum class Type {
        STIFFNESS, MODERATE_COLD, SEVERE_COLD
    }

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    override val timeToRecover: TimeInterval
        get() = when (type) {
            Type.STIFFNESS -> 72.hours()
            Type.MODERATE_COLD -> 4.days()
            Type.SEVERE_COLD -> 7.days()
        }
}
