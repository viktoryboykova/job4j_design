package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> listAnswer = readPhrases();
        List<String> log = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        boolean botAnswer = true;
        while (!question.equals(OUT)) {
            if (question.equals(STOP)) {
                botAnswer = false;
            } else if (question.equals(CONTINUE)) {
                botAnswer = true;
            }
            log.add("User : " + question);
            if (botAnswer) {
                String answer = listAnswer.get(new Random().nextInt(listAnswer.size()));
                log.add("Bot: " + answer);
                System.out.println(answer);
            }
            question = input.nextLine();
        }
        log.add("User : " + question);
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
           br.lines().forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(path, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "./src/consoleChat/dialog.txt", "./src/consoleChat/botAnswer.txt"
        );
        cc.run();
    }
}
