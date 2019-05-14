package com.example.loginkotlinretrofit

interface MainContract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun showLoginSukses(succes : String)
        fun showLoginFailed(error : String)
    }
    interface Presenter {
        fun whenLogin(username : String, password : String)
    }
}