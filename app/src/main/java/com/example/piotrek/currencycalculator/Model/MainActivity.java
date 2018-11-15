package com.example.piotrek.currencycalculator.Model;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;

        import com.example.piotrek.currencycalculator.R;
        import com.example.piotrek.currencycalculator.controller.Calculator;

        import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 =  (Button) findViewById(R.id.button1);
        final Spinner spinner_from = (Spinner)findViewById(R.id.spinner1);
        final Spinner spinner_to = (Spinner)findViewById(R.id.spinner2);
        final EditText editText = (EditText)findViewById(R.id.editText1);
        final TextView textViewResult= (TextView)findViewById(R.id.textView3);


        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Double amount = Double.parseDouble(editText.getText().toString());;
                int choice; //wybor waluty
                double value;
                String textSpinnerFrom_ = spinner_from.getSelectedItem().toString();
                String textFromSpinnerto_ = spinner_to.getSelectedItem().toString();


                ProviderXML test=new ProviderXML();
                CurrencyCollection list_of_curr = null;
                try {
                    list_of_curr = new CurrencyCollection(test.execute().get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                Currency currencyto =null;
                Currency currencyfrom = null;
                if(textFromSpinnerto_.equals("złoty (Polska)")){
                     currencyto = new Currency("złoty (Polska)",1,"PLN",1);
                }
                if(textSpinnerFrom_.equals("złoty (Polska)")){
                     currencyfrom = new Currency("złoty (Polska)",1,"PLN",1);
                }
                if (!textSpinnerFrom_.equals("złoty (Polska)")){
                     currencyfrom = list_of_curr.getCurrencyByName(textSpinnerFrom_);
                }
                if (!textFromSpinnerto_.equals("złoty (Polska)")){
                     currencyto = list_of_curr.getCurrencyByName(textFromSpinnerto_);
                }

                Calculator calculator = new Calculator();
                value = calculator.count(currencyfrom,currencyto,amount);
                textViewResult.setText(Double.toString(value));

            }
        });
    }


}
