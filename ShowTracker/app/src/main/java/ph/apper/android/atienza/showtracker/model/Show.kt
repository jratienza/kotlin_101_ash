package ph.apper.android.atienza.showtracker.model

data class Show(val title: String, var type: ShowType, var genre:ShowGenres) {
    constructor() : this("", ShowType.UNDEFINED, ShowGenres.UNDEFINED)
}

enum class ShowType{
    UNDEFINED,
    ANIME,
    MOVIE,
    OVA,
    SERIES,
    KDRAMA;

    companion object {
        fun getType(type: String) =
            when(type){
                "ANIME" -> ANIME
                "MOVIE" -> MOVIE
                "OVA" -> OVA
                "SERIES" -> SERIES
                "KDRAMA" -> KDRAMA
                else -> UNDEFINED
            }

    }
}

enum class ShowGenres{
    UNDEFINED,
    DRAMA,
    COMEDY,
    ACTION,
    ANIMATION,
    ROMANCE,
    HORROR,
    THRILLER,
    MUSICAL,
    DOCUMENTARY;

    companion object {
        fun getGenre(genre: String) =
                when(genre){
                    "DRAMA" -> DRAMA
                    "COMEDY" -> COMEDY
                    "ACTION" -> ACTION
                    "ANIMATION" -> ANIMATION
                    "ROMANCE" -> ROMANCE
                    "HORROR" -> HORROR
                    "THRILLER" ->THRILLER
                    "ROMANCE" -> ROMANCE
                    "MUSICAL" -> MUSICAL
                    "DOCUMENTARY" -> DOCUMENTARY


                    else -> UNDEFINED
                }

    }
}