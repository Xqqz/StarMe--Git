package com.example.richard.smarttabs.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;;import com.example.richard.smarttabs.audioplayer.Audio;
import com.example.richard.smarttabs.audioplayer.CustomTouchListener;
import com.example.richard.smarttabs.audioplayer.MediaPlayerService;
import com.example.richard.smarttabs.audioplayer.RecyclerView_Adapter;
import com.example.richard.smarttabs.audioplayer.onItemClickListener;
import com.example.richard.smarttabs.R;
import com.example.richard.smarttabs.SongPlayer;

import java.util.ArrayList;

public class BlankFragment extends Fragment {
    public static final String TITLE = "TITLE";
    public static final String AUDIOLIST = "AUDIOLIST";
    public static final String INDEX = "INDEX";

    public static BlankFragment newInstance(String title, ArrayList<Audio> audioList) {

        BlankFragment blankFragment = new BlankFragment();

        Bundle bundle = new Bundle();
        bundle.putString("Title", title);
        bundle.putParcelableArrayList("AudioList", audioList);

        blankFragment.setArguments(bundle);

        return blankFragment;
    }


    public BlankFragment() {
        // Required empty public constructor
    }

    private String title;
    private ArrayList<Audio> audioList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString("Title");
            audioList = getArguments().getParcelableArrayList("AudioList");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.recycler_view_songs, container, false);

        if (audioList != null && audioList.size() > 0) {
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
            RecyclerView_Adapter adapter = new RecyclerView_Adapter(audioList, getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.addOnItemTouchListener(new CustomTouchListener(getContext(), new onItemClickListener() {
                @Override
                public void onClick(View view, int index) {
                    Intent intent = new Intent(rootView.getContext(), SongPlayer.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putParcelableArrayList(AUDIOLIST, audioList);
                    intent.putExtra(TITLE, title);
                    intent.putExtra(INDEX, index);
                    intent.putExtra(AUDIOLIST, audioList);

//                    MediaPlayerService playerService = new MediaPlayerService();
//                    playerService.stopSelf();

                    startActivity(intent);
                }
            }));
        }

        return rootView;
    }



//

}