package com.example.capdi_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adspin1, adspin2, adspin3; //어댑터 선언
    String choice_high_dg="";
    String choice_middle_hb="";
    String choice_low_hg="";
    private TextView text_hg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spin1 = (Spinner)findViewById(R.id.spinner1);
        final Spinner spin2 = (Spinner)findViewById(R.id.spinner2);
        final Spinner spin3 = (Spinner)findViewById(R.id.spinner3);
        text_hg = (TextView)findViewById(R.id.text_hg);

        adspin1 = ArrayAdapter.createFromResource(this, R.array.high_dg, R.layout.support_simple_spinner_dropdown_item  );
        adspin1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);
        spin1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (adspin1.getItem(position).equals("스마트창의융합대학")){
                    choice_high_dg = "스마트창의융합대학";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.middle_smart_hb, R.layout.support_simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView1, View view, int position, long id) {
                            if(adspin2.getItem(position).equals("ICT융합공학부")){
                                choice_middle_hb = "ICT융합공학부";
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.low_ict_hg, R.layout.support_simple_spinner_dropdown_item);
                                adspin3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                                spin3.setAdapter(adspin3);
                                spin3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView2, View view, int position, long id) {
                                        choice_low_hg = adspin3.getItem(position).toString();
                                        //ListView에 해당 학과 졸작이 쭉 뜨면 됨.
                                        text_hg.setText(adapterView2.getItemAtPosition(position).toString());
                                    }
                                });
                            } else if (adspin2.getItem(position).equals("디자인발명학부")){
                                choice_middle_hb = "디자인발명학부";
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.low_design_hg, R.layout.support_simple_spinner_dropdown_item);
                                adspin3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                                spin3.setAdapter(adspin3);
                                spin3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView2, View view, int position, long id) {
                                        choice_low_hg = adspin3.getItem(position).toString();
                                        //ListView에 해당 학과 졸작이 쭉 뜨면 됨.
                                    }
                                });
                            } else if (adspin2.getItem(position).equals("도시환경바이오공학부")){
                                choice_middle_hb = "도시환경바이오공학부";
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.low_citybio_hg, R.layout.support_simple_spinner_dropdown_item);
                                adspin3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                                spin3.setAdapter(adspin3);
                                spin3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        choice_low_hg = adspin3.getItem(position).toString();
                                        //ListView에 해당 학과 졸작이 쭉 뜨면 됨.
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }
}