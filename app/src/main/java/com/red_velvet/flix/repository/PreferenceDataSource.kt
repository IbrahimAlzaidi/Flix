package com.red_velvet.flix.repository

interface PreferenceDataSource {
    suspend fun saveRequestToken(requestToken: String)
    suspend fun saveSessionId(sessionId: String)
    fun getRequestToken(): String?
    fun getSessionId(): String?
    suspend fun clearSession()
    suspend fun isUserLoggedIn(): Boolean
}