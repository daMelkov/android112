package com.astra.melkovhw112;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DesignAdapter extends BaseAdapter {
    private final DesignAdapter adapter = this;
    private Context context;
    private LayoutInflater inflater;
    private List<Design> design;

    public DesignAdapter(Context context, List<Design> design) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.design = design;
    }

    @Override
    public int getCount() {
        return design.size();
    }

    @Override
    public Design getItem(int i) {
        return design.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        final Design item = getItem(position);

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context, item.toString(), Toast.LENGTH_LONG).show();

                return false;
            }
        });

        /* header */
        TextView txtHeader = convertView.findViewById(R.id.header);
        txtHeader.setText(item.getHeader());

        /* content */
        TextView txtContent = convertView.findViewById(R.id.content);
        txtContent.setText(item.getContent());

        /* delete */
        Button btnDelete = convertView.findViewById(R.id.delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                design.remove(item);
                adapter.notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
