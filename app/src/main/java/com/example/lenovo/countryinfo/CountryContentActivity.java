package com.example.lenovo.countryinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryContentActivity extends AppCompatActivity implements Fragment_Regions.Fragment_Regions_Listener {

    String name, mregion;
    ArrayList<String> data;
    CountryContentAdapter adapter;
    ListView content_list;
    API_Interafce service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_content);
      /*  country_capital = (TextView) findViewById(R.id.textview_Country_capital);
        country_name = (TextView) findViewById(R.id.textview_Country_name);
        country_region = (TextView) findViewById(R.id.textview_Country_region);
        country_population = (TextView) findViewById(R.id.textview_Country_population);
        country_altspellings = (TextView) findViewById(R.id.textview_Country_altspellings);*/

        content_list = (ListView) findViewById(R.id.listview_country_content);
        data = new ArrayList<>();
        adapter = new CountryContentAdapter(this, data);
        content_list.setAdapter(adapter);
        name = getIntent().getStringExtra("CountryValue");
        mregion = getIntent().getStringExtra("IsRegion");
        String code = getIntent().getStringExtra("Code");

        service = Client.getService();


        Log.i("----", name + "");
        if(code.compareTo("name")==0) {

            Call<ArrayList<ContentResponse>> call = service.getdetails(name);
            call.enqueue(new Callback<ArrayList<ContentResponse>>() {
                @Override
                public void onResponse(Call<ArrayList<ContentResponse>> call, Response<ArrayList<ContentResponse>> response) {
                    ArrayList<ContentResponse> al = response.body();
                    data.add(Constants.country_name_index, "Country Name: " + al.get(0).getCountry_name());
                    data.add(Constants.country_capital_index, "Capital: " + al.get(0).getCountry_capital());
                    data.add(Constants.country_region_index, "Region: " + al.get(0).getCountry_region());
                    data.add(Constants.country_population_index, "Population: " + al.get(0).getCountry_population());
                    data.add(Constants.country_timezone , "TimeZone: "+ al.get(0).getTimeZone() );


                    adapter.notifyDataSetChanged();

                }


                @Override
                public void onFailure(Call<ArrayList<ContentResponse>> call, Throwable t) {
                    Toast.makeText(CountryContentActivity.this, "Invalid Country Name", Toast.LENGTH_SHORT).show();
                    Log.i("----", t.getMessage() + "");
                }
            });

        }else if(code.compareTo("code")==0) {

            Call<ContentResponse> call2 = service.getdetails_via_code(name);
            call2.enqueue(new Callback<ContentResponse>() {
                @Override
                public void onResponse(Call<ContentResponse> call, Response<ContentResponse> response) {
                    if (response.isSuccessful()) {
                        Log.i("----", "Response Entered");
                        ContentResponse c = response.body();
                        data.add(Constants.country_name_index, "Country Name: " + c.getCountry_name());
                        data.add(Constants.country_capital_index, "Capital: " + c.getCountry_capital());
                        data.add(Constants.country_region_index, "Region: " + c.getCountry_region());
                        data.add(Constants.country_population_index, "Population: " + c.getCountry_population());
                        data.add(Constants.country_timezone , "TimeZone: "+ c.getTimeZone() );


                        adapter.notifyDataSetChanged();
                    }
                }
                    @Override
                    public void onFailure (Call < ContentResponse > call, Throwable t){
                        Toast.makeText(CountryContentActivity.this, "Invalid Country Code", Toast.LENGTH_SHORT).show();
                        Log.i("----", t.getMessage() + "");

                    }

            });
        }

else if(code.compareTo("language")==0) {

            Call<ArrayList<ContentResponse>> call3 = service.getdetails_via_language(name);
            call3.enqueue(new Callback<ArrayList<ContentResponse>>() {
                @Override
                public void onResponse(Call<ArrayList<ContentResponse>> call, Response<ArrayList<ContentResponse>> response) {
                    ArrayList<ContentResponse> al = response.body();
                    data.add(Constants.country_name_index, "Country Name: " + al.get(0).getCountry_name());
                    data.add(Constants.country_capital_index, "Capital: " + al.get(0).getCountry_capital());
                    data.add(Constants.country_region_index, "Region: " + al.get(0).getCountry_region());
                    data.add(Constants.country_population_index, "Population: " + al.get(0).getCountry_population());
                    data.add(Constants.country_timezone , "TimeZone: "+ al.get(0).getTimeZone() );


                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<ArrayList<ContentResponse>> call, Throwable t) {

                }
            });
        }    else if(code.compareTo("currency")==0) {

            Call<ArrayList<ContentResponse>> call4 = service.getdetails_via_currency(name);
            call4.enqueue(new Callback<ArrayList<ContentResponse>>() {
                @Override
                public void onResponse(Call<ArrayList<ContentResponse>> call, Response<ArrayList<ContentResponse>> response) {
                    ArrayList<ContentResponse> al = response.body();
                    data.add(Constants.country_name_index, "Country Name: " + al.get(0).getCountry_name());
                    data.add(Constants.country_capital_index, "Capital: " + al.get(0).getCountry_capital());
                    data.add(Constants.country_region_index, "Region: " + al.get(0).getCountry_region());
                    data.add(Constants.country_population_index, "Population: " + al.get(0).getCountry_population());
                    data.add(Constants.country_timezone , "TimeZone: "+ al.get(0).getTimeZone() );


                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<ArrayList<ContentResponse>> call, Throwable t) {

                }
            });
        }


        }
      /*  call.enqueue(new Callback<ArrayList<ContentResponse>>() {
            @Override
            public void onResponse(Call<ContentResponse> call, Response<ContentResponse> response) {
                
            }

            @Override
            public void onFailure(Call<ContentResponse> call, Throwable t) {
                Log.i("----",t.getMessage());
                 country_capital.setText("Unbale to fetch Capital");
            }
        });*/




    @Override
    public void regionClicked(String name) {
        Log.i("----", "Yes Its a Region");
        Call<ArrayList<ContentResponse>> call_region = service.getdetails_via_region(name);
        call_region.enqueue(new Callback<ArrayList<ContentResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ContentResponse>> call, Response<ArrayList<ContentResponse>> response) {
                ArrayList<ContentResponse> al = response.body();
                for (int i = 0; i <= al.size(); i++) {
                    data.add(i, "Country Name: " + al.get(i).getCountry_name());
                    Log.i("----", al.get(i).Country_name + "");
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ArrayList<ContentResponse>> call, Throwable t) {
                Log.i("----","Couldnot fetch data");
            }

        });

    }

}


