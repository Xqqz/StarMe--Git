package com.example.richard.smarttabs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.richard.smarttabs.audioplayer.Audio;
import com.example.richard.smarttabs.audioplayer.StorageUtil;
import com.example.richard.smarttabs.pitcheswords.MakePitchesList;
import com.example.richard.smarttabs.pitcheswords.MakeWordsList;
import com.example.richard.smarttabs.pitcheswords.Pitch;
import com.example.richard.smarttabs.userinputsounddraw.GameView;
import com.example.richard.smarttabs.userinputsounddraw.MicInputResult;
import com.example.richard.smarttabs.videorecorder.Camera2VideoFragment;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import cn.zhaiyifan.lyric.LyricUtils;
import cn.zhaiyifan.lyric.widget.LyricView;

/**
 * Created by richard on 28.03.2018.
 */

public class SongPlayer extends AppCompatActivity {

    private Viewport graphViewPort;
    private Handler handler;
    private Runnable runnable;


    private GraphView graph;
    private DataPoint[] points;
    private LineGraphSeries<DataPoint> series;
    private int seriesNr;
    final static double GRAPH_STARTING_X = -0.8;
    final static double GRAPH_ENDING_X = 0.4;
    private double orderNr = GRAPH_STARTING_X;

    private ImageButton playRecordButton;
    private Button backToSongList;
    private TextView songTitleTextView;
    private LyricView lyricView;

    private List<Pitch> pitchesList;
    List<List<Pitch>> wordsList;
    ArrayList<Audio> audioList;

    private int songIndex;
    private MediaPlayer mediaPlayer;
    private android.media.MediaRecorder videoRecorder;

    private CoordinatorLayout frameLayout;
    private TextView pitchText, noteText;
    private GameView gameView;
    private MicInputResult micInputResult;

    private Camera2VideoFragment camera2VideoFragment;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_player);

        Intent intent = getIntent();
        String songTitle = intent.getExtras().getString("TITLE");
        songIndex = intent.getExtras().getInt("INDEX");
        audioList = intent.getExtras().getParcelableArrayList("AUDIOLIST");

        //Get Textview and Button
        playRecordButton = (ImageButton) findViewById(R.id.playRecord);

        backToSongList = (Button) findViewById(R.id.backToSongList);

        //Set song name/artist
//        songTitleTextView = (TextView) findViewById(R.id.songTitle);
//        songTitleTextView.setText(audioList.get(songIndex).getTitle());

        //Initialize pitches and words
        MakePitchesList listOfPithes = new MakePitchesList();
        MakeWordsList listOfWords = new MakeWordsList();
//        listOfWordsAndPithes.getWordsList();
        pitchesList = listOfPithes.getListOfPitches();
        wordsList = listOfWords.getWordsList(pitchesList);

        //Initialize graph
        graph = (GraphView) findViewById(R.id.graph);
        initGraph();

        //ViewPort
        graphViewPort = graph.getViewport();

        //Handler
        handler = new Handler();

        //MicInputd
        frameLayout = (CoordinatorLayout) findViewById(R.id.gameBoard);
        pitchText = (TextView) findViewById(R.id.pitchText);
        micInputResult = new MicInputResult();

        //GameView - User input
        gameView = new GameView(this);
        frameLayout.addView(gameView);

        //Lyrics
        lyricView = (LyricView) findViewById(R.id.lyricView);
        // You can call setLyric anytime to change the lyric to another
        lyricView.setLyric(LyricUtils.parseLyric(getResources().openRawResource(R.raw.perfect_ed_sheeran), "UTF-8"));
        lyricView.setLyricIndex(0);

        //Camera2Video
        camera2VideoFragment = Camera2VideoFragment.newInstance();

        //Start Camera Preview
        getFragmentManager().beginTransaction()
                .replace(R.id.container, camera2VideoFragment)
                .commit();

        //Start recording user input
        startRecordingUserInput();

        playRecordButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionevent) {
                final int action = motionevent.getAction();
                if (action == MotionEvent.ACTION_DOWN) {

                    //Start playing audio
                    playMedia(songIndex);

                    //Start moving graph
//                    drawAndMoveGraph();

                    //Start Lyrics
                    lyricView.play();

                    //Start recording video
//                    startRecordingVideo();

                } else if (action == MotionEvent.ACTION_UP) {

                    //Stop moving graph and set them to the beginning
                    resetGraph();

                    //Stop Playing audio
                    stopAudio();

                    //Stop Lyrics
                    lyricView.stop();
                    resetLyrics();

                    //Stop Recording
//                    stopRecordingVideo();

                }//end else
                return false;
            } //end onTouch
        }); //end b my button


        backToSongList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongPlayer.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        StrictMode.enableDefaults();

    }


    private void resetLyrics(){
        lyricView.setLyricIndex(0);
    }

    private void drawAndMoveGraph(){
        runnable = new Runnable() {
            public void run() {
                graphViewPort.setMinX(orderNr);
                graphViewPort.setMaxX(orderNr + 1);
                graph.invalidate();
                if(pitchesList.size() != orderNr){
                    orderNr = orderNr + 0.1;
//                                System.out.println(orderNr);
                }


                handler.postDelayed(this, 100);
            }
        };
//                    executor.scheduleAtFixedRate(runnable, 0, 3, TimeUnit.MILLISECONDS);
//        handler.postDelayed(runnable, 100);
        runnable.run();
    }

    private void moveGraph(){
        graphViewPort.setMinX(orderNr);
        graphViewPort.setMaxX(orderNr + 1);
        graph.invalidate();
        if(pitchesList.size() != orderNr){
            orderNr = orderNr + 0.1;
//                                System.out.println(orderNr);
        }
    }

    private void drawAndMoveGraph2(){
        runnable = new Runnable() {
            public void run() {
                System.out.println(orderNr);
                graphViewPort.setMinX(orderNr);
                graphViewPort.setMaxX(orderNr + 1);
                graph.invalidate();
                if(pitchesList.size() != orderNr){
                    orderNr = orderNr + 0.1;
//                                System.out.println(orderNr);
                }


                handler.postDelayed(this, 100);
            }
        };

        TimerTask task = new TimerTask(){
            public void run() {
                runOnUiThread(runnable);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 100);
    }

    private void initGraph(){
        for (int i = 0; i < wordsList.size(); i++) {
            seriesNr = 0;
            points = new DataPoint[wordsList.get(i).size()];
            for (Pitch pitch: wordsList.get(i)) {
                points[seriesNr] = new DataPoint(pitch.getOccuranceTime(), pitch.getPitch());
                seriesNr++;
            }
            series = new LineGraphSeries<>(points);
            series.setThickness(15);
            graph.addSeries(series);
        }

        //VocalTestPoints
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 50),
                new DataPoint(0, 75),
                new DataPoint(0, 100),
                new DataPoint(0, 125),
                new DataPoint(0, 150),
                new DataPoint(0, 175),
                new DataPoint(0, 200),
                new DataPoint(0, 225),
                new DataPoint(0, 250),
                new DataPoint(0, 275),
        });
        series.setSize(5);
        series.setColor(Color.YELLOW);
        graph.addSeries(series);


        // set manual X bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-50);
        graph.getViewport().setMaxY(400);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(GRAPH_STARTING_X);
        graph.getViewport().setMaxX(GRAPH_ENDING_X); //mitu korraga näeb

        graph.getViewport().setScrollable(true);
    }

    private void startRecordingUserInput(){
        AudioDispatcher dispatcher =
                AudioDispatcherFactory.fromDefaultMicrophone(44100,2048,0);



        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult res, AudioEvent e){
                final float pitchInHz = res.getPitch();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                                    noteText.setText(micInputResult.processPitch(pitchInHz));
                        pitchText.setText("" + pitchInHz);
//                                    gameView.setSingerArrowY(micInputResult.processPlayerCoordinate(pitchInHz));
                        gameView.setSingerArrowY(pitchInHz);
                        gameView.invalidate();
                    }
                });
            }
        };
        AudioProcessor pitchProcessor = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 44100, 2048, pdh);
        dispatcher.addAudioProcessor(pitchProcessor);

        Thread audioThread = new Thread(dispatcher, "Audio Thread");
        audioThread.start();
    }

    private void playMedia(int songIndex){
        StorageUtil storage = new StorageUtil(getApplicationContext());
        storage.storeAudio(audioList);
        storage.storeAudioIndex(songIndex);

        mediaPlayer = new MediaPlayer();

        //Reset so that the MediaPlayer is not pointing to another data source
        mediaPlayer.reset();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(storage.loadAudio().get(storage.loadAudioIndex()).getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.prepareAsync();
//        mediaPlayer.prepare(); // might take long! (for buffering, etc)
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
                drawAndMoveGraph();
            }
        });


    }

    private void stopAudio(){
        mediaPlayer.stop();
        mediaPlayer.release();

    }


    private void startRecordingVideo(){
        camera2VideoFragment.startVideoRecording();
    }

    private void stopRecordingVideo(){
        camera2VideoFragment.stopVideoRecording();
    }

    private void resetGraph(){
        handler.removeCallbacks(runnable);
        graphViewPort.setMinX(GRAPH_STARTING_X);
        graphViewPort.setMaxX(GRAPH_ENDING_X);
        graph.invalidate();
        orderNr = GRAPH_STARTING_X;
    }


}




//mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//public void onCompletion(MediaPlayer mp) {
//        finish(); // finish current activity
//        }
//        });