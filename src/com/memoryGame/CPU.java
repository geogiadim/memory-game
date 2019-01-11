package com.memoryGame;

import java.util.ArrayList;

class CPU {
    private ArrayList<Integer> arrayList;

    CPU() {
        initArray();
    }

    private void initArray(){
        arrayList = new ArrayList<>();
    }

    public void addToCPUArray(int cardNo){
        if (arrayList.get(2*cardNo).equals(cardNo)){
            arrayList.add(2*cardNo+1, cardNo);
        } else arrayList.add(2*cardNo,cardNo);
    }

    private void removePair(int cardNo){
        arrayList.remove(2*cardNo);
        arrayList.remove(2*cardNo+1);
    }
}