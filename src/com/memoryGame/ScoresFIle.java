package com.memoryGame;
import com.memoryGame.GUI.GUIConnectionToLogic;
import java.io.*;

class ScoresFIle implements Serializable{
    private String name;
    private int steps=0,wins=0,mode;
    private String[][] highScores;
    private boolean winner=false;
    private boolean flag=false;

    private final String FILE_BIN = "Memory-Game-Scores.bin";
    private final String FILE_TXT = "Memory-Game-Scores.txt";

    ScoresFIle(String name,int steps,int mode){
        this.name=name;
        this.steps=steps;
        this.mode=mode;
        checkIfFIleExists();
        createFile();
    }
    ScoresFIle(String name,int mode, boolean isThereWinner){
        this.name=name;
        this.mode=mode;
        winner=isThereWinner;
        checkIfFIleExists();
        createFile();
    }

    private void checkIfFIleExists(){
        highScores= new String[7][4];
        if ((new File(FILE_TXT).isFile())){
            System.out.println("txt exists");
            loadFromBinaryFile();
            changeHighScores();
        } else {
            System.out.println("txt not");
            flag=true;
            initHighScores();
            changeHighScores();
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
            highScores[i][1] = "none, ";
            highScores[i][2] = String.valueOf(0);
            highScores[i][3] = " steps";
        }
        for (int i=3;i<7;i++){
            highScores[i][1] = "none, ";
            highScores[i][2] = String.valueOf(0);
            highScores[i][3] = " wins";
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

    private void changeHighScores(){
        if (true/*GUIConnectionToLogic.getNumOfPlayers()==1*/){
            /*switch (mode){
                case 1:
                    highScores[0][1]= name+", ";
                    highScores[0][2]= String.valueOf(steps);
                    break;
                case 2:
                    highScores[1][1]= name+", ";
                    highScores[1][2]= String.valueOf(steps);
                    break;
                case 3:
                    highScores[2][1]= name+", ";
                    highScores[2][2]= String.valueOf(steps);
                    break;
            }*/
            if (steps <= Integer.parseInt(highScores[mode-1][2]) || flag || Integer.parseInt(highScores[mode-1][2]) == 0){
                highScores[mode-1][1]= name+", ";
                highScores[mode-1][2]= String.valueOf(steps);
            }
        }
        else {
            //change the array if there is a winner
            if (winner) {
                wins++;
                /*switch (mode){
                    case 1:
                        highScores[3][1]= name+", ";
                        highScores[3][2]= String.valueOf(wins);
                        break;
                    case 2:
                        highScores[4][1]= name+", ";
                        highScores[4][2]= String.valueOf(wins);
                        break;
                    case 3:
                        highScores[5][1]= name+", ";
                        highScores[5][2]= String.valueOf(wins);
                        break;
                    case 4:
                        highScores[6][1]= name+", ";
                        highScores[6][2]= String.valueOf(wins);
                        break;
                }*/
                highScores[mode+2][1]= name+", ";
                highScores[mode+2][2]= String.valueOf(wins);
            }
        }
    }

    private void createFile(){
        try (FileWriter writer= new FileWriter(FILE_TXT)){
            for (int i=0; i<7; i++){
                for (int j=0; j<4; j++){
                    writer.write(highScores[i][j]);
                }
                writer.write("\n\n");
            }
        }catch (IOException e) {
            System.err.println("Error");
        }
        saveToBinaryFile();
    }

    public static void main(String[] args) {
        ScoresFIle file = new ScoresFIle("nikos",22,1);
    }
}