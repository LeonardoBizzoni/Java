package clock;

public class Clock implements Runnable {
    private int ss = 0;
    private int mm = 0;
    private int hh = 0;

    public void run() {
        try {
            for (int i = 1; true; i++) {
                Thread.sleep(1000);

                ss++;
                if (ss >= 60) {
                    mm++;
                    if (mm >= 60) {
                        hh++;
                        if (hh > 23) {
                            hh = 0;
                            mm = 0;
                            ss = 0;
                        }
                        mm = 0;
                    }
                    ss = 0;
                }

                System.out.printf("%s:%s:%s\n", hh < 10 ? "0" + hh : hh, mm < 10 ? "0" + mm : mm, ss < 10 ? "0" + ss : ss);
            }
        } catch (InterruptedException e) {
        }
    }
}
