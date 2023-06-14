package com.example.task11;

import javafx.scene.control.TextArea;
import java.util.ArrayList;

public class Viewer extends Colleague{
    final int NUMBER=10;
    public Viewer(Mediator mediator) {
        super(mediator);

    }

    @Override
    public void notifyColleague(ArrayList<Qweston> test) {
        TextArea textArea=new TextArea();
        String str="";
        for (int i = 0; i < test.size(); i++) {
            str+=""+(i+1)+" "+test.get(i).getQuestion()+"\n\r";
            for (int j = 0; j < test.get(i).getAnswergood().size(); j++) {
                str+=test.get(i).getAnswergood().get(j).getValue()+"\n";
            }
            str+="НЕ ПРАВИЛЬНО"+"\n\r";
            for (int j = 0; j < test.get(i).getBadanswer().size(); j++) {
                str+=(test.get(i).getBadanswer().get(j)).getValue()+"\r\n";
            }
        }
        textArea.setText(str);
        textArea.setWrapText(true);
        mediator.setView(textArea);
    }

    public void receive(ArrayList<Qweston> message){
        ArrayList<Qweston> currenttest=new ArrayList<>();
        ArrayList<Qweston> test=new ArrayList<>();
        test.addAll(message);
        for(int i = 0; i<NUMBER && i<test.size(); i++){
            int index;
            index = (int)(Math.random()*test.size());
            if(index == test.size())index --;
            currenttest.add(test.get(index));
            test.remove(index);
        }
        super.receive(currenttest);
    }

}