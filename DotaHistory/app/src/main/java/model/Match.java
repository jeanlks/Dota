package model;

import java.util.ArrayList;

/**
 * Created by Jean on 24/05/2015.
 */
public class Match {
    private int match_id;
    private int match_seq_num;
    private int start_time;
    private int lobby_type;
    private ArrayList<Player> players = new ArrayList<>();

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

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(int lobby_type) {
        this.lobby_type = lobby_type;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
