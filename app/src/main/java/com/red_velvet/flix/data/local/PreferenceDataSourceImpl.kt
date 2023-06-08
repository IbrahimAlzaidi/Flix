package com.red_velvet.flix.data.local

import com.red_velvet.flix.data.local.shared_prefs.SharedPrefs
import com.red_velvet.flix.repository.PreferenceDataSource
import javax.inject.Inject

class PreferenceDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPrefs
) : PreferenceDataSource {
    override suspend fun saveRequestToken(requestToken: String) {
        sharedPreferences.setToken(requestToken)
    }

    override suspend fun saveSessionId(sessionId: String) {
        sharedPreferences.setSessionId(sessionId)
    }

    override fun getRequestToken(): String? {
        return sharedPreferences.getToken()
    }

    override fun getSessionId(): String? {
        return sharedPreferences.getSessionId()
    }

    override suspend fun clearSession() {
        sharedPreferences.clearSessionId()
    }

    override suspend fun isUserLoggedIn(): Boolean {
        return sharedPreferences.getSessionId() != null
    }

}