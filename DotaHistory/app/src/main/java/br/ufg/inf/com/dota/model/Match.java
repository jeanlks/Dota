package br.ufg.inf.com.dota.model;

import java.util.ArrayList;

/**
 * Created by Jean on 24/05/2015.
 */
public class Match {
    private String match_id;
    private String match_seq_num;
    private String start_time;
    private String lobby_type;
    private String radiant_team_id;
    private String dire_team_id;
    private ArrayList<Player> players = new ArrayList<>();
    public String getRadiant_team_id() {
        return radiant_team_id;
    }

    public void setRadiant_team_id(String radiant_team_id) {
        this.radiant_team_id = radiant_team_id;
    }

    public String getDire_team_id() {
        return dire_team_id;
    }

    public void setDire_team_id(String dire_team_id) {
        this.dire_team_id = dire_team_id;
    }



    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getMatch_seq_num() {
        return match_seq_num;
    }

    public void setMatch_seq_num(String match_seq_num) {
        this.match_seq_num = match_seq_num;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(String lobby_type) {
        this.lobby_type = lobby_type;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
