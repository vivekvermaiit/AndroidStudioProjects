package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        displayPrice(quantity*5);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6, -122.3"));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }


    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        CheckBox x = (CheckBox)findViewById(R.id.notify_me_checkbox);
        boolean check = x.isChecked();
        CheckBox chocolate = (CheckBox)findViewById(R.id.chocolate);
        boolean chocolatechecked=chocolate.isChecked();
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        EditText editText = (EditText) findViewById(R.id.name);
        String text=editText.getText().toString();

        if (check)number += 1 ;
        if (chocolatechecked) number+=2;
        String message= "Name: "+ text;
        message = message + "\nAdd whipped cream? " + check;
        message = message + "\nAdd chocolate? " + chocolatechecked;
        message = message + "\nQuantity: "+ quantity;
        message = message + "\nTotal: "+ NumberFormat.getCurrencyInstance().format(number);
        message = message + "\nThank you!";
//        priceTextView.setText(message);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"vivek.verma@flipkart.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void decrement(View view) {
        if (quantity>1) {quantity-=1;}
        display(quantity);
    }

    public void increment(View view) {
        if (quantity<100) quantity+=1;
        display(quantity);
    }
}
