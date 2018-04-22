package com.zakaria.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

/**
 * Created by ZAKARIA on 4/18/2018.
 */

public class CalcFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        return view;
    }

    Button btnC;
    Button btnCE;
    Button btnDot;
    Button btnEqual;
    Button btnMinus;
    Button btnNP;
    Button btnPersen;
    Button btnPlus;
    Button btnSlash;
    Button btnX;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    TextView textView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnC = getView().findViewById(R.id.btnC);
        btnCE = getView().findViewById(R.id.btnCe);
        btnDot = getView().findViewById(R.id.btnDot);
        btnEqual = getView().findViewById(R.id.btnEqual);
        btnMinus = getView().findViewById(R.id.btnMinus);
        btnNP = getView().findViewById(R.id.btnNP);
        btnPersen = getView().findViewById(R.id.btnPersen);
        btnPlus = getView().findViewById(R.id.btnPlus);
        btnSlash = getView().findViewById(R.id.btnSlash);
        btnX = getView().findViewById(R.id.btnX);
        btn0 = getView().findViewById(R.id.btn0);
        btn1 = getView().findViewById(R.id.btn1);
        btn2 = getView().findViewById(R.id.btn2);
        btn3 = getView().findViewById(R.id.btn3);
        btn4 = getView().findViewById(R.id.btn4);
        btn5 = getView().findViewById(R.id.btn5);
        btn6 = getView().findViewById(R.id.btn6);
        btn7 = getView().findViewById(R.id.btn7);
        btn8 = getView().findViewById(R.id.btn8);
        btn9 = getView().findViewById(R.id.btn9);
        textView = getView().findViewById(R.id.textView);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString().substring(0, textView.getText().toString().length() - 1));
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("0");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append(btnDot.getText());
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = textView.getText().toString();
                Integer result = 0;
                String[] temp;
                if (code.contains("*")) {
                    temp = code.split(Pattern.quote("*"));
                    result = Integer.valueOf(temp[0].toString()) * Integer.valueOf(temp[1].toString());
                } else if (code.contains("/")) {
                    temp = code.split(Pattern.quote("/"));
                    result = Integer.valueOf(temp[0].toString()) / Integer.valueOf(temp[1].toString());
                } else if (code.contains("+")) {
                    temp = code.split(Pattern.quote("+"));
                    result = Integer.valueOf(temp[0].toString()) + Integer.valueOf(temp[1].toString());
                } else if (code.contains("-")) {
                    temp = code.split(Pattern.quote("-"));
                    result = Integer.valueOf(temp[0].toString()) - Integer.valueOf(temp[1].toString());
                }
                textView.setText("0");

                Bundle bundle = new Bundle();
                bundle.putString("hasil", result.toString());

                ShowFragment showFragment = new ShowFragment();
                showFragment.setArguments(bundle);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_menu,showFragment);
                ft.commit();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append(btnMinus.getText());
            }
        });

        btnNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().toString().contains("-")) {
                    textView.setText(textView.getText().toString().substring(1, textView.getText().length()));
                } else {
                    textView.setText("-" + textView.getText().toString());
                }
            }
        });

        btnPersen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append(btnPlus.getText());
            }
        });

        btnSlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append(btnSlash.getText());
            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append("*");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn0.getText());
                } else {
                    textView.append(btn0.getText());
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn1.getText());
                } else {
                    textView.append(btn1.getText());
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn2.getText());
                } else {
                    textView.append(btn2.getText());
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn3.getText());
                } else {
                    textView.append(btn3.getText());
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn4.getText());
                } else {
                    textView.append(btn4.getText());
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn5.getText());
                } else {
                    textView.append(btn5.getText());
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn6.getText());
                } else {
                    textView.append(btn6.getText());
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn7.getText());
                } else {
                    textView.append(btn7.getText());
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn8.getText());
                } else {
                    textView.append(btn8.getText());
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("0")) {
                    textView.setText(btn9.getText());
                } else {
                    textView.append(btn9.getText());
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
