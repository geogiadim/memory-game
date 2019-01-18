package com.memoryGame;
import com.memoryGame.GUI.GUIConnectionToLogic;
import java.io.*;
import java.util.HashMap;

class ScoresFIle implements Serializable{
    private String name;
    private int steps=0,wins=0,mode;
    private String[][] highScores;
    private boolean winner=false;
    private boolean fileNotExists;
    private HashMap<String,Integer> hashMap;

    private final String FILE_WINS_BIN= "Memory-Game-Wins.bin";
    private final String FILE_WINS_TXT = "Memory-Game-Wins.txt";
    private final String FILE_BIN = "Memory-Game-Scores.bin";
    private final String FILE_TXT = "Memory-Game-Scores.txt";

    ScoresFIle(String name,int steps,int mode){
        highScores= new String[7][5];
        this.name=name;
        this.steps=steps;
        this.mode=mode;
        checkIfFIleExists();
        createFile();
    }
    ScoresFIle(String name,int mode, boolean isThereWinner){
        highScores= new String[7][5];
        hashMap= new HashMap<>();
        this.name=name;
        this.mode=mode;
        winner=isThereWinner;
        checkIfFIleExists();
        createFile();
    }

    private void checkIfFIleExists(){
        if ((new File(FILE_TXT).isFile())){
            System.out.println("txt exists");
            fileNotExists=false;
            loadFromBinaryFile();
            changeHighScores();
        } else {
            System.out.println("txt not");
            fileNotExists=true;
            initHighScores();
            changeHighScores();
        }
    }

    private void checkForWins(){
        if ((new File(FILE_WINS_BIN).isFile())){
            System.out.println("bin exists");
            loadWinsFromBinaryFile();
            changeHashMap();
        }else {
            System.out.println("bin not exists");
            changeHashMap();
        }
    }

    private void initHighScores(){
        highScores[0][0] = "Solo Basic Game high score: ";
        highScores[1][0] = "Solo Double Game high score: ";
        highScores[2][0] = "Solo Triple Game high score: ";
        highScores[3][0] = "Basic Game high score: ";
        highScores[4][0] = "Double Game high score: ";
        highScores[5][0] = "Triple Game high score: ";
        highScores[6][0] = "Duel Game high score: ";
        for (int i=0;i<3;i++){
            highScores[i][1] = "none";
            highScores[i][2] = ", ";
            highScores[i][3] = String.valueOf(0);
            highScores[i][4] = " steps";
        }
        for (int i=3;i<7;i++){
            highScores[i][1] = "none";
            highScores[i][2] = ", ";
            highScores[i][3] = String.valueOf(0);
            highScores[i][4] = " wins";
        }
    }

    private void saveToBinaryFile() {
        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_BIN)))){
            for (String[] line : highScores){
                for (String element : line){
                    out.writeUTF(element);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void loadFromBinaryFile(){
        try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_BIN)))){
            for (int i = 0; i< highScores.length; i++){
                for (int j = 0; j< highScores[i].length; j++){
                    highScores[i][j] = in.readUTF();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void loadWinsFromBinaryFile(){
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_WINS_BIN)))){
            for (String n : hashMap.keySet()){
                hashMap.put(in.readUTF(),hashMap.get(n));
                System.out.println(1);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void saveWinsToBinaryFile() {
        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_WINS_BIN)))){
            for (String name : hashMap.keySet()){
                out.writeUTF(name);
                out.write(hashMap.get(name));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void changeHashMap (){
        boolean flag = false;
        for (String n : hashMap.keySet()) {
            if (hashMap.containsKey(name)) {
                System.out.println("change");
                hashMap.replace(n, hashMap.get(n) + 1);
                flag=true;
            }
        }

        if (!flag) {
            hashMap.put(name,1);
        }

    }

    private void changeHighScores(){
        if (false/*GUIConnectionToLogic.getNumOfPlayers()==1*/){
            if (steps <= Integer.parseInt(highScores[mode-1][3]) || fileNotExists || Integer.parseInt(highScores[mode-1][3]) == 0){
                highScores[mode-1][1]= name;
                highScores[mode-1][3]= String.valueOf(steps);
            }
        }
        else {
            //change the array if there is a winner
            if (winner) {
                checkForWins();
                if (name.equals(highScores[mode+2][1])){
                    wins = Integer.parseInt(highScores[mode+2][3]) + 1;
                    highScores[mode+2][3]= String.valueOf(wins);
                }else {
                    if (hashMap.get(name)>= Integer.parseInt(highScores[mode+2][3]) || fileNotExists){
                        highScores[mode+2][1]= name;
                        highScores[mode+2][3]= String.valueOf(hashMap.get(name));
                    }
                }
            }
        }
    }

    private void createFile(){
        try (FileWriter writer= new FileWriter(FILE_TXT)){
            for (int i=0; i<7; i++){
                for (int j=0; j<5; j++){
                    writer.write(highScores[i][j]);
                }
                writer.write("\n\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer= new FileWriter(FILE_WINS_TXT)){
            for (String n : hashMap.keySet()){
                writer.write(n);
                String wins = String.valueOf(hashMap.get(n));
                writer.write(wins);
                writer.write("\n\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


        if (true/*GUIConnectionToLogic.getNumOfPlayers()>1*/) saveWinsToBinaryFile();
        saveToBinaryFile();
    }

    public static void main(String[] args) {
        //ScoresFIle file = new ScoresFIle("nikos",26,3);
        ScoresFIle file = new ScoresFIle("dimitris",3,true);
    }
}