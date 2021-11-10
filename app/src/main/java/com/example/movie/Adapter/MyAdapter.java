package com.example.movie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.DetailsActivity;
import com.example.movie.Model.Film;
import com.example.movie.Model.User;
import com.example.movie.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Film> films;
    private Context mcontext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(mcontext).inflate(R.layout.items,parent,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Film film = films.get(position);
        holder.loginTV.setText(film.getTitle());

        holder.detailsuser.setOnClickListener(view -> {
            Intent intent = new Intent(mcontext, DetailsActivity.class);
            intent.putExtra("id",film.getTitle());
            intent.putExtra("login",film.getDescription());
            mcontext.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView loginTV ;
        private Button detailsuser ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            loginTV = itemView.findViewById(R.id.loginitem);
            detailsuser= itemView.findViewById(R.id.details);

        }
    }
    public MyAdapter(Context context, List<Film> films){

        this.mcontext=context;
        this.films=films;

    }
}
