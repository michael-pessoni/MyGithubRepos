package com.michaelpessoni.mygithubrepos.data.repositories

import com.michaelpessoni.mygithubrepos.data.model.Repo
import com.michaelpessoni.mygithubrepos.data.services.GithubService
import kotlinx.coroutines.flow.flow

class RepoRepositoryImpl(private val service: GithubService) : RepoRepository {
    override suspend fun listRepositories(user: String) = flow<List<Repo>> {
        val repoList = service.listRepos(user)
        emit(repoList)
    }
}