package com.babich.keyboardreader;
// Приложение должно считывать ввод пользователя с клавиатуры и записывать все в
// ArrayList<String>. Каждые 15 секунд содержимое листа должно сбрасываться в файл
// другим потоком.

import java.io.*;
import java.util.ArrayList;

public class KeyboardReader implements Runnable{
    private ArrayList arrayList;
    private int interval;

    public KeyboardReader(ArrayList arrayList, int interval) {
        this.arrayList = arrayList;
        this.interval = interval;
    }

    @Override
    public void run() {
        try(BufferedWriter writer = new BufferedWriter((new FileWriter("file.txt")))){
            for (Object line : arrayList){
                writer.write((String) line);
                Thread.sleep(interval);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        KeyboardReader keyboardReader = new KeyboardReader(arrayList, 15);
        Thread thread = new Thread(keyboardReader);
        thread.start();
        while(true){
            // первая строка ввода с консоли
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            arrayList.add(line);
        }
    }
}

