package com.application.easyrentapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;

public class AdsCreateActivity extends AppCompatActivity {


    ImageButton imageButton;
    EditText alamat, daerah, negeri, deposit, sewa, pendahuluan, maklumat;
    Button btnadd,backbtn;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    StorageReference mStorage;
    ProgressDialog mprogress;
    DatePickerDialog.OnDateSetListener setListener;

    Spinner kelengkapanSpinner, categorySpinner, bilikSpinner, tandasSpinner;

    private static final int Gallery_Code =1;
    private Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_create);

        //hooks
        alamat = findViewById(R.id.txtalamat);
        daerah = findViewById(R.id.txtdaerah);
        negeri = findViewById(R.id.txtnegeri);
        categorySpinner = findViewById(R.id.txtcategory);
        kelengkapanSpinner = findViewById(R.id.txtkelengkapan);
        maklumat = findViewById(R.id.txtmaklumat);
        deposit =findViewById(R.id.txtdeposit);
        sewa =findViewById(R.id.txtsewa);
        pendahuluan =findViewById(R.id.txtpendahuluan);
        bilikSpinner =findViewById(R.id.txtbilik);
        tandasSpinner =findViewById(R.id.txttandas);

        mprogress = new ProgressDialog(this);

        //button
        btnadd = findViewById(R.id.btnsave);
        backbtn= findViewById(R.id.btncancel);
        mDatabase = FirebaseDatabase.getInstance();
        mRef =mDatabase.getReference().child("program");
        mStorage = FirebaseStorage.getInstance().getReference("Program");


        //spinner uni
        ArrayAdapter<String> CategoryAdapter = new ArrayAdapter<String>(AdsCreateActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.category_list));
        CategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(CategoryAdapter);

        //spinner uni
        ArrayAdapter<String> KelengkapanAdapter = new ArrayAdapter<String>(AdsCreateActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.kelengkapan_list));
        KelengkapanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kelengkapanSpinner.setAdapter(KelengkapanAdapter);

        //spinner uni
        ArrayAdapter<String> BilikAdapter = new ArrayAdapter<String>(AdsCreateActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.bilik_list));
        BilikAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bilikSpinner.setAdapter(BilikAdapter);

        //spinner uni
        ArrayAdapter<String> TandasAdapter = new ArrayAdapter<String>(AdsCreateActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.tandas_list));
        TandasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tandasSpinner.setAdapter(TandasAdapter);



        //image button
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,Gallery_Code);
            }
        });


        //back btn
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdsCreateActivity.this,RecyclerViewList.class);
                startActivity(i);
            }
        });
    }


    //get uri file extension
    private String GetFileExtension(Uri uri) {

        ContentResolver cR = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cR.getType(uri));
    }



    //pick image in gallery
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Gallery_Code && resultCode == RESULT_OK) {
            imageUri = data.getData();
            imageButton.setImageURI(imageUri);
        }


        //add into firebase
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Alamat = alamat.getText().toString().trim();
                final String Daerah = daerah.getText().toString().trim();
                final String Negeri = negeri.getText().toString().trim();
                final String Category = categorySpinner.getSelectedItem().toString();
                final String Kelengkapan = kelengkapanSpinner.getSelectedItem().toString();
                final String Maklumat = maklumat.getText().toString().trim();
                final String Deposit = deposit.getText().toString().trim();
                final String Sewa = sewa.getText().toString().trim();
                final String Pendahuluan = pendahuluan.getText().toString().trim();
                final String Bilik = bilikSpinner.getSelectedItem().toString();
                final String Tandas = tandasSpinner.getSelectedItem().toString();



                //if gambar tidak dipilih
                if (imageUri == null){
                    Toast.makeText(AdsCreateActivity.this,"Sila pilih gambar program",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if ruangan tidak diisi
                if (TextUtils.isEmpty(Alamat)  ) {
                    alamat.setError("Ruangan ini tidak diisi");
                    Toast.makeText(AdsCreateActivity.this,"Nama program tidak diisi",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if ruangan tidak diisi
                if (TextUtils.isEmpty(Daerah)) {
                    daerah.setError("Ruangan ini tidak diisi");
                    Toast.makeText(AdsCreateActivity.this,"tidak diisi",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if ruangan tidak diisi
                if (TextUtils.isEmpty(Negeri)) {
                    negeri.setError("Ruangan ini tidak diisi");
                    Toast.makeText(AdsCreateActivity.this,"tidak diisi",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if ruangan tidak diisi
                if (TextUtils.isEmpty(Maklumat)) {
                    maklumat.setError("Ruangan ini tidak diisi");
                    Toast.makeText(AdsCreateActivity.this,"tidak diisi",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if hari program tk select
                if(Kelengkapan.equals("Pilih Kelengkapan")){
                    Toast.makeText(AdsCreateActivity.this,"Sila pilih",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if hari program tk select
                if(Category.equals("Pilih Jenis Kediaman")){
                    Toast.makeText(AdsCreateActivity.this,"Sila pilih",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if ruangan tidak diisi
                if (TextUtils.isEmpty(Deposit)) {
                    deposit.setError("Ruangan ini tidak diisi");
                    Toast.makeText(AdsCreateActivity.this,"Tarikh program tidak diisi",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if ruangan tidak diisi
                if (TextUtils.isEmpty(Sewa)) {
                    sewa.setError("Ruangan ini tidak diisi");
                    Toast.makeText(AdsCreateActivity.this,"Masa Program tidak diisi",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if ruangan tidak diisi
                if (TextUtils.isEmpty(Pendahuluan)) {
                    pendahuluan.setError("Ruangan ini tidak diisi");
                    Toast.makeText(AdsCreateActivity.this,"Masa Program tidak diisi",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if hari program tk select
                if(Bilik.equals("Pilih Bilik")){
                    Toast.makeText(AdsCreateActivity.this,"Sila pilih",Toast.LENGTH_SHORT).show();
                    return;
                }

                //if hari program tk select
                if(Tandas.equals("Pilih tandas")){
                    Toast.makeText(AdsCreateActivity.this,"Sila pilih",Toast.LENGTH_SHORT).show();
                    return;
                }


                //if ruangan sudah diisi
                if(!Alamat.isEmpty() && !Daerah.isEmpty() && !Negeri.isEmpty() && !Kelengkapan.isEmpty()
                        && !Category.isEmpty() && !Deposit.isEmpty() && !Sewa.isEmpty()
                        && !Pendahuluan.isEmpty() && !Bilik.isEmpty() && !Tandas.isEmpty()
                        && imageUri!= null )
                {
                    mprogress.setMessage("Sedang dimuatnaik..");
                    mprogress.show();

                    StorageReference filepath = mStorage.child(System.currentTimeMillis() + "." +
                            GetFileExtension(imageUri));
                    filepath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    Intent intent = new Intent(AdsCreateActivity.this,RecyclerViewList.class);
                                    String t =task.getResult().toString();
                                    DatabaseReference newPost = mRef.push();
                                    newPost.child("Alamat").setValue(Alamat);
                                    newPost.child("Daerah").setValue(Daerah);
                                    newPost.child("Negeri").setValue(Negeri);
                                    newPost.child("Kelengkapan").setValue(Kelengkapan);
                                    newPost.child("Kategori").setValue(Category);
                                    newPost.child("Maklumat").setValue(Maklumat);
                                    newPost.child("Deposit").setValue(Deposit);
                                    newPost.child("Sewa").setValue(Sewa);
                                    newPost.child("Pendahuluan").setValue(Pendahuluan);
                                    newPost.child("Bilik").setValue(Bilik);
                                    newPost.child("Tandas").setValue(Tandas);
                                    newPost.child("mImageUrl").setValue(t);

                                    mprogress.dismiss();
                                    Toast.makeText(AdsCreateActivity.this,"Iklan berjaya disimpan",Toast.LENGTH_LONG).show();
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            }
        });


    }
}