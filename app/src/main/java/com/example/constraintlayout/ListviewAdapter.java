package com.example.constraintlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;

    private ArrayList<ClassNama> arrayList;


    @Override
    public int getCount() {
        return Homee.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Homee.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view==null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, null);
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(Homee.classNamaArrayList.get(i).getName());
        return view;
    }
    public ListviewAdapter (Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);

        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(Homee.classNamaArrayList);
    }
    public class ViewHolder{
        TextView name;
    }
}