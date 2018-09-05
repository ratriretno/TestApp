package com.solfastory.testapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solfastory.testapp.R;
import com.solfastory.testapp.adapter.ItemAdapter;
import com.solfastory.testapp.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ListItemFragment extends Fragment {

    private ItemAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        adapter = new ItemAdapter(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        addData();
        return view;
    }

    public void addData() {
        List<ItemModel> itemList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ItemModel model = new ItemModel();
            model.pictList.add(R.drawable.cat_1);
            model.pictList.add(R.drawable.cat_2);
            model.pictList.add(R.drawable.cat_3);
            itemList.add(model);

            model = new ItemModel();
            model.pictList.add(R.drawable.cat_2);
            model.pictList.add(R.drawable.cat_3);
            model.pictList.add(R.drawable.cat_1);
            itemList.add(model);

            model = new ItemModel();
            model.pictList.add(R.drawable.cat_3);
            model.pictList.add(R.drawable.cat_1);
            model.pictList.add(R.drawable.cat_2);
            itemList.add(model);
        }

        adapter.addAll(itemList);



    }

}
