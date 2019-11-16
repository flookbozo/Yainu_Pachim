package com.example.yainu_pachim.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yainu_pachim.MenuDetailsActivity;
import com.example.yainu_pachim.R;
import com.example.yainu_pachim.model.Menu;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private List<Menu> mMenuList;

    public RecyclerViewAdapter(Context mContext, int mResource, List<Menu> mMenuList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mMenuList = mMenuList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Menu menu = mMenuList.get(position);

        holder.menu = menu;
        holder.nameTextView.setText(menu.name);
        holder.typeTextView.setText(menu.type);
        holder.menuImageView.setImageResource(menu.imageRes);
        holder.calCheckButton.setText(String.valueOf(menu.cal).concat(" kcal"));
    }

    @Override
    public int getItemCount() {
        return mMenuList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView menuImageView;
        private TextView nameTextView;
        private TextView typeTextView;
        private CheckBox calCheckButton;

        private Menu menu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.menuImageView = itemView.findViewById(R.id.image_menu_view);
            this.nameTextView = itemView.findViewById(R.id.menu_text_view);
            this.typeTextView = itemView.findViewById(R.id.type_text_view);
            this.calCheckButton = itemView.findViewById(R.id.cal_button);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MenuDetailsActivity.class);
                    intent.putExtra("name" ,menu.name);
                    intent.putExtra("image", menu.imageRes);
                    intent.putExtra("type", menu.type);
                    intent.putExtra("cal", menu.cal);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
