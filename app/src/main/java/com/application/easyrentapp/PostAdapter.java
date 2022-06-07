package com.application.easyrentapp;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class PostAdapter {

    private Context context;

    public PostAdapter(@NonNull FirebaseRecyclerAdapter<PostModel> options, Context context) {
        super(options);
        this.context = context;

    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, final int position, @NonNull final PostModel model) {

        holder.ALAMAT.setText(model.getALAMAT());
        holder.DAERAH.setText(model.getDAERAH());
        holder.NEGERI.setText(model.getNEGERI());
        holder.CATEGORY.setText(model.getCATEGORY());
        holder.KELENGKAPAN.setText(model.getKELENGKAPAN());
        holder.MAKLUMAT.setText(model.getMAKLUMAT());
        holder.SEWA.setText(model.getSEWA());
        holder.DEPOSIT.setText(model.getDEPOSIT());
        holder.PENDAHULUAN.setText(model.getPENDAHULUAN());
        holder.BILIK.setText(model.getBILIK());
        holder.TANDAS.setText(model.getTANDAS());


        String imageUri = model.getmImageUrl();
        Picasso.get().load(imageUri).into(holder.GambarProgram);
        //delete btn
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().child("iklan")
                        .child(getRef(position).getKey())
                        .removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(context,"Berjaya dipadam",Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });

        //update btn
        holder.Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialog = DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.content))
                        .setExpanded(false)
                        .setContentBackgroundResource(R.drawable.bg_calen)
                        .create();

                View holderView = dialog.getHolderView();
                final EditText alamat =holderView.findViewById(R.id.editalamat);
                final EditText daerah =holderView.findViewById(R.id.editdaerah);
                final EditText negeri =holderView.findViewById(R.id.editnegeri);
                final EditText kelengkapan =holderView.findViewById(R.id.editkelengkapan);
                final EditText category =holderView.findViewById(R.id.editcategory);
                final EditText maklumat =holderView.findViewById(R.id.editmaklumat);
                final EditText deposit =holderView.findViewById(R.id.editdeposit);
                final EditText sewa =holderView.findViewById(R.id.editsewa);
                final EditText pendahuluan =holderView.findViewById(R.id.editpendahuluan);
                final EditText bilik =holderView.findViewById(R.id.editbilik);
                final EditText tandas =holderView.findViewById(R.id.edittandas);

                Button btnUpdate =holderView.findViewById(R.id.btnedit);

                alamat.setText(model.getALAMAT());
                daerah.setText(model.getDAERAH());
                negeri.setText(model.getNEGERI());
                category.setText(model.getCATEGORY());
                kelengkapan.setText(model.getKELENGKAPAN());
                maklumat.setText(model.getMAKLUMAT());
                sewa.setText(model.getSEWA());
                deposit.setText(model.getDEPOSIT());
                pendahuluan.setText(model.getPENDAHULUAN());
                bilik.setText(model.getBILIK());
                tandas.setText(model.getTANDAS());


                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("alamat",alamat.getText().toString());
                        map.put("daerah",daerah.getText().toString());
                        map.put("negeri",negeri.getText().toString());
                        map.put("hariProgram",category.getText().toString());
                        map.put("category",kelengkapan.getText().toString());
                        map.put("maklumat",maklumat.getText().toString());
                        map.put("deposit",deposit.getText().toString());
                        map.put("sewa",sewa.getText().toString());
                        map.put("pendahuluan",pendahuluan.getText().toString());
                        map.put("bilik",bilik.getText().toString());
                        map.put("tandas",tandas.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("iklan")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(context,"Berjaya dikemaskini",Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                });
                    }
                });

                dialog.show();
            }
        });
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.design_row_for_recyclerview,parent,false);

        return new ViewHolder(view);
    }
        public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.design_row_for_recyclerview, parent, false);

            return new RecyclerView.ViewHolder(view);
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView alamat, DAERAH, NEGERI, KELENGKAPAN, CATEGORY, MAKLUMAT, DEPOSIT, SEWA, PENDAHULUAN, BILIK, TANDAS;
            ImageView GambarProgram, Update, Delete;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                ALAMAT = itemView.findViewById(R.id.alamat);
                DAERAH = itemView.findViewById(R.id.daerah);
                NEGERI = itemView.findViewById(R.id.negeri);
                KELENGKAPAN = itemView.findViewById(R.id.kelengkapan);
                CATEGORY = itemView.findViewById(R.id.category);
                MAKLUMAT = itemView.findViewById(R.id.maklumat);
                DEPOSIT = itemView.findViewById(R.id.deposit);
                SEWA = itemView.findViewById(R.id.sewa);
                PENDAHULUAN = itemView.findViewById(R.id.pendahuluan);
                BILIK = itemView.findViewById(R.id.bilik);
                TANDAS = itemView.findViewById(R.id.tandas);
                GambarProgram = itemView.findViewById(R.id.imageprogram);

                Update = itemView.findViewById(R.id.btnedit);
            }
        }

}
