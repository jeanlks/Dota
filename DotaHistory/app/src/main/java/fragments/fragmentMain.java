package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.com.dota.adapters.MatchAdapter;
import br.ufg.inf.com.dota.R;
import model.Match;

public class fragmentMain extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Match> mList = new ArrayList<>();

    public fragmentMain() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);


        Match match = new Match();
        match.setMatch_id(123);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);
        mList.add(match);


        MatchAdapter adapter = new MatchAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(adapter);
        return rootView;
    }
}
