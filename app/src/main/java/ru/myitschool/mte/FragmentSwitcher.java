package ru.myitschool.mte;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentSwitcher extends Thread {
    private FragmentManager fragmentManager;
    private Fragment fragments[];
    private boolean running = true;
    private int count = 0;

    public FragmentSwitcher(FragmentManager fragmentManager, Fragment fragments[]) {
        this.fragmentManager = fragmentManager;
        this.fragments = fragments;
    }

    @Override
    public void run() {
        while (running) {
            if (!fragmentManager.isDestroyed()) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment curFragment = fragments[count++ % 2];
                transaction.replace(R.id.output_fragment, curFragment).commit();
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void disable() {
        running = false;
    }
}
