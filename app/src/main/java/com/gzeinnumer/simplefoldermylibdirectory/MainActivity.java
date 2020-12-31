package com.gzeinnumer.simplefoldermylibdirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gzeinnumer.gzndirectory.helper.FGDir;
import com.gzeinnumer.simplefoldermylibdirectory.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //todo 13 initOnClick
        initOnClick();

    }

    private void initOnClick() {
        //todo 14
        binding.btnCreateFolder.setOnClickListener(v -> {
            //list folder
            String[] folders = new String[]{"/folder1","/folder1/folder1_1","/folder2"};

            //make folder
            if (FGDir.initFolder(folders)){
                Toast.makeText(getApplicationContext(), "Folder sudah dibuat dan ditemukan sudah bisa lanjut", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Permition Required", Toast.LENGTH_SHORT).show();
            }
        });

        //todo 15
        binding.btnIsFolderExists.setOnClickListener(v -> {
            //check is folder1 exists
            boolean isExists = FGDir.isFileExists("/folder1");
            Toast.makeText(MainActivity.this, "folder1 isExists status : "+isExists, Toast.LENGTH_SHORT).show();
        });

        //todo 16
        binding.btnDeleteFolder.setOnClickListener(v -> {
            //delete folder2
            boolean isDeleted = FGDir.deleteDir("/folder2");
            Toast.makeText(MainActivity.this, "folder2 dihapus status: "+isDeleted, Toast.LENGTH_SHORT).show();
        });
    }
}