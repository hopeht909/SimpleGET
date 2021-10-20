package com.example.simpleget

import com.google.gson.annotations.SerializedName


class People {

    var data: List<PeopleDetailed>? = null

    class PeopleDetailed {

        @SerializedName("name")
        var name: String? = null


    }
}