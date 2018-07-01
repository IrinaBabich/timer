package com.babich.timer;
// Написать класс Timer который оперирует двумя параметрами: имя и количество секунд до конца.
// Каждую секунду выводит в консоль информацию о текущем состоянии таймера ->
// имя + количество секунд до финиша.
// По прошествии времени, выдает месседж о конце работы. Таймер должен работать асинхронно.
// Протестировать приложение с 2-3 таймерами запущенными параллельно.

public class Timer implements Runnable{
    private String name;
    private int timeToFinish;

    public Timer(String name, int timeToFinish) {
        this.name = name;
        this.timeToFinish = timeToFinish;
    }

    public String getName() {
        return name;
    }

    public int getTimeToFinish() {
        return timeToFinish;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeToFinish(int timeToFinish) {
        this.timeToFinish = timeToFinish;
    }

    @Override
    public void run() {
        while (timeToFinish > 0) {
            System.out.println("Name: " + name + ", " + "time to finish: " + timeToFinish);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            timeToFinish--;
        }
        System.out.println(name + " has finished.");
    }

    public static void main(String[] args) {
        Timer timer1 = new Timer("Timer 1", 10);
        Timer timer2 = new Timer("Timer 2", 10);
        Timer timer3 = new Timer("Timer 3", 10);
        Thread thread1 = new Thread(timer1);
        Thread thread2 = new Thread(timer2);
        Thread thread3 = new Thread(timer3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
