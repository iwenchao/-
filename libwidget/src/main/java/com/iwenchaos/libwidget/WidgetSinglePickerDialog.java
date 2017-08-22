package com.iwenchaos.libwidget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by chaos on 17-8-22.
 */

public class WidgetSinglePickerDialog extends AbstractWidgetFragDialog {


    TextView mTitle;
    RecyclerView mRecyclerView;

    private String[] mNames = new String[] {
            "我是条目1", "我是条目2", "我是条目3", "我是条目4", "我是条目5","我是条目6","我是条目7"
    };


    private ArrayList<StyleItem> mList = new ArrayList<>();

    private StyleAdapter mAdapter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.dialog_single_select_layout,container,false);

        mTitle =  view.findViewById(R.id.dialog_title);
        mRecyclerView = view.findViewById(R.id.dialog_optionViews);
        initData();
        return view;
    }

    private void initData() {
        // 填充数据集合
        for (int i = 0; i < mNames.length; i++) {
            StyleItem styleItem = new StyleItem(mNames[i]);
            mList.add(styleItem);
        }
        mAdapter = new StyleAdapter(getContext(), mList);
        mRecyclerView.setAdapter(mAdapter);
    }


    class StyleItem {

        String mName;

        public StyleItem(String mName) {
            this.mName = mName;
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }
    }


     class StyleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private Context mContext;

        private ArrayList<StyleItem> mList;

        public StyleAdapter(Context context, ArrayList<StyleItem> list) {
            mContext = context;
            mList = list;
        }

         @Override
         public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             LocalHolder localHolder = new LocalHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_layout,parent,false));
             return localHolder;
         }

         @Override
         public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
             LocalHolder localHolder = (LocalHolder) holder;

             StyleItem item = mList.get(position);
             localHolder.tvName.setText(item.mName);
         }

         @Override
         public int getItemCount() {
             return mList.size();
         }

         class LocalHolder extends RecyclerView.ViewHolder{
            TextView tvName;

             public LocalHolder(View itemView) {
                 super(itemView);
                 initView(itemView);
             }

             private void initView(View itemView){
                 tvName = itemView.findViewById(R.id.item_dialog_text);
             }
         }
    }

}
