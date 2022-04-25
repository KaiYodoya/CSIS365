package com.example.finalproject.view
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.data.Resource
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import com.google.android.material.snackbar.Snackbar


class DetailPokemonActivity : AppCompatActivity(), DetailView{

    lateinit var presenter: DetailPresenter

    lateinit var container: View
    lateinit var imageDefault: ImageView
    lateinit var imageShiny: ImageView
    lateinit var ability: TextView
    lateinit var ability2: TextView
    lateinit var hiddenAbility: TextView
    lateinit var chart: RadarChart



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_pokemon)

        val intent = intent
        val tmpUrl = intent.getStringExtra("tmpUrl")

        bindViews()
        presenter = DetailPresenterFactory.createPresenter(this, tmpUrl!!)
        presenter.start()
    }


    private fun radarChart(hp:Float,
                           attack: Float,
                           defense: Float,
                           sAttack: Float,
                           sDefense: Float,
                           speed: Float
    ) {

        val params = arrayOf(hp,attack,defense,sAttack,sDefense,speed)
        val baseStatsArray = mutableListOf<RadarEntry>()
        for (param in params) baseStatsArray.add(RadarEntry(param))


        val baseStatsDataset= RadarDataSet(baseStatsArray, "Base Stats")
        baseStatsDataset.setDrawFilled(true)
        baseStatsDataset.setColor(Color.BLUE,100)
        val dataSets: IRadarDataSet = baseStatsDataset
        val data = RadarData(dataSets)


        chart.xAxis.apply {
            textSize = 12f
            yOffset = 0f
            xOffset = 0f
            valueFormatter = object : ValueFormatter(){
                private val paramLabel = arrayOf("HP","Attack","Defense","Special Attack","Special Defense", "Speed")
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    return paramLabel[value.toInt() % paramLabel.size]
                }
            }
        }

        chart.yAxis.apply{
            textSize = 5f
            setDrawLabels(true)
            setLabelCount(6, /*force: */true)
            axisMinimum = 0.0f
            axisMaximum = 150f
            granularity = 1f

        }

        chart.isRotationEnabled = false
        chart.description.isEnabled = false;


        // all change have to be implemented above
        chart.data = data
        chart.data.setValueTextSize(11f)
        chart.invalidate()
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun bindDetail(resource: Resource)
    {
        Glide.with(this)
            .load(resource.sprites?.front_default)
            .into(imageDefault)

        Glide.with(this)
            .load(resource.sprites?.front_shiny)
            .into(imageShiny)


        // The number of the length of abilities list
        var listLen =0
        for (i in resource.abilities) {
            listLen += 1
        }

        // The number of abilities the pokemon have
        when (listLen) {
            1 -> {
                ability.text = resource.abilities[0]!!.ability!!.name.toString()
            }
            2 -> {
                ability.text = resource.abilities[0]!!.ability!!.name.toString()
                hiddenAbility.text = resource.abilities[1]!!.ability!!.name.toString()
            }
            3 -> {
                ability.text = resource.abilities[0]!!.ability!!.name.toString()
                ability2.text = resource.abilities[1]!!.ability!!.name.toString()
                hiddenAbility.text = resource.abilities[2]!!.ability!!.name.toString()
            }
            else -> { // Note the block
                print("Error: Pokemon should have at least one ability")
            }
        }

        createRadarChart(resource)
        createActionbar(resource)
    }

    private fun createActionbar(resource: Resource)
    {
        // button to go back to main list on actionbar
        val actionBar = supportActionBar
        actionBar!!.title = resource.forms[0]!!.name.toString()
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun createRadarChart(resource: Resource)
    {
        val hp = resource.stats[0]!!.base_stat!!.toFloat()
        val attack = resource.stats[1]!!.base_stat!!.toFloat()
        val defence = resource.stats[2]!!.base_stat!!.toFloat()
        val sAttack = resource.stats[3]!!.base_stat!!.toFloat()
        val sDefense = resource.stats[4]!!.base_stat!!.toFloat()
        val speed = resource.stats[5]!!.base_stat!!.toFloat()
        radarChart(hp, attack, defence, sAttack, sDefense, speed)
    }


    private fun bindViews()
    {
        imageDefault = findViewById(R.id.pokemonImageDefault)
        imageShiny = findViewById(R.id.pokemonImageShiny)
        ability = findViewById(R.id.ability)
        ability2 = findViewById(R.id.ability2)
        hiddenAbility = findViewById(R.id.hiddenAbility)
        chart = findViewById(R.id.radarChart)
    }

}