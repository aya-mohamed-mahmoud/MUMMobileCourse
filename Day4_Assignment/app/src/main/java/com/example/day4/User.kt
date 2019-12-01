package com.example.day4

import java.io.Serializable;

class User : Serializable {

    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""
    var password: String = ""


    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    constructor(firstName: String, lastName: String, email: String, password: String) {
        //User(email, password)
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.password = password

    }


}