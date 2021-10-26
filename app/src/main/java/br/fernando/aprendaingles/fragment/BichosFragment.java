package br.fernando.aprendaingles.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.fernando.aprendaingles.R;


public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageViewCao, imageViewGato,
            imageViewVaca,imageViewLeao,
            imageViewMacaco,imageViewOvelha;
    private MediaPlayer mediaPlayer;


    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bichos, container, false);

         imageViewCao = view.findViewById(R.id.imageViewCao);
         imageViewGato = view.findViewById(R.id.imageViewGato);
         imageViewLeao = view.findViewById(R.id.imageViewLeao);
         imageViewMacaco = view.findViewById(R.id.imageViewMacaco);
         imageViewOvelha = view.findViewById(R.id.imageViewOvelha);
         imageViewVaca = view.findViewById(R.id.imageViewVaca);

         //aplica evento de clique
         imageViewCao.setOnClickListener(this);
         imageViewVaca.setOnClickListener(this);
         imageViewOvelha.setOnClickListener(this);
         imageViewMacaco.setOnClickListener(this);
         imageViewLeao.setOnClickListener(this);
         imageViewGato.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageViewCao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.dog);
                tocarSom();
                break;
            case R.id.imageViewGato:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cat);
                tocarSom();
                break;
            case R.id.imageViewLeao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                tocarSom();
                break;
            case R.id.imageViewMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.monkey);
                tocarSom();
                break;
            case R.id.imageViewOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                tocarSom();
                break;
            case R.id.imageViewVaca:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
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