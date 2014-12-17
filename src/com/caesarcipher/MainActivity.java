package com.caesarcipher;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText text = (EditText) findViewById(R.id.editText3);
		final EditText key = (EditText) findViewById(R.id.editText4);
		final TextView r = (TextView) findViewById(R.id.textView6);
		
		
		final EditText textC = (EditText) findViewById(R.id.editText1);
		final EditText keyC = (EditText) findViewById(R.id.editText2);
		final TextView rC = (TextView) findViewById(R.id.textView3);
		
		 final Button cod = (Button) findViewById(R.id.button2);
         cod.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 int m = key.getText().toString().length();
            	 int n = text.getText().toString().length();
            	 if(n!= 0 && m!= 0){
            		 String result = caesar(text.getText().toString(), Integer.parseInt(key.getText().toString()));
            		 r.setText(result);
            	 }else{
            		 Toast toast = Toast.makeText(getApplicationContext(), "You must insert a Password and a key", Toast.LENGTH_SHORT);
            		 toast.show();
            	 }
   
             }
         });
         
         final Button dec = (Button) findViewById(R.id.button1);
         dec.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 int m = keyC.getText().toString().length();
            	 int n = textC.getText().toString().length();
            	 if(n!=0 && m !=0){
            		 String result = caesarDec(textC.getText().toString(), Integer.parseInt(keyC.getText().toString()));
            		 rC.setText(result);
            	 }else{
            		 Toast toast = Toast.makeText(getApplicationContext(), "You must insert a chiper code and a key", Toast.LENGTH_SHORT);
            		 toast.show();
            	 }
   
             }
         });
		
	}
	
	
	static String caesar(String value, int shift) {
		
		value = value.trim();
		
		char[] buffer = value.toCharArray();
		for (int i = 0; i < buffer.length; i++) {

		    char letter = buffer[i];
		    
		    if(Character.isLetter(letter)){
		    	letter = (char) (letter + shift);
		    	
		    	if(Character.isUpperCase(letter)){
		    		if (letter > 'Z') {
			    		letter = (char) (letter - 26);
			    	} else if (letter < 'A') {
			    		letter = (char) (letter + 26);
			    	}
		    	}else{
			    	if (letter > 'z') {
			    		letter = (char) (letter - 26);
			    	} else if (letter < 'a') {
			    		letter = (char) (letter + 26);
			    	}
		    	}
		    }else if(Character.isDigit(letter)){
		    	letter = (char) (letter + shift);
		    	if (letter > '9') {
		    		letter = (char) (letter - 10);
		    	} else if (letter < '0') {
		    		letter = (char) (letter + 10);
		    	}
		    }else{
		    	letter = buffer[i];
		    }
		    
		    buffer[i] = letter;
		}
		
		return new String(buffer);
	}
	
	
	static String caesarDec(String value, int shift) {
		
		value = value.trim();
		
		char[] buffer = value.toCharArray();
		for (int i = 0; i < buffer.length; i++) {

		    char letter = buffer[i];
		    
		    if(Character.isLetter(letter)){
		    	letter = (char) (letter - shift);
		    	
		    	if(Character.isUpperCase(letter)){
		    		if (letter > 'Z') {
			    		letter = (char) (letter - 26);
			    	} else if (letter < 'A') {
			    		letter = (char) (letter + 26);
			    	}
		    	}else{
			    	if (letter > 'z') {
			    		letter = (char) (letter - 26);
			    	} else if (letter < 'a') {
			    		letter = (char) (letter + 26);
			    	}
		    	}
		    }else if(Character.isDigit(letter)){
		    	letter = (char) (letter - shift);
		    	if (letter > '9') {
		    		letter = (char) (letter - 10);
		    	} else if (letter < '0') {
		    		letter = (char) (letter + 10);
		    	}
		    }else{
		    	letter = buffer[i];
		    }
		    
		    buffer[i] = letter;
		}
		
		return new String(buffer);
	 }

	
}
