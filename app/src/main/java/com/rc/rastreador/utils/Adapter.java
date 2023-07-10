package com.rc.rastreador.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rc.rastreador.R;
import com.rc.rastreador.expenses.Event;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private Event[] localDataSet;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder)
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView lblName;
            private final TextView lblExpense;

            private final Button btnActions;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                lblExpense = view.findViewById(R.id.expense_text);
                lblName = (TextView) view.findViewById(R.id.expense_name);

                btnActions = view.findViewById(R.id.btnActions);

                btnActions.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "Hallo", Toast.LENGTH_LONG).show();
                    }
                });
            }

            public TextView getLblName() {
                return lblName;
            }

            public TextView getLblExpense() {
                return lblExpense;
            }
        }

        /**
         * Initialize the dataset of the Adapter
         *
         * @param dataSet String[] containing the data to populate views to be used
         * by RecyclerView
         */
        public Adapter(Event[] dataSet) {
            localDataSet = dataSet;
        }

        // Create
        // new views (invoked by the layout manager)
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.row_layout, viewGroup, false);

            return new ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            Collector collector = new Collector();

            viewHolder.getLblName().setText(localDataSet[position].getName());
            localDataSet[position].collectData(collector);

            viewHolder.getLblExpense().setText(String.format("$ %.2f", collector.getData()));
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.length;
        }
    }

