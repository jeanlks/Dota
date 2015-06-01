package br.ufg.inf.com.dota.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufg.inf.com.dota.model.Match;
import br.ufg.inf.com.dota.model.Player;


public class Utils {
    List<Match> mListAux = new ArrayList<>();

    public List<Match> getMatchDataFromJson(String JsonStr) throws JSONException {

        if (JsonStr == null) {
            return null;
        }
        Match match;
        Player player;
        // These are the names of the JSON objects that need to be extracted.
        final String OWM_RESULT = "result";
        final String OWM_MATCHES = "matches";
        final String OWM_PLAYERS = "players";
        try {
            JSONObject JsonObject = new JSONObject(JsonStr);


            JSONObject result = (JSONObject) JsonObject.get(OWM_RESULT);

            JSONArray matchesArray = result.getJSONArray(OWM_MATCHES);


            for (int i = 0; i < matchesArray.length(); i++) {
                match = new Match();


                JSONObject jsonObjectMatch = matchesArray.getJSONObject(i);
                match.setMatch_id(jsonObjectMatch.getString("match_id"));
                match.setMatch_seq_num(jsonObjectMatch.getString("match_seq_num"));
                match.setStart_time(jsonObjectMatch.getString("start_time"));
                match.setLobby_type(jsonObjectMatch.getString("lobby_type"));
                match.setRadiant_team_id(jsonObjectMatch.getString("radiant_team_id"));
                match.setDire_team_id(jsonObjectMatch.getString("dire_team_id"));


                JSONArray players = jsonObjectMatch.getJSONArray(OWM_PLAYERS);
                for (int j = 0; j < players.length(); j++) {
                    player = new Player();
                    JSONObject jsonObjectPlayer = players.getJSONObject(j);
                    player.setAccount_id(jsonObjectPlayer.getString("account_id"));
                    player.setPlayer_slot(jsonObjectPlayer.getString("player_slot"));
                    player.setHero_id(jsonObjectPlayer.getString("hero_id"));
                    match.getPlayers().add(player);
                }


                mListAux.add(i, match);
            }
            return mListAux;
        } catch (Exception e) {
            Log.e(Utils.class.getSimpleName(), e.toString());
        }
        return null;
    }

    public String findHeroNameByAccount(List mList, int position, String steamId) {
        mListAux = mList;
        String hero_id = null;
        for (int j = 0; j < mListAux.get(position).getPlayers().size(); j++) {
            if (steamId.equals(mListAux.get(position).getPlayers().get(j).getAccount_id())) {
                return findHeroNameByID(mListAux.get(position).getPlayers().get(j).getHero_id());

            }
        }
        return hero_id;
    }

    public String findHeroNameByID(String hero_id) {
        String heroName = "Hero nao cadastrado";
        if (hero_id.equals("1")) {
            heroName = "Anti Mage";
        }
        if (hero_id.equals("2")) {
            heroName = "Axe";
        }
        if (hero_id.equals("3")) {
            heroName = "Bane";
        }
        if (hero_id.equals("4")) {
            heroName = "Bloodseeker";
        }
        if (hero_id.equals("5")) {
            heroName = "Crystal Maiden";
        }
        if (hero_id.equals("6")) {
            heroName = "Drow Ranger";
        }
        if (hero_id.equals("7")) {
            heroName = "Earthshaker";
        }
        if (hero_id.equals("8")) {
            heroName = "Juggernaut";
        }
        if (hero_id.equals("9")) {
            heroName = "Mirana";
        }
        if (hero_id.equals("10")) {
            heroName = "Morphling";
        }
        if (hero_id.equals("11")) {
            heroName = "Shadow Fiend";
        }

        if (hero_id.equals("12")) {
            heroName = "Phantom Lancer";
        }
        if (hero_id.equals("13")) {
            heroName = "Puck";
        }
        if (hero_id.equals("14")) {
            heroName = "Pudge";
        }
        if (hero_id.equals("15")) {
            heroName = "Razor";
        }
        if (hero_id.equals("16")) {
            heroName = "Sand King";
        }
        if (hero_id.equals("17")) {
            heroName = "Storm Spirit";
        }
        if (hero_id.equals("18")) {
            heroName = "Sven";
        }
        if (hero_id.equals("19")) {
            heroName = "Tiny";
        }
        if (hero_id.equals("20")) {
            heroName = "Vengeful Spirit";
        }
        if (hero_id.equals("21")) {
            heroName = "Windrunner";
        }
        if (hero_id.equals("22")) {
            heroName = "Zeus";
        }
        if (hero_id.equals("23")) {
            heroName = "Kunkka";
        }
        if (hero_id.equals("25")) {
            heroName = "Lina";
        }
        if (hero_id.equals("26")) {
            heroName = "Lion";
        }
        if (hero_id.equals("27")) {
            heroName = "Shadow Shaman";
        }
        if (hero_id.equals("28")) {
            heroName = "Slardar";
        }
        if (hero_id.equals("29")) {
            heroName = "Tidehunter";
        }
        if (hero_id.equals("30")) {
            heroName = "Witch Doctor";
        }
        if (hero_id.equals("31")) {
            heroName = "Lich";
        }
        if (hero_id.equals("32")) {
            heroName = "Riki";
        }
        if (hero_id.equals("33")) {
            heroName = "Enigma";
        }
        if (hero_id.equals("34")) {
            heroName = "Tinker";
        }
        if (hero_id.equals("35")) {
            heroName = "Sniper";
        }
        if (hero_id.equals("36")) {
            heroName = "Necrolyte";
        }
        if (hero_id.equals("37")) {
            heroName = "Warlock";
        }
        if (hero_id.equals("38")) {
            heroName = "Beastmaster";
        }
        if (hero_id.equals("39")) {

            heroName = "Queen of Pain";
        }
        if (hero_id.equals("40")) {
            heroName = "Venomancer";
        }

        if (hero_id.equals("41")) {
            heroName = "Faceless Void";
        }
        if (hero_id.equals("42")) {
            heroName = "Wrait King";
        }
        if (hero_id.equals("43")) {
            heroName = "Death Prophet";
        }
        if (hero_id.equals("44")) {
            heroName = "Phantom Assassin";
        }
        if (hero_id.equals("45")) {
            heroName = "Pugna";
        }
        if (hero_id.equals("46")) {
            heroName = "Templar Assassin";
        }
        if (hero_id.equals("47")) {
            heroName = "Viper";
        }
        if (hero_id.equals("48")) {
            heroName = "Luna";
        }
        if (hero_id.equals("49")) {
            heroName = "Dragon Knight";
        }
        if (hero_id.equals("50")) {
            heroName = "Dazzle";
        }
        if (hero_id.equals("51")) {
            heroName = "Clockwerk";
        }
        if (hero_id.equals("52")) {
            heroName = "Leshrac";
        }
        if (hero_id.equals("53")) {
            heroName = "Nature Prophet";
        }
        if (hero_id.equals("54")) {
            heroName = "Lifestealer";
        }
        if (hero_id.equals("55")) {
            heroName = "DarkSeer";
        }
        if (hero_id.equals("56")) {
            heroName = "Clinckz";
        }
        if (hero_id.equals("57")) {
            heroName = "Omniknight";
        }
        if (hero_id.equals("58")) {
            heroName = "Enchantress";
        }
        if (hero_id.equals("59")) {
            heroName = "Huskar";
        }
        if (hero_id.equals("60")) {
            heroName = "Night Stalker";
        }
        if (hero_id.equals("61")) {
            heroName = "Broodmother";
        }
        if (hero_id.equals("62")) {
            heroName = "Bounty Hunter";
        }
        if (hero_id.equals("63")) {
            heroName = "Weaver";
        }
        if (hero_id.equals("64")) {
            heroName = "Jakiro";
        }
        if (hero_id.equals("65")) {
            heroName = "Batrider";
        }
        if (hero_id.equals("66")) {
            heroName = "Chen";
        }
        if (hero_id.equals("67")) {
            heroName = "Spectre";
        }
        if (hero_id.equals("68")) {
            heroName = "Ancient Apparition";
        }
        if (hero_id.equals("69")) {
            heroName = "Doom";
        }
        if (hero_id.equals("70")) {
            heroName = "Ursa";
        }
        if (hero_id.equals("71")) {
            heroName = "Spirit Breaker";
        }
        if (hero_id.equals("72")) {
            heroName = "Gyrocopter";
        }
        if (hero_id.equals("73")) {
            heroName = "Alchemist";
        }
        if (hero_id.equals("74")) {
            heroName = "Invoker";
        }
        if (hero_id.equals("75")) {
            heroName = "Silencer";
        }
        if (hero_id.equals("76")) {
            heroName = "Outworld Devourer";
        }
        if (hero_id.equals("77")) {
            heroName = "Lycan";
        }
        if (hero_id.equals("78")) {
            heroName = "Brewmaster";
        }
        if (hero_id.equals("79")) {
            heroName = "Shadow Demon";
        }
        if (hero_id.equals("80")) {
            heroName = "Lone Druid";
        }
        if (hero_id.equals("81")) {
            heroName = "Chaos Knight";
        }
        if (hero_id.equals("82")) {
            heroName = "Meepo";
        }
        if (hero_id.equals("83")) {
            heroName = "Treant Protector";
        }
        if (hero_id.equals("84")) {
            heroName = "Ogre Magi";
        }
        if (hero_id.equals("85")) {
            heroName = "Undying";
        }
        if (hero_id.equals("86")) {
            heroName = "Rubick";
        }
        if (hero_id.equals("87")) {
            heroName = "Disruptor";
        }
        if (hero_id.equals("88")) {
            heroName = "Nyx Assassin";
        }
        if (hero_id.equals("89")) {
            heroName = "Naga Siren";
        }
        if (hero_id.equals("90")) {
            heroName = "Keeper Of The Light";
        }
        if (hero_id.equals("91")) {
            heroName = "IO";
        }
        if (hero_id.equals("92")) {
            heroName = "Visage";
        }
        if (hero_id.equals("93")) {
            heroName = "Slark";
        }
        if (hero_id.equals("94")) {
            heroName = "Medusa";
        }
        if (hero_id.equals("95")) {
            heroName = "Troll Warlord";
        }
        if (hero_id.equals("96")) {
            heroName = "Centaur Warrunner";
        }
        if (hero_id.equals("97")) {
            heroName = "Magnus";
        }
        if (hero_id.equals("98")) {
            heroName = "Timbersaw";
        }
        if (hero_id.equals("99")) {
            heroName = "BristelBack";
        }
        if (hero_id.equals("100")) {
            heroName = "Tusk";
        }
        if (hero_id.equals("101")) {
            heroName = "Skywrath Mage";
        }
        if (hero_id.equals("102")) {
            heroName = "Abaddon";
        }
        if (hero_id.equals("103")) {
            heroName = "Elder Titan";
        }
        if (hero_id.equals("104")) {
            heroName = "Legion Commander";
        }
        if (hero_id.equals("105")) {
            heroName = "Techies";
        }
        if (hero_id.equals("106")) {
            heroName = "Ember Spirit";
        }
        if (hero_id.equals("107")) {
            heroName = "Earh Spirit";
        }
        if (hero_id.equals("108")) {
            heroName = "Abyssal Underlord";
        }
        if (hero_id.equals("109")) {
            heroName = "TerrorBlade";
        }
        if (hero_id.equals("110")) {
            heroName = "Phoenix";
        }
        if (hero_id.equals("111")) {
            heroName = "Oracle";
        }
        if (hero_id.equals("112")) {
            heroName = "Winter Wyvern";
        }

        return heroName;
    }


    public String getReadableDateString(String unixtime) {
        long dv = Long.valueOf(unixtime)*1000;// its need to be in milisecond
       Date df = new java.util.Date(dv);
      String dateStr = new SimpleDateFormat("MM dd, yyyy hh:mma").format(df);
        return dateStr;
    }
}
