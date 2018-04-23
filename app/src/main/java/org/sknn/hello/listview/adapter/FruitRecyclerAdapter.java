package org.sknn.hello.listview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.sknn.hello.R;
import org.sknn.hello.listview.bean.Fruit;

import java.util.List;

public class FruitRecyclerAdapter extends RecyclerView.Adapter<FruitRecyclerAdapter.ViewHolder> {

    private List<Fruit> fruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        ImageView fruitImage;
        TextView fruitName;


        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_text);
        }
    }

    public FruitRecyclerAdapter() {
        super();
    }

    public FruitRecyclerAdapter(List<Fruit> fruitlsst) {
        this.fruitList = fruitlsst;
    }

    @Override
    public FruitRecyclerAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(), "HI", Toast.LENGTH_SHORT).show();
            }
        });

        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(parent.getContext(), Integer.toString(fruit.getId()), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruitName.setText(fruit.getName());
        holder.fruitImage.setImageResource(fruit.getId());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
