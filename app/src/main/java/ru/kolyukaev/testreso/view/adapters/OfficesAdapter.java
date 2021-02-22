package ru.kolyukaev.testreso.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.kolyukaev.testreso.R;
import ru.kolyukaev.testreso.data.model.Office;

public class OfficesAdapter extends RecyclerView.Adapter<OfficesAdapter.OfficeViewHolder> {

    public List<Office> officesList = new ArrayList<>();

    @NonNull
    @Override
    public OfficeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int officeCell = R.layout.cell_office;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(officeCell, parent, false);
        return new OfficeViewHolder(view);
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

        public OfficeViewHolder(@NonNull View itemView) {
            super(itemView);

            shortName = itemView.findViewById(R.id.tv_short_name);
            shortAdress = itemView.findViewById(R.id.tv_short_adress);
            isOpen = itemView.findViewById(R.id.tv_status);
        }

        void bind(Office office) {
            shortName.setText(office.getsShortName());
            shortAdress.setText(office.getsShortAddress());
            if (office.isOpen()) {
                isOpen.setText(R.string.true_);
            } else {
                isOpen.setText(R.string.false_);
            }
        }
    }

    public void updateAdapter(List<Office> offices) {
        officesList.clear();
        officesList.addAll(offices);
        notifyDataSetChanged();
    }
}
