package senac.sena.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import senac.sena.R;

public class JogosAdapter extends RecyclerView.Adapter<JogosAdapter.JogosViewHolder> {

    private LayoutInflater inflater;
    public static ArrayList<String> jogosArrayList;

    public JogosAdapter(Context context, ArrayList<String> jogosArrayList) {
        inflater = LayoutInflater.from(context);
        this.jogosArrayList = jogosArrayList;
    }

    @NonNull
    @Override
    public JogosAdapter.JogosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.item_tvapostas, parent, false);
        JogosAdapter.JogosViewHolder holder = new JogosAdapter.JogosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final JogosAdapter.JogosViewHolder holder, final int position){
        String msg = "Jogo ["+(position+1)+"]:  ";
        System.out.println(jogosArrayList.get(position));
        holder.tvJogo.setText(jogosArrayList.get(position));
        holder.tvAposta.setText(msg);
    }

    @Override
    public int getItemCount(){
        return jogosArrayList.size();
    }

    class JogosViewHolder extends RecyclerView.ViewHolder{
        protected TextView tvAposta;
        protected TextView tvJogo;

        public JogosViewHolder(View itemView){
            super(itemView);

            tvAposta = (TextView) itemView.findViewById(R.id.tvAposta);
            tvJogo = (TextView) itemView.findViewById(R.id.tvJogo);
        }
    }
}
