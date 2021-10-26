package br.fernando.aprendaingles.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.fernando.aprendaingles.R;


public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageViewUm, imageViewDois,
            imageViewCinco,imageViewQuatro,
            imageViewSeis,imageViewTres;
    private MediaPlayer mediaPlayer;


    public NumerosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageViewUm = view.findViewById(R.id.imageViewUm);
        imageViewDois = view.findViewById(R.id.imageViewDois);
        imageViewTres = view.findViewById(R.id.imageViewTres);
        imageViewQuatro = view.findViewById(R.id.imageViewQuatro);
        imageViewCinco = view.findViewById(R.id.imageViewCinco);
        imageViewSeis = view.findViewById(R.id.imageViewSeis);

//        aplica evento de clique
        imageViewUm.setOnClickListener(this);
        imageViewDois.setOnClickListener(this);
        imageViewTres.setOnClickListener(this);
        imageViewQuatro.setOnClickListener(this);
        imageViewCinco.setOnClickListener(this);
        imageViewSeis.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageViewUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
                break;
            case R.id.imageViewDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;
            case R.id.imageViewTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;
            case R.id.imageViewQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;
            case R.id.imageViewCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;
            case R.id.imageViewSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
//                    liberando os recurso so mediaplayer
                    mp.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}