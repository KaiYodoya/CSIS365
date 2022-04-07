import com.example.finalproject.data.Pokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface PokeService {

    @GET("pokemon?limit=100000&offset=0")
    fun getAllPokemon(): Call<Pokemon>


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