package ru.myitschool.mte;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import ru.myitschool.mte.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Button btnStart, btnStop;

    private FragmentSwitcher switcher;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnStart = binding.content.startBtn;
        btnStop = binding.content.stopBtn;

        initSwitch();
    }

    protected void initSwitch() {
        Fragment fragments[] = {new FirstFragment(), new ProceedingFragment()};
        manager = getSupportFragmentManager();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switcher = new FragmentSwitcher(manager, fragments);
                switcher.start();
                System.out.println("yep");
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switcher != null) {
                    switcher.disable();
                    System.out.println("not yep");
                }
            }
        });
    }
}
