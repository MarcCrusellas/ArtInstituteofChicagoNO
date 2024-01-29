package com.example.artinstituteofchicagono.model

import com.example.artinstituteofchicagono.data.room.small.SmallPaint

class Collection {

    var mut = mutableListOf<SmallPaint>()

    var values: Int = 0


    constructor(values : Int){
        this.values = values
    }


}