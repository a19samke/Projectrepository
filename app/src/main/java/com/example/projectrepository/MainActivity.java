package com.example.projectrepository;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.projectrepository.R.id.image;
import static com.example.projectrepository.R.id.viwer;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private static final String TAG = "MAINACTIVITY";
    ArrayList<News> items;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        adapter = new ArrayAdapter<>( this,R.layout.second,items);
        final ListView view = findViewById(R.id.list_view);
        view.setAdapter(adapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = items.get(position);
                String Messeg = "The Id for the News is " + news.getID() + "\n"+
                        " And the  name is " + news.getName() + "\n"+
                        "And we are located in " + news.getLocation() + "\n"+
                        " The prise for the news is  " + news.getCost() + "$";

               /*Intent intent = new Intent(MainActivity.this, button.class);
                intent.putExtra( "cost", news.getname() );
                intent.putExtra( "Locatin", news.getLocation() );
                intent.putExtra( "cost", news.getCost() );
                startActivity(intent);*/
                Toast.makeText(MainActivity.this, Messeg,Toast.LENGTH_LONG).show();


            }

        });
        new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=a19samke");

    }

    public void displayToast(View view) {
        Toast.makeText( MainActivity.this," About As " + "\n" +
                "\n"
                +"Le Lorem Ipsum est simplement " +"\n"+
                "du faux texte employé dans la composition et la mise en page avant impression\n" +
                "\n"+
                "du faux texte employé dans la composition et \n" +
               "\n" +
                " Kontact"+
                "\n" +
                "AB News\n" +
                "Box 3000\n" +
                "541 50 SKÖVDE\n" +
                "\n" +
                "Bobutikens besöksadress:\n" +
                "Drottninggatan 6A\n" +
                "\n" +
                "Telefon: 0800-47 72 00", Toast.LENGTH_LONG ).show();
    }

    public void displayToas(View view) {
        Toast.makeText( MainActivity.this," News Programs " + "\n" +
                "\n"
                +"Welcome to " +"\n"+
                "du faux texte employé dans la composition et la mise en page avant impression\n" +
                "\n"+
                "Evning News" +"\n"+
                "\n"+
                "Morning news \n" +
                "\n"+
                "History \n" +
                "\n"+
                "About the World", Toast.LENGTH_LONG ).show();
    }



    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {

        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {

            try {
                items.clear();
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i <jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String ID = jsonObject.getString("ID");
                    String name = jsonObject.getString("name");
                    String type = jsonObject.getString("type");
                    String company = jsonObject.getString("company");
                    String location = jsonObject.getString("location");
                    String auxdata = jsonObject.getString("auxdata");
                    int cost = jsonObject.getInt("cost");
                    News news = new News( ID, name, type, company, location, auxdata, cost);

                    items.add(news);
                }

                adapter.notifyDataSetChanged();


            } catch (JSONException e) {
                Log.d(TAG, "KUNDE inte parsa" + json + "\n do to caption" + e);
            }

        }
    }
}