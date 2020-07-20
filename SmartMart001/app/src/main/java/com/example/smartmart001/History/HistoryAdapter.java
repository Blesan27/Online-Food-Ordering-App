package com.example.smartmart001.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartmart001.Controller.StoreController;
import com.example.smartmart001.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryAdapter extends ArrayAdapter<History> {
    public HistoryAdapter(@NonNull Context context, ArrayList<History> history_items){
        super(context, 0, history_items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        View my_view = convertView;


        if(my_view == null){
            my_view = LayoutInflater.from(getContext()).inflate(R.layout.history_view, parent, false);
        }

        final History current_history = getItem(position);

        TextView tv = my_view.findViewById(R.id.history_name);
        tv.setText(current_history != null ? current_history.getItemName() : null);

        tv = my_view.findViewById(R.id.history_shop_name);
        tv.setText(current_history != null ? current_history.getStoreName() : null);

        if (current_history.getDate()!=null) {
            tv = my_view.findViewById(R.id.date_view);
            tv.setText(current_history.getDate().toString().substring(0, 10));

            tv = my_view.findViewById(R.id.time_view_history);
            tv.setText(current_history.getDate().toString().substring(11, 19));

        }
        Button bt = my_view.findViewById(R.id.delete_history);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Void> call = StoreController.getInstance().changer().deleteHistory(current_history.getId());

                //Toast.makeText(v.getContext(), "done",Toast.LENGTH_SHORT).show();
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
                Call<ArrayList<History>> called = StoreController.getInstance().changer().getHistory("id","desc");

                called.enqueue(new Callback<ArrayList<History>>() {
                    @Override
                    public void onResponse(Call<ArrayList<History>> call, Response<ArrayList<History>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"failed -1",Toast.LENGTH_SHORT).show();
                        }

                        HistoryFragment.historyAdapter.clear();
                        HistoryFragment.historyAdapter.addAll(response.body());

                    }

                    @Override
                    public void onFailure(Call<ArrayList<History>> call, Throwable t) {
                        Toast.makeText(getContext(),"failed -2", Toast.LENGTH_SHORT).show();
                    }
                });

                HistoryFragment.historyAdapter.notifyDataSetChanged();
            }
        });

        return my_view;
    }
}
