package com.github.krzema12.api

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@Serializable
@JsExport
@ExperimentalJsExport
data class Cat(
    val name: String,
    val age: Int,
)

