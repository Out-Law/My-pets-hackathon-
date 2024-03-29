package com.example.mypets;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCardView extends RecyclerView.Adapter<AdapterCardView.ViewHolder>{
    private Context mContext;
    private List<settings_cards> cards;
    Dialog dialog;


    public AdapterCardView(Context mContext, List<settings_cards> cards){
        this.mContext = mContext;
        this.cards = cards;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_settings_card, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ImgSettings.setImageDrawable(cards.get(position).getImg());
        holder.TextSettings.setText(cards.get(position).getText());

        dialog = new Dialog(holder.cv.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);


        holder.itemView.setOnClickListener(view -> {
            switch(cards.get(position).getText()) {
                case "Напоминание":
                    /*dialog.setContentView(R.layout.fragment_notification_settings);
                    dialog.findViewById(R.id.OK_button).setOnClickListener(v -> dialog.dismiss());
                    dialog.findViewById(R.id.Cancle_button).setOnClickListener(v -> dialog.dismiss());
                    dialog.show();*/
                    break;
                case "Звук":

                    break;
                case "У меня проблема":

                    break;
                case "Сбросить прогресс":
                    /*dialog.setContentView(R.layout.dialog_reset_profile);
                    dialog.findViewById(R.id.button3).setOnClickListener(v -> dialog.dismiss());
                    dialog.findViewById(R.id.button4).setOnClickListener(v -> dialog.dismiss());
                    dialog.show();*/
                    break;
                case "Регистрация/Авторизация":

                    break;
                case "О Разработчиках":

                    break;
            }
        });

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/  {
        CardView cv;
        ImageView ImgSettings;
        TextView TextSettings;

        ViewHolder(View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.cv);
            ImgSettings = itemView.findViewById(R.id.img_settings);
            TextSettings = itemView.findViewById(R.id.text_settings);
        }
    }
}
