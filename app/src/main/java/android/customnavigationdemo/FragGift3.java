package android.customnavigationdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragGift3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragGift3 extends Fragment {
    TextView tvKq3;
    ArrayList<String> arrayListNames = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragGift3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragGift3.
     */
    // TODO: Rename and change types and number of parameters
    public static FragGift3 newInstance(String param1, String param2) {
        FragGift3 fragment = new FragGift3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.setFragmentResultListener("keyM", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String st = result.getString("name");

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_gift3, container, false);
        tvKq3=(TextView) view.findViewById(R.id.tvKq3);


        return view;
    }

    public void docFile() throws IOException {
        InputStream inputStream=getContext().openFileInput("dsten.txt");
        int size = inputStream.available();
        byte []data = new byte[size];
        inputStream.read(data);
        inputStream.read();
        String st = new String(data);
        String []arr=st.split(";;");



    }
    public  void ghiFile()
    {

    }

}