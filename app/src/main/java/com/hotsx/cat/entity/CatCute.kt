package com.hotsx.cat.entity

data class CatCute(var breeds: List<String>,
                   var categories: List<CateGories>,
                   var id: String,
                   var url: String)