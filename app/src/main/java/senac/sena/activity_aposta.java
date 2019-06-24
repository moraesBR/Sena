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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import senac.sena.adapters.JogosAdapter;
import senac.sena.models.Aposta;
import senac.sena.models.Apostador;

public class activity_aposta extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aposta);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvApostas = findViewById(R.id.rvApostas);

        try{
            Apostador apostador = getIntent().getExtras().getParcelable("apostador");
            ArrayList<String> jogos = new ArrayList<String>();

            for(Aposta aposta: apostador.getApostas())
                jogos.add(aposta.getNumeros().toString());

            for(int i=0; i<jogos.size(); i++)
                System.out.println(jogos.get(i));

            rvApostas.setAdapter(new JogosAdapter(getBaseContext(),jogos));
            rvApostas.addItemDecoration(new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL));
            rvApostas.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));

        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
