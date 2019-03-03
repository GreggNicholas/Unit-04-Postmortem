package com.example.unit_04_assessment.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit_04_assessment.R;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private static final String ANIMAL_NAME = "name";
    private static final String ANIMAL_IMAGE = "image";
    private static final String ANIMAL_WIKI = "wiki";
    private View view;
    private OnfragmetInteractionListener mListener;
    private String animalName;
    private String animalImage;
    private String animalWiki;

    public static DetailFragment newInstance(String name, String image, String wiki) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.getString(ANIMAL_NAME, name);
        args.getString(ANIMAL_IMAGE, image);
        args.getString(ANIMAL_WIKI, wiki);
        detailFragment.setArguments(args);
        return detailFragment;

    }

    public DetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnfragmetInteractionListener) {
            mListener = (OnfragmetInteractionListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement onFragmentInteractionListener");
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalName = getArguments().getString(ANIMAL_NAME);
            animalImage = getArguments().getString(ANIMAL_IMAGE);
            animalWiki = getArguments().getString(ANIMAL_WIKI);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView nameView = view.findViewById(R.id.textview_fragmentdetail);
        final ImageView imageView = view.findViewById(R.id.image_fragmentdetail);
        final Button button = view.findViewById(R.id.button_fragmentdetail);

        nameView.setText(animalName);

        Picasso.get()
                .load(animalImage)
                .into(imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(animalWiki);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnfragmetInteractionListener {
        void onFragmentInteraction(String website);
    }

}
