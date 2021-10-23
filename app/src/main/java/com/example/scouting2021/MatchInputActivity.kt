package com.example.scouting2021
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.match_input_activity.*


lateinit var intent: Intent
public var match_tag = "Match"

class MatchInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match_input_activity)
    }
    fun getTeamNumber() : String {
        return TeamNumber.text.toString()
    }
    fun getMatchNumber() : String {
        return MatchNumber.text.toString()
    }

    fun checkIfEmpty( vararg theTextView: TextView): Boolean{
        for (x in theTextView) {
            if (x.text.isEmpty()) return false
        }
        return true
    }
    fun startNextActivity(view : View) {
        intent = Intent(this, ScoutingActivities::class.java)

        if (checkIfEmpty(TeamNumber, MatchNumber)) {
            intent.putExtra(match_tag, Gson().toJson(Match(getTeamNumber(), getMatchNumber())))
            Log.e("match_data","${Gson().fromJson(intent.extras!!.get(match_tag).toString(), Match::class.java)}")


            startActivity(Intent(this, ScoutingActivities::class.java))
        }

    }
}


