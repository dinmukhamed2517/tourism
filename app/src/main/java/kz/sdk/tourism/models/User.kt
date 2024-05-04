package kz.sdk.tourism.models

data class User(
    var name: String? = null,
    var lastname: String?= null,
    var pictureUrl: String? = null,
    var bonus:Float? = 0.0f,
)
