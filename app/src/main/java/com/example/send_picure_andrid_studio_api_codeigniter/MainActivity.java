package com.example.send_picure_andrid_studio_api_codeigniter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imagen1,imagen2,imagen3,imagen4;
    EditText descripcion;
    Button guardar;
    Bitmap photobmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen1=(ImageView)findViewById(R.id.imgFoto1);
        imagen2=(ImageView) findViewById(R.id.imgFoto2);
        imagen3=(ImageView) findViewById(R.id.imgFoto3);
        imagen4=(ImageView) findViewById(R.id.imgFoto4);
        descripcion=(EditText) findViewById(R.id.id_descripcion);
        guardar=(Button) findViewById(R.id.btnLogin);

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Complete la acción usando..."), 1);
            }
        });
        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Complete la acción usando..."), 2);

            }
        });
        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Complete la acción usando..."), 3);

            }
        });

        imagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Complete la acción usando..."), 4);

            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( resultCode == RESULT_OK) {
            if (requestCode == 1){
                Uri selectedImageUri = data.getData();
                String aaa = getRealPathFromURI(selectedImageUri);
                photobmp = BitmapFactory.decodeFile(aaa);
                imagen1.setImageBitmap(photobmp);
            }
            if (requestCode == 2){
                Uri selectedImageUri = data.getData();
                String aaa = getRealPathFromURI(selectedImageUri);
                photobmp = BitmapFactory.decodeFile(aaa);
                imagen1.setImageBitmap(photobmp);
            }
            if (requestCode == 3){
                Uri selectedImageUri = data.getData();
                String aaa = getRealPathFromURI(selectedImageUri);
                photobmp = BitmapFactory.decodeFile(aaa);
                imagen1.setImageBitmap(photobmp);
            }
            if (requestCode == 4){
                Uri selectedImageUri = data.getData();
                String aaa = getRealPathFromURI(selectedImageUri);
                photobmp = BitmapFactory.decodeFile(aaa);
                imagen1.setImageBitmap(photobmp);
            }

        }
    }
    public String getRealPathFromURI(Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = getApplicationContext().getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

}