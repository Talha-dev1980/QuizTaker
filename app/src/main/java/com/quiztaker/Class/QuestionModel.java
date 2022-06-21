package com.quiztaker.Class;

public class QuestionModel {
    String question,answer,type;
//    ArrayList<String> options=new ArrayList<>();
    String[] options;
    int image;

    String userAns;


    public String getUserAns() {
        return userAns;
    }

    public void setUserAns(String userAns) {
        this.userAns = userAns;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public QuestionModel(String question, String[] options , String answer , String type,int image) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.type = type;
        this.image=image;

    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
