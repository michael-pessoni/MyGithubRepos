package com.michaelpessoni.mygithubrepos.data.repositories

import com.michaelpessoni.mygithubrepos.core.RemoteException
import com.michaelpessoni.mygithubrepos.data.model.Repo
import com.michaelpessoni.mygithubrepos.data.services.GithubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GithubService) : RepoRepository {
    override suspend fun listRepositories(user: String) = flow<List<Repo>> {
        try {
            val repoList = service.listRepos(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message())
        }
    }
}