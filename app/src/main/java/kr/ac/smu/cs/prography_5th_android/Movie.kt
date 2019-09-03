package kr.ac.smu.cs.prography_5th_android


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("locations")
    val locations: List<String>,
    @SerializedName("people")
    val people: List<String>,
    @SerializedName("producer")
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("rt_score")
    val rtScore: String,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("vehicles")
    val vehicles: List<String>
)