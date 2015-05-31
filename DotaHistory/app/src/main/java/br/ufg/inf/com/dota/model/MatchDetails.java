package br.ufg.inf.com.dota.model;

import java.util.ArrayList;

/**
 * Created by Jean on 24/05/2015.
 */
public class MatchDetails {
   private  ArrayList<Player> listPlayers = new ArrayList<>();
    private boolean radiant_win;
    private int duration;
    private int start_time;

    public ArrayList<Player> getListPlayers() {
        return listPlayers;
    }

    public void setListPlayers(ArrayList<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    private int match_id;
    private int match_seq_num;
    private int tower_status_radiant;
    private int tower_status_dire;
    private int cluster;
    private int first_blood_time;
    private int lobby_type;
    private int human_players;
    private int league_id;
    private int positive_votes;
    private int negative_votes;
    private int game_mode;

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public void setRadiant_win(boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getMatch_seq_num() {
        return match_seq_num;
    }

    public void setMatch_seq_num(int match_seq_num) {
        this.match_seq_num = match_seq_num;
    }

    public int getTower_status_radiant() {
        return tower_status_radiant;
    }

    public void setTower_status_radiant(int tower_status_radiant) {
        this.tower_status_radiant = tower_status_radiant;
    }

    public int getTower_status_dire() {
        return tower_status_dire;
    }

    public void setTower_status_dire(int tower_status_dire) {
        this.tower_status_dire = tower_status_dire;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public int getFirst_blood_time() {
        return first_blood_time;
    }

    public void setFirst_blood_time(int first_blood_time) {
        this.first_blood_time = first_blood_time;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(int lobby_type) {
        this.lobby_type = lobby_type;
    }

    public int getHuman_players() {
        return human_players;
    }

    public void setHuman_players(int human_players) {
        this.human_players = human_players;
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public int getPositive_votes() {
        return positive_votes;
    }

    public void setPositive_votes(int positive_votes) {
        this.positive_votes = positive_votes;
    }

    public int getNegative_votes() {
        return negative_votes;
    }

    public void setNegative_votes(int negative_votes) {
        this.negative_votes = negative_votes;
    }

    public int getGame_mode() {
        return game_mode;
    }

    public void setGame_mode(int game_mode) {
        this.game_mode = game_mode;
    }
}
