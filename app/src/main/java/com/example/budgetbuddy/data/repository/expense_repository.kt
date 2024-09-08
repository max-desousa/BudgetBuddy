import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    fun getAllItemsStream() : Flow<List<Expense>>

    fun getItemStream(id : Int) : Flow<Expense?>

    suspend fun insertExpense(expense: Expense)

    suspend fun deleteExpense(expense: Expense)

    suspend fun updateExpense(expense: Expense)
}

class OfflineExpenseRepository(private val expenseDao: ExpenseDao) : ExpenseRepository {
    override fun getAllItemsStream(): Flow<List<Expense>> = expenseDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Expense?> = expenseDao.getItem(id)

    override suspend fun insertExpense(expense: Expense) = expenseDao.insert(expense)

    override suspend fun deleteExpense(expense: Expense) = expenseDao.delete(expense)

    override suspend fun updateExpense(expense: Expense) = expenseDao.update(expense)

}
