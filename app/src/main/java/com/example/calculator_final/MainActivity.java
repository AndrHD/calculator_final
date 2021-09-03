package com.example.calculator_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNum1,etNum2;
    TextView tvResult;
    Button btnAdd,btnDiv,btnMult,btnSqrt,btnSub,btnClear ;
    String oper;
    LinearLayout llRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///Находим элементы
        etNum1=(EditText) findViewById(R.id.etNum1);
        etNum2=(EditText) findViewById(R.id.etNum2);
        tvResult=(TextView) findViewById(R.id.tvResult);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnDiv=(Button) findViewById(R.id.btnDiv);
        btnMult=(Button) findViewById(R.id.btnMult);
        btnSqrt=(Button) findViewById(R.id.btnSqrt);
        btnSub=(Button) findViewById(R.id.btnSub);
        btnClear=(Button) findViewById(R.id.btnClear);
        llRes=(LinearLayout) findViewById(R.id.llRes);

        //Пишем обработчик
        btnAdd.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        float num1=0;
        float num2=0;
        float result=0;
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())){
            return;
        }

        num1=Float.parseFloat(etNum1.getText().toString());
        num2=Float.parseFloat(etNum2.getText().toString());


        switch (view.getId()){
            case R.id.btnAdd:
                oper="+";
                result=num1+num2;
                break;
            case R.id.btnSub:
                oper="-";
                result=num1-num2;
                break;
            case R.id.btnMult:
                oper="*";
                result=num1*num2;
                break;
            case R.id.btnDiv:
                oper="/";
                result=num1/num2;
                break;
            case R.id.btnSqrt:
                oper="√";
                result= (float) Math.sqrt(num1);
                break;
           /* case R.id.btnClear:
                tvResult.setText("");
                etNum1.setText("");
                etNum2.setText("");
                num1=0;
                num2=0;
                Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show();
                break;*/
        }

        tvResult.setText(num1+" "+oper+" "+num2+" "+"="+" "+result);

        if (view.getId()==R.id.btnClear){
            tvResult.setText("");

        }


    }




}