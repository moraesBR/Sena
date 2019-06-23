package senac.sena;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import senac.sena.adapters.CustomAdapter;
import senac.sena.models.EditModel;

public class MainActivity extends AppCompatActivity {

    TextView tvQJogos;
    EditText etQJogos;
    //Button btnJogos;
    Button btnNumeros;
    RecyclerView rvNumeros;
    public ArrayList<EditModel> editModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvQJogos   = findViewById(R.id.tvQJogos);
        etQJogos   = findViewById(R.id.etQJogos);
        rvNumeros  = findViewById(R.id.rvNumeros);
        btnNumeros = findViewById(R.id.btnNumeros);
        btnNumeros.setVisibility(View.INVISIBLE);
        etQJogos.addTextChangedListener(textWatcherJogos);
    }

    TextWatcher textWatcherJogos = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try{
                int quantidade = Integer.parseInt(etQJogos.getText().toString());
                if (quantidade <= 0) throw new Exception("");

                editModelArrayList = new ArrayList<>();
                for(int j=0; j < quantidade; j++) {
                    EditModel t = new EditModel();
                    t.setTextViewValue("Jogo ["+(j+1)+"]: ");
                    t.setValid(true);
                    editModelArrayList.add(t);
                }

                rvNumeros.setVisibility(View.VISIBLE);
                btnNumeros.setVisibility(View.VISIBLE);

                rvNumeros.setAdapter(new CustomAdapter(getBaseContext(),editModelArrayList));
                rvNumeros.addItemDecoration(new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL));
                rvNumeros.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));

                btnNumeros.setOnClickListener(actionButtonNumeros);
            }
            catch (Exception ex){
                etQJogos.setError("Faça um ou mais jogos!");
                rvNumeros.setVisibility(View.INVISIBLE);
                btnNumeros.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    View.OnClickListener actionButtonNumeros = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            try{
                for (EditModel e: editModelArrayList){
                    int num = Integer.parseInt(e.getEditTextValue());
                    if(!e.isValid()) throw new Exception("");
                }
            }
            catch(Exception ex){
                Snackbar.make(view, "Erro!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        }
    };
}
