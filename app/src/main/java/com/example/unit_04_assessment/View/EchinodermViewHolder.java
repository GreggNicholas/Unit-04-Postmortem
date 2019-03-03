package com.example.unit_04_assessment.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit_04_assessment.Model.Echinoderm;
import com.example.unit_04_assessment.R;
import com.example.unit_04_assessment.SecondActivity;
import com.squareup.picasso.Picasso;

public class EchinodermViewHolder extends RecyclerView.ViewHolder {
    public static final String ANIMAL_KEY = "animal";
    public static final String IMAGE_KEY = "image";
    public static final String WIKI_KEY = "wiki";
    private TextView animalTextView;
    private ImageView animalImageView;

    public EchinodermViewHolder(@NonNull View itemView) {
        super(itemView);
        animalTextView = itemView.findViewById(R.id.textview_item_view);
        animalImageView = itemView.findViewById(R.id.image_item_view);

    }

    public void onBind(final Echinoderm echinoderm) {
        animalTextView.setText(echinoderm.getAnimal());
        Picasso.get().load(echinoderm.getImage()).into(animalImageView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), SecondActivity.class);
                        intent.putExtra(ANIMAL_KEY, echinoderm.getAnimal());
                        intent.putExtra(IMAGE_KEY, echinoderm.getImage());
                        intent.putExtra(WIKI_KEY, echinoderm.getWiki());
                        v.getContext().startActivity(intent);
                    }
                });
            }
        });

    }
}
