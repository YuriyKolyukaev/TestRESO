package ru.kolyukaev.testreso.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.kolyukaev.testreso.R;
import ru.kolyukaev.testreso.data.model.Office;

public class OfficesAdapter extends RecyclerView.Adapter<OfficesAdapter.OfficeViewHolder> {

    private final List<Office> officesList = new ArrayList<>();
    private OfficeItemListener listener;

    public OfficesAdapter(OfficeItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public OfficeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int officeCell = R.layout.cell_office;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(officeCell, parent, false);
        OfficeViewHolder holder = new OfficeViewHolder(view);
        view.setOnClickListener(v -> {
            listener.itemClick(officesList.get(holder.getAdapterPosition()).getsShortName());
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OfficeViewHolder holder, int position) {
        holder.bind(officesList.get(position));
    }

    @Override
    public int getItemCount() {
        return officesList.size();
    }

    class OfficeViewHolder extends RecyclerView.ViewHolder {
        TextView shortName;
        TextView shortAdress;
        TextView isOpen;
        Context context;

        public OfficeViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            shortName = itemView.findViewById(R.id.tv_short_name);
            shortAdress = itemView.findViewById(R.id.tv_short_adress);
            isOpen = itemView.findViewById(R.id.tv_status);
        }

        void bind(Office office) {
            shortName.setText(office.getsShortName());
            shortAdress.setText(office.getsShortAddress());
            if (office.isOpen()) {
                isOpen.setText(R.string.open_office);
                isOpen.setTextColor(ContextCompat.getColor(context, R.color.green));
            } else {
                isOpen.setText(R.string.close_office);
                isOpen.setTextColor(ContextCompat.getColor(context, R.color.red));
            }
        }
    }

    public void updateAdapter(List<Office> offices) {
        officesList.clear();
        officesList.addAll(offices);
        notifyDataSetChanged();
    }
}
