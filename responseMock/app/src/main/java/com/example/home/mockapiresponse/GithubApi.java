package com.example.home.mockapiresponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GithubApi {
    @GET("/users/erictrademe")
    Call<Githubuser> getGithubUsers();
}
