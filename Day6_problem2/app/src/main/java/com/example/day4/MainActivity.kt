package com.example.day4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var listOfUsers = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user1 = User("Aya1", "Zaki", "aya1@gmail.com", "123")
        val user2 = User("Aya2", "Zaki", "aya2@gmail.com", "123")
        val user3 = User("Aya3", "Zaki", "aya3@gmail.com", "123")
        val user4 = User("Aya4", "Zaki", "aya4@gmail.com", "123")
        val user5 = User("Aya5", "Zaki", "aya5@gmail.com", "123")

        listOfUsers.add(user1);
        listOfUsers.add(user2)
        listOfUsers.add(user3)
        listOfUsers.add(user4)
        listOfUsers.add(user5)

        listOfUsers.forEach {
            println("The element is $it")
        }

//        var tv1 = findViewById<TextView>(R.id.forgotPassword)
//        Linkify.addLinks(tv1, Linkify.ALL)
    }

    fun login(view: View) {
        listOfUsers.forEach {
            println("The element loginnnn  ${it.email}")
        }
        var emailInput = email.text //get email
        var passwordInput = password.text  //get password
        var loggedUser: User

        if (emailInput.toString() != "" && passwordInput.toString() != "") {
            loggedUser = User(emailInput.toString(), passwordInput.toString())

            //put extra data
            listOfUsers.forEach {
                if ("${it.email}".equals(loggedUser.email)) {
                    loggedUser.firstName = "${it.firstName}"
                    loggedUser.lastName = "${it.lastName}"
                }
            }

            //check in array
            listOfUsers.forEach {
                if ("${it.email}".equals(loggedUser.email) && "${it.password}".equals(loggedUser.password)) {println("11")

                    println("successfully login")
                    Toast.makeText(this, "successfully login", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ShoppingCategoryActivity::class.java)
                    intent.putExtra("userName", loggedUser.firstName + " " + loggedUser.lastName)
                    startActivity(intent)

                }
                if (!("${it.email}".equals(loggedUser.email)) && !("${it.password}".equals(loggedUser.password))) {println("22")

                    Toast.makeText(this, "You Entered Wrong Data please try again...", Toast.LENGTH_SHORT).show()
                    return
                }

            }


        } else {
            Toast.makeText(this, "Enter userName and password to login", Toast.LENGTH_SHORT).show()
        }
    }


    //Implicit
    fun forgotPasswordAction(view: View) {
        var inputEmail = email.text.toString()
        if (inputEmail != "") {
            var pass: String = ""

            listOfUsers.forEach {
                if ("${it.email}".equals(inputEmail.toString())) {
                    pass = "${it.password}"
                }
            }
                val intent = Intent()
                intent.action = Intent.ACTION_SEND //assign value by calling setter
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, pass)
                intent.putExtra(Intent.EXTRA_SUBJECT, "your password")
                intent.putExtra(Intent.EXTRA_EMAIL, inputEmail.toString())

                startActivity(Intent.createChooser(intent, "Send Email"));

        }

        else{
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show()

        }
    }

    fun createNewAccountAction(view: View) {

        val intent = Intent(this@MainActivity, CreateNewAccount::class.java)

        startActivityForResult(intent, 1)
    }

    // to get data from activity 2
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                var returnedResult =
                    data?.getSerializableExtra("user") //data.getdata() to get data form intent
                var user = returnedResult as User
                listOfUsers.add(user)
                listOfUsers.forEach {
                    println("The element isssssssssssssss ${it.email}")
                }
            }
        }
    }
}

