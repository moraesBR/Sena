package senac.sena;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import senac.sena.adapters.CustomAdapter;
import senac.sena.models.EditModel;

public class MainActivity extends AppCompatActivity {

    TextView tvQJogos;
    EditText etQJogos;
    Button btnJogos;
    Button btnNumeros;
    RecyclerView rvNumeros;
    public ArrayList<EditModel> editModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvQJogos = (TextView)findViewById(R.id.tvQJogos);
        etQJogos = (EditText)findViewById(R.id.etQJogos);

        rvNumeros = (RecyclerView)findViewById(R.id.rvNumeros);

        btnJogos = (Button)findViewById(R.id.btnJogos);
        btnNumeros = (Button)findViewById(R.id.btnNumeros);

        btnNumeros.setVisibility(View.INVISIBLE);
        btnJogos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {

                    int quantidade = Integer.parseInt(etQJogos.getText().toString());
                    if (quantidade <= 0){
                        etQJogos.setError("Faça um ou mais jogos!");
                        throw new Exception("");
                    }
                    editModelArrayList = new ArrayList<>();
                    for(int i=0; i < quantidade; i++) {
                        EditModel t = new EditModel();
                        t.setTextViewValue("Jogo ["+(i+1)+"]");
                        t.setValid(true);
                        editModelArrayList.add(t);
                    }

                    rvNumeros.setAdapter(new CustomAdapter(getBaseContext(),editModelArrayList));
                    rvNumeros.addItemDecoration(new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL));
                    rvNumeros.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));

                    btnNumeros.setVisibility(View.VISIBLE);
                    btnNumeros.setOnClickListener(actionButtonNumeros);
                    /*btnNumeros.setOnClickListener(new View.OnClickListener(){
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
                    });*/
                }
                catch(Exception ex) {
                    Snackbar.make(view, "Erro", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

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
