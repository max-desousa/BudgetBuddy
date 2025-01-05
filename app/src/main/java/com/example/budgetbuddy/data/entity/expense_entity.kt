import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val day : Int,
    val month : Int,
    val year : Int,
    val hour : Int,
    val minute : Int,
    val description : String,
    val category : String,
    val amount : Int
)