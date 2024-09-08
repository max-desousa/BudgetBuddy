import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val month : Int,
    //val day : Int,
    val amount : BigDecimal
)