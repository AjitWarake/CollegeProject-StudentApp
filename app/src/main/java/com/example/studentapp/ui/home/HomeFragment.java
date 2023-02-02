package com.example.studentapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.studentapp.R;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider=view.findViewById(R.id.slider);


        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/project-8f49b.appspot.com/o/gallery%2F%5BB%40cb0d91cjpg?alt=media&token=25a2ba70-d34b-40e3-8211-3314c6a1de52", ScaleTypes.FIT ));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/project-8f49b.appspot.com/o/gallery%2F%5BB%40ad878cbjpg?alt=media&token=6c0e1ddd-4c29-4837-b65c-ed576d937660", ScaleTypes.FIT ));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/project-8f49b.appspot.com/o/gallery%2F%5BB%403f3bb0djpg?alt=media&token=fdd68e4a-d721-4409-8f51-0b36cc9ebc9e", ScaleTypes.FIT ));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/project-8f49b.appspot.com/o/gallery%2F%5BB%402bb1253jpg?alt=media&token=3c4be33d-d171-4ada-86ad-7bced5bb5532", ScaleTypes.FIT ));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);



        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri= Uri.parse("geo:0, 0?q=CSIBER Kolhapur Maharastra");
        Intent intent= new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}