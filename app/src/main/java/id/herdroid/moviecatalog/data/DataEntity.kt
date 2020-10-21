package id.herdroid.moviecatalog.data


data class DataEntity(
    val movieId: String,
    var title: String,
    var description: String,
    var releaseDate: String,
    var imagePath: String
)