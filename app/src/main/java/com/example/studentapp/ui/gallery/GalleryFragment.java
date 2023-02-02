package com.example.studentapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.studentapp.R;
import com.google.android.gms.common.data.DataBuffer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
        RecyclerView convocationRecycler,eventsRecycler,freshersRecycler,farewellRecycler,otherRecycler;
        GalleryAdapter adapter;
        DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        eventsRecycler=view.findViewById(R.id.eventsRecycler);
        convocationRecycler=view.findViewById(R.id.convocationRecycler);
        freshersRecycler=view.findViewById(R.id.freshersRecycler);
        farewellRecycler=view.findViewById(R.id.farewellRecycler);
        otherRecycler=view.findViewById(R.id.otherRecycler);

        reference= FirebaseDatabase.getInstance().getReference();

        getConvoImage();
        getEventsImage();
        getFreshersImage();
        getFarewellImage();
        getOtherImage();
        

        return view;
    }

    private void getOtherImage() {
        reference.child("gallery").child("Other").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    String data= (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);

                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getFarewellImage() {
        reference.child("gallery").child("Farewell").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    String data= (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);

                farewellRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                farewellRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getFreshersImage() {

        reference.child("gallery").child("Freshers").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    String data= (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);

                freshersRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                freshersRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getEventsImage() {
        reference.child("gallery").child("Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    String data= (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);

                eventsRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                eventsRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getConvoImage() {
        reference.child("gallery").child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    String data= (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);

                convocationRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                convocationRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}