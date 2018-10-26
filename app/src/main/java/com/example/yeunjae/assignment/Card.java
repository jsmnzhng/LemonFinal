package com.example.yeunjae.assignment;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class Card {

    private static final String TAG = "Card";

    //Creating a flashcard

    private int _cardId;
    private String cardQuestion;
    private String cardAnswer;

    public Card() {
    }

    public Card(String cardQuestion, String cardAnswer) {
        this.cardQuestion = cardQuestion;
        this.cardAnswer = cardAnswer;
    }

    public String getCardQuestion() {
        return cardQuestion;
    }
    public void setCardQuestion(String cardQuestion) {
        this.cardQuestion = cardQuestion;
    }

    public String getCardAnswer() {
        return cardAnswer;
    }
    public void setCardAnswer(String cardAnswer) {
        this.cardAnswer = cardAnswer;
    }

    //Create default questions for flashcards
    public static Map<String,String> buildQuestions() {
        Map<String,String> questions = new LinkedHashMap<>();
        questions.put("What is the Lean Startup Methodology?","A methodology that focuses on developing sustainable business practices using minimal resources to encourage innovation and to deliver products and services to customers quicker.\n");
        questions.put("What is the key reason for start up failures?","They have an idea that people want, but fail to communicate with the public to incorporate their perspectives into the product. The Lean Startup Methodology attempts to solve this issue.\n");
        questions.put("What are the 5 lean start up principles?","1.\tEntrepreneurs are everywhere\n" +
                "2.\tEntrepreneurship is management\n" +
                "3.\tValidated Learning\n" +
                "4.\tInnovation Accounting\n" +
                "5.\tBuild – Measure - Learn\n");
        questions.put("Why is the Lean Startup Methodology beneficial?","It provides a scientific approach to focus on the problem (inception) and through rapid experimentation and testing, aims to find the best solution and build a product that responds to user needs (implementation).");
        questions.put("Describe the Build – Measure – Learn Loop","The goal of the loop is to turn uncertainties, assumptions and risks into knowledge that will eventually guide organizations and business towards progress, by carrying out experiments (building), determining and evaluating progress (measure), and applying the information to make important decisions (learn).\n");
        questions.put("What characteristics should metrics that measure assumptions have?\n","Metrics should be:\n" +
                "Actionable – demonstrate clear cause and effect relationship to take definitive action\n" +
                "Accessible – be easily understood and widely available to people in the company\n" +
                "Auditable – be able to go back to the source of data to prove the metrics were telling the true and entire story\n");
        questions.put("What are the 6 stages of the Lean Startup process?\n","\tIdeas, build, product, measure, data, learn \n");
        questions.put("What are some typical characteristics of the Lean Startup methodology?","\tSpending less money\n" +
                "\tFailing quickly\n" +
                "\tFailing inexpensively\n");
        questions.put("What was thought to be needed to achieve fame and fortune before the benefits of the Lean Startup Metholody were realised? ","\tDetermination, brilliance, great timing, great products\n");
        questions.put("Why is it more expensive during the early phases of Lean Startup compared to traditional methodologies? Why is it still of greater value to businesses?","\tDuring the early phases, more testing is involved in order to verify ideas and hypotheses that may exist about the project. However, by finding the right solutions or pathway early on during the product’s development cycle, this will drive the project in the right direction, making the initial expenses worthwhile.\n");
        questions.put("What are the three components of Lean Method and why are they helpful?","\tBusiness model design\n" +
                "\tCustomer development\n" +
                "\tAgile Engineering\n" +
                "\tThe components work together to reduce the amount of time and resources required to build the initial first product i.e. a prototype\n");
        questions.put("How can insights be gathered from customers?","\tBy showing them some form of an end product, whether low fidelity or high, including PowerPoints, wireframes, clay models, working prototypes, to listen to and incorporate their perspectives \n");
        questions.put("What is the difference between pivot and iteration? ","Pivots involve a substantive change to a business model canvas component, whereas iterations are only a minor change\n");
        questions.put("What are the components of a lean canvas?","\tProblem, solution, key metrics, cost structure, unique value propositions, unfair advantage, channels, customer segments, revenue streams\n");
        questions.put("When would you pivot?","\tWhen experiments are showing diminishing returns and little progress is being made towards the product. Using a new hypothesis, a pivot can help shift the business strategy into the right direction.\n");
        questions.put("When would you persevere?","\tWhen experiments show increasing returns, so it is possible to implement small changes and updates to make progress towards a goal.");

        Log.d(TAG,"Questions added to array");

        return questions;
    }


}