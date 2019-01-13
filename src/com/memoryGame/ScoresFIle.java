package com.memoryGame;

import com.memoryGame.GUI.GUIConnectionToLogic;

import java.io.*;

class ScoresFIle {
    private String name;
    private int steps=0,wins=0,mode;
    private String[][] highScores;

    ScoresFIle(String name,int steps,int mode){
        this.name=name;
        this.steps=steps;
        this.mode=mode;
        initHighScores();
        createFile();
    }
    ScoresFIle(String name,int mode){
        this.name=name;
        this.mode=mode;
        initHighScores();
        createFile();
    }

    private void initHighScores(){
        highScores= new String[7][4];
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
        changeHighScores();
    }

    private void changeHighScores(){
        if (GUIConnectionToLogic.getNumOfPlayers()==1){
            switch (mode){
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
            }
        }
        else {
            //change the array if there is a winner
            if (!name.equals("")) {
                wins++;
                switch (mode){
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
                        System.out.println("Wins: "+ wins);
                        break;
                }
            }
        }
    }

    private void createFile(){
        try (FileWriter writer= new FileWriter("Memory-Game-Scores.txt")){
            for (int i=0; i<7; i++){
                for (int j=0; j<4; j++){
                    writer.write(highScores[i][j]);
                }
                writer.write("\n\n");
            }
        }catch (IOException e) {
            System.err.println("Error");
        }
    }
}