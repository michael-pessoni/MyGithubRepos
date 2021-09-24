package com.michaelpessoni.mygithubrepos.data.repositories

import com.michaelpessoni.mygithubrepos.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}