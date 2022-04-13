import com.example.finalproject.data.Pokemon
import com.example.finalproject.data.Resource
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApi {

    @GET("pokemon?limit=100000&offset=0")
    fun getAllPokemon(): Call<Pokemon>

    @GET("pokemon?&limit=20")
    fun get20Pokemon(@Query("offset") index: Int): Call<Pokemon>

    @GET("{url}")
    fun getSpecificPokemon(@Path("url") url: String): Call<Resource>
}

/*
    companion object {
        var BASE_URL = "https://pokeapi.co/api/v2/"
        fun create(): PokeService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(PokeService::class.java)
        }
    }
}

 */

