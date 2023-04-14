package com.example.workshopdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.workshopdemo.R;
import com.example.workshopdemo.models.Club;

import java.util.List;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.ViewHolder> {

    private Context context;
    List<Club> clubs;

    public PageAdapter(Context context, List<Club> clubs) {
        this.context = context;
        this.clubs = clubs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_club, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Club club = clubs.get(position);
        holder.bind(club);
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView clubName;
        private ImageView clubLogo;

        public ViewHolder(@NonNull View itemView) throws NullPointerException {
            super(itemView);
            itemView.setOnClickListener(this);
            clubName = itemView.findViewById(R.id.clubName);
            clubLogo = itemView.findViewById(R.id.clubLogo);
        }

        public void bind(Club club) {
            String clubNameStr = (String) club.getName();
            if (clubNameStr.equalsIgnoreCase("CS Club")) {
                Glide.with(context).load(R.mipmap.ic_csclublogo_foreground)
                        .centerCrop().transform(new RoundedCorners(360)).into(clubLogo);
            } else if (clubNameStr.equalsIgnoreCase("Girls Who Code")) {
                Glide.with(context).load(R.mipmap.ic_gwclogo)
                        .centerCrop().transform(new RoundedCorners(360)).into(clubLogo);
            } else {
                Glide.with(context).load(R.mipmap.ic_sjsuspartanlogo)
                        .centerCrop().transform(new RoundedCorners(360)).into(clubLogo);
            }
            clubName.setText(clubNameStr);
        }

        @Override
        public void onClick(View v) {

        }
    }
    }
