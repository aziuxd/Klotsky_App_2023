package klotski.controller;

import javax.swing.SwingUtilities;

public class TimerController {
    private long startTime;
    private long elapsedTime;

    public TimerController() {
        startTimer();
    }

    public TimerController(int minutes, int seconds) {
        startTime = System.currentTimeMillis();
        elapsedTime = (minutes * 60 + seconds) * 1000;
        updateUI();
        startTimer();
    }

    private void startTimer() {
        startTime = System.currentTimeMillis();

        Thread timerThread = new Thread(() -> {
            while (true) {
                elapsedTime = System.currentTimeMillis() - startTime;
                updateUI();

                try {
                    Thread.sleep(1000); // Aggiorna il valore ogni secondo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timerThread.start();
    }

    private void updateUI() {
        SwingUtilities.invokeLater(() -> {
            long seconds = elapsedTime / 1000;
            seconds = seconds % 60;

        });
    }

    public String getTimeString() {
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        String timeString = String.format("%02d:%02d", minutes, seconds);
        return timeString;
    }

    public long getTime() {
        return elapsedTime;
    }

    public String getTimeUpdate() {
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        String timeString = String.format("%02d:%02d", minutes, seconds);
        return timeString;
    }

    public void resetTimer() {
        startTime = System.currentTimeMillis();
        elapsedTime = 0;
        updateUI();
    }

}
