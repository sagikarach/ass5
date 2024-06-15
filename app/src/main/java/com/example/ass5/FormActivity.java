package com.example.ass5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import com.example.ass5.databinding.ActivityFormBinding;

public class FormActivity extends AppCompatActivity {
    private AppDB db;
    private ActivityFormBinding binding;
    private Post post;
    private PostDao postDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "FooDB")
                .allowMainThreadQueries().build();
        postDao = db.postDao();
        handleSave();

        if (getIntent().getExtras() != null) {
            int id = getIntent().getExtras().getInt("id");
            post = postDao.get(id);
            if (post != null) {
                binding.etContent.setText(post.getContent());
            }
        }
    }

    private void handleSave() {
        binding.btnSave.setOnClickListener(view -> {
            if (post == null) {
                post = new Post(binding.etContent.getText().toString());
                postDao.insert(post);
            } else {
                post.setContent(binding.etContent.getText().toString());
                postDao.update(post);
            }
            finish();
        });
    }
}
