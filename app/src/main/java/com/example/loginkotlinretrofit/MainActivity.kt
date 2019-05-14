package com.example.loginkotlinretrofit


import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {


    var progressDialog: ProgressDialog? = null
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        btn_login.setOnClickListener {
            mainPresenter.whenLogin(edt_username.text.toString(), edt_password.text.toString())
        }

    }

    override fun showProgress() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog?.setMessage("Loading")
            progressDialog?.setCancelable(false)
            progressDialog?.show()
        }
    }

    override fun hideProgress() {
        progressDialog?.dismiss()
    }

    override fun showLoginSukses(succes: String) {
        Toast.makeText(this, succes, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun showLoginFailed(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }


    // Username : eve.holt@reqres.in
    // Password : cityslicka

}
