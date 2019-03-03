package com.example.unit_04_assessment.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unit_04_assessment.Model.Echinoderm;
import com.example.unit_04_assessment.R;
import com.example.unit_04_assessment.View.EchinodermViewHolder;

import java.util.List;

public class EchinodermAdapter extends RecyclerView.Adapter<EchinodermViewHolder> {
    private final List<Echinoderm> getEchinodermList;

    public EchinodermAdapter(List<Echinoderm> getEchinodermList) {
        this.getEchinodermList = getEchinodermList;
    }

    @NonNull
    @Override
    public EchinodermViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return new EchinodermViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EchinodermViewHolder echinodermVIewHolder, int position) {
        echinodermVIewHolder.onBind(getEchinodermList.get(position));
    }

    @Override
    public int getItemCount() {
        return getEchinodermList.size();
    }
}
