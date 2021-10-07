package com.miu.curriculumvitae.common

import java.io.Serializable

class Person(var avatar: Int, var firstName: String, var lastName: String, var email: String, var profession: String, var phoneNumber: String, var about: String) : Serializable {
}