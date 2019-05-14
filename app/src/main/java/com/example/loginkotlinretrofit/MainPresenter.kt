package com.example.loginkotlinretrofit

import com.example.loginkotlinretrofit.model.LoginBody
import com.example.loginkotlinretrofit.model.ResponseLogin
import com.example.loginkotlinretrofit.network.ApiLoginClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(model: MainContract.View) : MainContract.Presenter {

    var view: MainContract.View? = null

    init {
        view = model
    }

    override fun whenLogin(username: String, password: String) {
        if (username.isEmpty() || username == null) {
            view?.showLoginSukses("Mohon Isi di kolom Username")
            return
        }
        if (password == null || password.isEmpty()) {
            view?.showLoginSukses("Mohon Isi di Kolom Password")
        }
        view?.showProgress()

        val loginBody = LoginBody(username, password)

        val doLogin = ApiLoginClient.create()
        doLogin.doLogin(loginBody).enqueue(object : Callback<ResponseLogin> {

            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                view?.hideProgress()

                if (response.body() != null) {

                    var responseLogin : ResponseLogin? = response.body()

                    if (responseLogin?.token != null) {

                        view?.showLoginSukses("Login Berhasil")
                    }

                } else {
                    view?.showLoginFailed(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                view?.hideProgress()
                view?.showLoginFailed(t.message.toString())
            }

        } )
    }
}