package com.rc.rastreador.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewTreeViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rc.rastreador.R;
import com.rc.rastreador.databinding.FragmentHomeBinding;
import com.rc.rastreador.expenses.Event;
import com.rc.rastreador.expenses.Expense;
import com.rc.rastreador.utils.Adapter;

public class HomeFragment extends Fragment {
    private HomeViewModel model;
    RecyclerView mRecyclerView;
    Adapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Event[] events = new Event[]{
           new Expense("Gasolina", 1.2f),
           new Expense("Mercado", 50.5f)
        } ;
        mAdapter = new Adapter(events);

        mRecyclerView = view.findViewById(R.id.expenses_list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}