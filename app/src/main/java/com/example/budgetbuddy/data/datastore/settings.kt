import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.math.BigDecimal

class UserSettingsRepository(
    private val datastore : DataStore<Preferences>
) {
    private companion object {
        val MONTHLY_SPENDING_LIMIT = doublePreferencesKey("monthly_spending_limit")
        const val TAG = "UserPreferencesRepo"
    }

    suspend fun saveSpendingPreference(_amount : Double) {
        datastore.edit {
            preferences ->
            preferences[MONTHLY_SPENDING_LIMIT] = _amount
        }
    }

    val monthlySpendingLimit : Flow<Double> = datastore.data
        .catch {
            if(it is IOException) {
                Log.e(TAG, "Error reading preferences.", it)
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map {
        preferences ->
        preferences[MONTHLY_SPENDING_LIMIT] ?: 0.0
    }
}