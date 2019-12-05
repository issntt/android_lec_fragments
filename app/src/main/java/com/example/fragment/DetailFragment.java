package com.example.fragment;


import android.content.Context;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fragment.data.DataItem;
import com.example.fragment.data.DataService;

import org.w3c.dom.Text;

public class DetailFragment extends Fragment {
    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layoutRoot = inflater.inflate(R.layout.fragment_detail,
                container, false);

        return layoutRoot;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private int itemId;
    public void setItem(int itemId) {
        this.itemId = itemId;
    }

    public interface IDetailFragment {
        void itemClicked(String content);
    }

    private IDetailFragment iDetailFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iDetailFragment = (IDetailFragment) context;
    }

    public void sendDataToActivity(String content) {
        iDetailFragment.itemClicked(content);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if (view != null) {
            DataItem item = DataService.getItem(itemId);

            TextView title = (TextView) view.findViewById(R.id.textTitle);
            title.setText(item.getName());

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    sendDataToActivity(textView.getText().toString());
                }
            });

            TextView desc = (TextView) view.findViewById(R.id.textDescription);
            desc.setText(item.getDescription());
            desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    sendDataToActivity(textView.getText().toString());
                }
            });
        }
    }
}
