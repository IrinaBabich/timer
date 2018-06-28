package com.babich.timer;
// Написать класс Timer который оперирует двумя параметрами: имя и количество секунд до конца.
// Каждую секунду выводит в консоль информацию о текущем состоянии таймера ->
// имя + количество секунд до финиша.
// По прошествии времени, выдает месседж о конце работы. Таймер должен работать асинхронно.
// Протестировать приложение с 2-3 таймерами запущенными параллельно.

public class Timer implements Runnable{
    private String name;
    private int timeToFinish;

    @Override
    public void run() {
        while (timeToFinish > 0) {
            System.out.println("Name: " + name + ", " + "time to finish: " + timeToFinish);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeToFinish--;
        }
    }
}
