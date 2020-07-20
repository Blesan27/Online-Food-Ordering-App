package com.example.smartmart001.History;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartmart001.Controller.StoreController;
import com.example.smartmart001.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends Fragment {

    public static HistoryAdapter historyAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, container, false);

        historyAdapter = new HistoryAdapter(getContext(), new ArrayList<History>());

        Call<ArrayList<History>> call = StoreController.getInstance().changer().getHistory("id","desc");

        call.enqueue(new Callback<ArrayList<History>>() {
            @Override
            public void onResponse(Call<ArrayList<History>> call, Response<ArrayList<History>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(),"Failed -1",Toast.LENGTH_SHORT).show();
                }

                historyAdapter.addAll(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<History>> call, Throwable t) {
                Toast.makeText(getContext(),"failed -2", Toast.LENGTH_SHORT).show();
            }
        });

        ListView history_list_view = view.findViewById(R.id.history_list_view);

        history_list_view.setAdapter(historyAdapter);

        history_list_view.setEmptyView(view.findViewById(R.id.history_empty_view));

        return view;
    }

}