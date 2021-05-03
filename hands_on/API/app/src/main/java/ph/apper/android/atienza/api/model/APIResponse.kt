package ph.apper.android.atienza.api.model

import com.google.gson.annotations.SerializedName

class  Pokemon {
    @SerializedName("name")
    var name = ""
    @SerializedName("url")
    var url = ""

    constructor(name: String, url:String){
        this.name = name
        this.url = url
    }
}

class PokemonListResponse{
    @SerializedName("count")
    var count: Int = -1

    @SerializedName("next")
    var next: String = ""

    @SerializedName("previous")
    var previous: String = ""

    @SerializedName("results")
    var pokemonList: ArrayList<Pokemon> = ArrayList<Pokemon>()
}

class PokemonAbility {
    @SerializedName("name")
    var name = ""

    @SerializedName("url")
    var url = ""
}

class PokemonAbilityInfo {
    @SerializedName("ability")
    var ability:PokemonAbility = PokemonAbility()

    @SerializedName("is_hidden")
    var is_hidden = false

    @SerializedName("slot")
    var slot = -1
}

class PokemonSprite{
    @SerializedName("front_default")
    var front_default = ""
}

class PokemonInfoResponse{
    @SerializedName("name")
    var name: String = ""

    @SerializedName("height")
    var height: Int = -1

    @SerializedName("id")
    var id: Int = -1

    @SerializedName("abilities")
    var abilities:ArrayList<PokemonAbilityInfo> = ArrayList<PokemonAbilityInfo>()

    @SerializedName("sprites")
    var sprites:PokemonSprite = PokemonSprite()
}
