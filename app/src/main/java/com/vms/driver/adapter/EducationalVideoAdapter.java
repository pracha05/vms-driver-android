package com.vms.driver.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vms.driver.R;
import com.vms.driver.activities.EducationalVideoActivity;
import com.vms.driver.model.EducationalVideoPojo;

import java.util.ArrayList;
import java.util.List;

public class EducationalVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    EducationalVideoActivity context;
    EducationalVideoPojo data;
    List<EducationalVideoPojo.EduVideo> myList = new ArrayList();

    public class MYViewHolder extends RecyclerView.ViewHolder {
        Button btn_vieweduvid;
        TextView tv_eduvideo_name;

        public MYViewHolder(View itemView) {
            super(itemView);
            this.btn_vieweduvid = (Button) itemView.findViewById(R.id.btn_vieweduvid);
            this.tv_eduvideo_name = (TextView) itemView.findViewById(R.id.tv_eduvideo_name);
        }
    }

    public EducationalVideoAdapter(EducationalVideoActivity context2, EducationalVideoPojo data2) {
        this.myList.addAll(data2.eduVideo);
        this.context = context2;
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MYViewHolder(LayoutInflater.from(this.context).inflate(R.layout.eduvideolayout, parent, false));
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MYViewHolder) {
            MYViewHolder myViewHolder = (MYViewHolder) holder;
            myViewHolder.tv_eduvideo_name.setText(((EducationalVideoPojo.EduVideo) this.myList.get(position)).videoname);
            myViewHolder.btn_vieweduvid.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((EducationalVideoPojo.EduVideo) EducationalVideoAdapter.this.myList.get(position)).videolonk));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage("com.google.android.youtube");
                    EducationalVideoAdapter.this.context.startActivity(intent);
                }
            });
        }
    }

    public int getItemCount() {
        return this.myList.size();
    }
}

