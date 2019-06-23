package senac.sena.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import senac.sena.R;
import senac.sena.models.EditModel;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    public static ArrayList<EditModel> editModelArrayList;

    public CustomAdapter(Context context, ArrayList<EditModel> editModelArrayList) {
        inflater = LayoutInflater.from(context);
        this.editModelArrayList = editModelArrayList;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.item_tvnumeros, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.MyViewHolder holder, final int position){
        EditModel dado = editModelArrayList.get(position);
        holder.textView.setText(dado.getTextViewValue());
        holder.textView.setHint("Quantos Números?");
        holder.editText.setText(dado.getEditTextValue());
    }

    @Override
    public int getItemCount(){
        return editModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        protected EditText editText;
        protected TextView textView;

        public MyViewHolder(View itemView){
            super(itemView);

            editText = (EditText) itemView.findViewById(R.id.etQNumeros);
            textView = (TextView) itemView.findViewById(R.id.tvQNumeros);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(!editText.getText().toString().equals("")) {
                        int num = Integer.parseInt(editText.getText().toString());
                        if (num < 6 || num > 15) {
                            editText.setError("Faça jogos com a quantidade de números entre 6 e 15");
                            editModelArrayList.get(getAdapterPosition()).setValid(false);
                        }else {
                            editModelArrayList.get(getAdapterPosition()).setEditTextValue(editText.getText().toString());
                            editModelArrayList.get(getAdapterPosition()).setValid(true);
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }
}
