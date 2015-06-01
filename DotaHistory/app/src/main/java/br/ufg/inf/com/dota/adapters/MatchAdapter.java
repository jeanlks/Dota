package br.ufg.inf.com.dota.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.com.dota.R;
import br.ufg.inf.com.dota.model.Match;
import br.ufg.inf.com.dota.utils.Utils;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private Context mContext;
    private List<Match> mList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;


    public MatchAdapter(Context c, List<Match> l) {
        mContext = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_match, viewGroup, false);
        ViewHolder mvh = new ViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder ViewHolder, int position) {
        Utils utils = new Utils();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext.getApplicationContext());
        String steamID = prefs.getString(mContext.getString(R.string.pref_id_steam),
               mContext.getString(R.string.pref_id_steam_default));
        Log.v("steamID: ",steamID);
        ViewHolder.textViewHero.setText(utils.findHeroNameByAccount(mList, position, steamID));
        Log.v("Data: ", utils.getReadableDateString(mList.get(position).getStart_time()));
        ViewHolder.textViewTime.setText(utils.getReadableDateString(mList.get(position).getStart_time()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addListItem(Match c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }


    public void removeListItem(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewHero;
        public TextView textViewTime;
        public ViewHolder(View itemView) {
            super(itemView);

            textViewHero = (TextView) itemView.findViewById(R.id.tvHero);
            textViewTime = (TextView) itemView.findViewById(R.id.tvTime);

        }

    }
}
