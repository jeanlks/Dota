package br.ufg.inf.com.dota.fragments;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.com.dota.R;
import br.ufg.inf.com.dota.adapters.MatchAdapter;
import br.ufg.inf.com.dota.model.Match;
import br.ufg.inf.com.dota.utils.Utils;

public class FragmentMain extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Match> mList = new ArrayList<>();
    MatchAdapter adapter;

    public FragmentMain() {
    }

    @Override
    public void onResume() {
        updateList();
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);


        updateList();

        return rootView;
    }

    private void updateList() {
        FetchJson JsonTask = new FetchJson();
        JsonTask.execute();
    }

    public class FetchJson extends AsyncTask<List, Void, List> {

        private final String LOG_TAG = FetchJson.class.getSimpleName();

        /* The date/time conversion code is going to be moved outside the asynctask later,
         * so for convenience we're breaking it out into its own method now.
         */
        private String getReadableDateString(long time) {
            // Because the API returns a unix timestamp (measured in seconds),
            // it must be converted to milliseconds in order to be converted to valid date.
            SimpleDateFormat shortenedDateFormat = new SimpleDateFormat("EEE MMM dd");
            return shortenedDateFormat.format(time);
        }





        @Override
        protected List doInBackground(List... params) {

            Utils utils = new Utils();

            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String JsonStr = null;


            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            String steamID = prefs.getString(getString(R.string.pref_id_steam),
                    getString(R.string.pref_id_steam_default));
            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                final String DOTA_BASE_URL =
                        "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/?key=";
                final String KEY_PARAM = "F5E7B4E54808E4554C04D44A448F585C";
                final String ACCOUNT_PARAM = "&account_id=";
                final String STEAM_PARAM = steamID;

                String urlaux = DOTA_BASE_URL + KEY_PARAM + ACCOUNT_PARAM + STEAM_PARAM;

                URL url = new URL(urlaux);

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setConnectTimeout(2000);
                urlConnection.connect();



                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.

                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.

                }
                JsonStr = buffer.toString();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.

            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }

            try {

              return utils.getMatchDataFromJson(JsonStr);
            } catch (JSONException e) {
                Log.e(LOG_TAG, e.getMessage(), e);
                e.printStackTrace();
            }

            // This will only happen if there was an error getting or parsing the forecast.
      return null;
        }

        @Override
        protected void onPostExecute(List result) {
            if(result!=null){
            mList.clear();
            mList.addAll(result);
            adapter = new MatchAdapter(getActivity(), mList);
            mRecyclerView.setAdapter(adapter);
            super.onPostExecute(result);
        }}
    }

    }
