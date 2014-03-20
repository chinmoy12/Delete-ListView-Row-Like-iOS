package com.xChinmoy.rowdeletelikeios;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProductsAdapter extends BaseAdapter {
	private ArrayList<String> mProductItems;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public ProductsAdapter(Context context, ArrayList<String> arrayList){
    	mContext = context;
        mProductItems = arrayList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mProductItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.contactlist_item, parent, false);
            holder.txtv_name = (TextView) convertView.findViewById(R.id.txtv_name);
            holder.btn_delete = (Button) convertView.findViewById(R.id.btn_delete);
            holder.btn_delete.setTag(position);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
 
        String stringItem = mProductItems.get(position);
        if (stringItem != null) {
            if (holder.txtv_name != null) {
                holder.txtv_name.setText(stringItem);
            }
        }
        
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Delete " + mProductItems.get((Integer) v.getTag()),Toast.LENGTH_SHORT).show();
			}
		});
        
        return convertView;
	}
	
	private static class ViewHolder {
		TextView txtv_name;
		Button btn_delete;
    }

}
