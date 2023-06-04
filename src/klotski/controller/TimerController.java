package klotski.controller;

public class TimerController {
    private long startTime;
    private long elapsedTime;
    private boolean isRunning;

    public long getElapsedTime() {
        return elapsedTime;
    }

    public TimerController() {
        startTimer("00:00");
    }

    public TimerController(int minutes, int seconds) {
        startTime = System.currentTimeMillis();
        elapsedTime = (minutes * 60 + seconds) * 1000;
        // updateUI();
        startTimer("00:00");
    }

    public void setTime(String timeString) {
        String[] timeParts = timeString.split(":");
        if (timeParts.length == 2) {
            int minutes = Integer.parseInt(timeParts[0].trim());
            int seconds = Integer.parseInt(timeParts[1].trim());
            this.elapsedTime = (minutes * 60 + seconds) * 1000;
        } else {
            throw new IllegalArgumentException("Invalid time format. Expected format: minutes:seconds");
        }
        startTime = System.currentTimeMillis() - elapsedTime;
        Thread timerThread = new Thread(() -> {
            while (true) {
                elapsedTime = System.currentTimeMillis() - startTime;

                try {
                    Thread.sleep(1000); // Aggiorna il valore ogni secondo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();
    }

    /*private void startTimer(String timeString) {
        // startTime = System.currentTimeMillis();

        String[] timeParts = timeString.split(":");
        if (timeParts.length == 2) {
            int minutes = Integer.parseInt(timeParts[0].trim());
            int seconds = Integer.parseInt(timeParts[1].trim());
            this.elapsedTime = (minutes * 60 + seconds) * 1000;
        } else {
            throw new IllegalArgumentException("Invalid time format. Expected format: minutes:seconds");
        }
        startTime = System.currentTimeMillis() + elapsedTime;
        Thread timerThread = new Thread(() -> {
            while (true) {
                elapsedTime = System.currentTimeMillis() - startTime;

                try {
                    Thread.sleep(1000); // Aggiorna il valore ogni secondo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();
    }*/
    private void startTimer(String timeString) {
        String[] timeParts = timeString.split(":");
        if (timeParts.length == 2) {
            int minutes = Integer.parseInt(timeParts[0].trim());
            int seconds = Integer.parseInt(timeParts[1].trim());
            this.elapsedTime = (minutes * 60 + seconds) * 1000;
        } else {
            throw new IllegalArgumentException("Invalid time format. Expected format: minutes:seconds");
        }
        startTime = System.currentTimeMillis() + elapsedTime;
        startTimerThread();
    }

    private void startTimerThread() {
        isRunning = true;
        Thread timerThread = new Thread(() -> {
            while (isRunning) {
                elapsedTime = System.currentTimeMillis() - startTime;

                try {
                    Thread.sleep(1000); // Update the value every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();
    }
    public void stopTimer() {
        isRunning = false;
    }

    public String getTimeString() {
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        String timeString = String.format("%02d:%02d", minutes, seconds);
        return timeString;
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
    }

}
