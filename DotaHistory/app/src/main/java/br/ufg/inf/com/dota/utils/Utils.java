package br.ufg.inf.com.dota.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.com.dota.model.Match;

/**
 * Created by Domingas on 30/05/2015.
 */
public class Utils
{
    public List<Match> getMatchDataFromJson(String JsonStr) throws JSONException {
        List<Match> mListPopulated = new ArrayList<>();

        // These are the names of the JSON objects that need to be extracted.
        final String OWM_RESULT = "result";
        final String OWM_MATCHES = "matches";

        try{
        JSONObject JsonObject = new JSONObject(JsonStr);


        JSONObject result = (JSONObject) JsonObject.get(OWM_RESULT);

        JSONArray matchesArray = result.getJSONArray(OWM_MATCHES);

        Match match = new Match();
        for (int i = 0; i < matchesArray.length(); i++) {
            match = new Match();

            JSONObject jsonObjectmatch = matchesArray.getJSONObject(i);
            match.setMatch_id(jsonObjectmatch.getString("match_id"));
            match.setMatch_seq_num(jsonObjectmatch.getString("match_seq_num"));
            match.setStart_time(jsonObjectmatch.getString("start_time"));
            match.setLobby_type(jsonObjectmatch.getString("lobby_type"));
            match.setRadiant_team_id(jsonObjectmatch.getString("radiant_team_id"));
            match.setDire_team_id(jsonObjectmatch.getString("dire_team_id"));


            mListPopulated.add(i, match);
        }
        System.gc();
        return  mListPopulated;
    }catch (Exception e ){
        Log.e(Utils.class.getSimpleName(),e.toString());
        }
    return null;
    }

}
