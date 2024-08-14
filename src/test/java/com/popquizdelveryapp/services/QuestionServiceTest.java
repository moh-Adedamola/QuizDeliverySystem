package com.popquizdelveryapp.services;


import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.popquizdelveryapp.data.model.Category.*;
import static com.popquizdelveryapp.data.model.Difficulty.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionsService questionsService;

    @Test
    public void test(){
        AddQuestionRequest addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 1. What is the default value of boolean in java");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1("0");
        addQuestionRequest.setOption2("null");
        addQuestionRequest.setOption3("undefined");
        addQuestionRequest.setOption4("false");
        addQuestionRequest.setCorrectAnswer("false");
        addQuestionRequest.setCategory(JAVA);
        AddQuestionResponse response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 2. The number of primitive data types in java are:");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1("six");
        addQuestionRequest.setOption2("seven");
        addQuestionRequest.setOption3("eight");
        addQuestionRequest.setOption4("nine");
        addQuestionRequest.setCorrectAnswer("eight");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 3. Identify the return type of a method that does not return any value.");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1("int");
        addQuestionRequest.setOption2("void");
        addQuestionRequest.setOption3("double");
        addQuestionRequest.setOption4("none");
        addQuestionRequest.setCorrectAnswer("void");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 4. What is the extension of java code files?");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1(".js");
        addQuestionRequest.setOption2(".txt");
        addQuestionRequest.setOption3(".class");
        addQuestionRequest.setOption4(".java");
        addQuestionRequest.setCorrectAnswer(".java");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 5. Which one of the following is not an access modifier?");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1("protected");
        addQuestionRequest.setOption2("void");
        addQuestionRequest.setOption3("public");
        addQuestionRequest.setOption4("private");
        addQuestionRequest.setCorrectAnswer("void");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 6. Which of these are selection statements in Java?");
        addQuestionRequest.setDifficultyLevel(MEDIUM);
        addQuestionRequest.setOption1("if()");
        addQuestionRequest.setOption2("for()");
        addQuestionRequest.setOption3("continue");
        addQuestionRequest.setOption4("break");
        addQuestionRequest.setCorrectAnswer("if()");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 7. Which of the following is used with the switch statement?");
        addQuestionRequest.setDifficultyLevel(MEDIUM);
        addQuestionRequest.setOption1("continue");
        addQuestionRequest.setOption2("exit");
        addQuestionRequest.setOption3("break");
        addQuestionRequest.setOption4("do");
        addQuestionRequest.setCorrectAnswer("break");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 8. The while loop repeats a set of code while the condition is not met?");
        addQuestionRequest.setDifficultyLevel(MEDIUM);
        addQuestionRequest.setOption1("True");
        addQuestionRequest.setOption2("False");
        addQuestionRequest.setOption3("None of the above");
        addQuestionRequest.setOption4("All of the above");
        addQuestionRequest.setCorrectAnswer("False");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 9. What is the variables declared in a class for the use of all methods of the class called?");
        addQuestionRequest.setDifficultyLevel(MEDIUM);
        addQuestionRequest.setOption1("Object");
        addQuestionRequest.setOption2("instance variables");
        addQuestionRequest.setOption3("reference variable");
        addQuestionRequest.setOption4("None");
        addQuestionRequest.setCorrectAnswer("instance variables");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 10. Which of the following is not an OOP concept in Java?");
        addQuestionRequest.setDifficultyLevel(MEDIUM);
        addQuestionRequest.setOption1("polymorphism");
        addQuestionRequest.setOption2("inheritance");
        addQuestionRequest.setOption3("compilation");
        addQuestionRequest.setOption4("encapsulation");
        addQuestionRequest.setCorrectAnswer("compilation");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 11. Which of these keywords can be used to prevent inheritance of a class?");
        addQuestionRequest.setDifficultyLevel(HARD);
        addQuestionRequest.setOption1("super");
        addQuestionRequest.setOption2("constant");
        addQuestionRequest.setOption3("class");
        addQuestionRequest.setOption4("final");
        addQuestionRequest.setCorrectAnswer("final");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 12. Which of these class relies upon its subclasses for complete implementation of its methods?");
        addQuestionRequest.setDifficultyLevel(HARD);
        addQuestionRequest.setOption1("object class");
        addQuestionRequest.setOption2("abstract class");
        addQuestionRequest.setOption3("array list class");
        addQuestionRequest.setOption4("none of the above");
        addQuestionRequest.setCorrectAnswer("abstract class");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 13. Which of this keyword must be used to inherit a class??");
        addQuestionRequest.setDifficultyLevel(HARD);
        addQuestionRequest.setOption1("super");
        addQuestionRequest.setOption2("this");
        addQuestionRequest.setOption3("extent");
        addQuestionRequest.setOption4("extends");
        addQuestionRequest.setCorrectAnswer("extends");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 14. Which of these is correct way of inheriting class A by class B?");
        addQuestionRequest.setDifficultyLevel(HARD);
        addQuestionRequest.setOption1("public class B + public class A{}");
        addQuestionRequest.setOption2("public class B inherits public class A{}");
        addQuestionRequest.setOption3("public class B extends A{}");
        addQuestionRequest.setOption4("public class B extends public class A{}");
        addQuestionRequest.setCorrectAnswer("public class B extends A{}");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 15. What is the process of defining a method in a subclass having same name & type signature as a method in its superclass??");
        addQuestionRequest.setDifficultyLevel(HARD);
        addQuestionRequest.setOption1("method overloading");
        addQuestionRequest.setOption2("method overriding");
        addQuestionRequest.setOption3("method hiding");
        addQuestionRequest.setOption4("none of the  mentioned");
        addQuestionRequest.setCorrectAnswer("method overriding");
        addQuestionRequest.setCategory(JAVA);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 16. Which type of Programming does Python support??");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1("object oriented programming");
        addQuestionRequest.setOption2("structured programming");
        addQuestionRequest.setOption3("functional programming");
        addQuestionRequest.setOption4("all of the above");
        addQuestionRequest.setCorrectAnswer("all of the above");
        addQuestionRequest.setCategory(PYTHON);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 17. Which of the following is the correct extension of the Python file?");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1(".python");
        addQuestionRequest.setOption2(".pl");
        addQuestionRequest.setOption3(".py");
        addQuestionRequest.setOption4(".p");
        addQuestionRequest.setCorrectAnswer(".py");
        addQuestionRequest.setCategory(PYTHON);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 18.  Which keyword is used for function in Python language?");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1("function");
        addQuestionRequest.setOption2("def");
        addQuestionRequest.setOption3("fun");
        addQuestionRequest.setOption4("define");
        addQuestionRequest.setCorrectAnswer("def");
        addQuestionRequest.setCategory(PYTHON);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 19.  Which of the following character is used to give single-line comments in Python?");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1("//");
        addQuestionRequest.setOption2("#");
        addQuestionRequest.setOption3("!");
        addQuestionRequest.setOption4("/*");
        addQuestionRequest.setCorrectAnswer("#");
        addQuestionRequest.setCategory(PYTHON);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 20. Which of the following is not a core data type in Python programming?");
        addQuestionRequest.setDifficultyLevel(EASY);
        addQuestionRequest.setOption1("tuples");
        addQuestionRequest.setOption2("lists");
        addQuestionRequest.setOption3("class");
        addQuestionRequest.setOption4("dictionary");
        addQuestionRequest.setCorrectAnswer("class");
        addQuestionRequest.setCategory(PYTHON);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 21. Which of the following is not a core data type in Python programming?");
        addQuestionRequest.setDifficultyLevel(MEDIUM);
        addQuestionRequest.setOption1("tuples");
        addQuestionRequest.setOption2("lists");
        addQuestionRequest.setOption3("class");
        addQuestionRequest.setOption4("dictionary");
        addQuestionRequest.setCorrectAnswer("class");
        addQuestionRequest.setCategory(PYTHON);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 22. Which of the following statements is used to create an empty set in Python?");
        addQuestionRequest.setDifficultyLevel(MEDIUM);
        addQuestionRequest.setOption1("()");
        addQuestionRequest.setOption2("[]");
        addQuestionRequest.setOption3("{}");
        addQuestionRequest.setOption4("set()");
        addQuestionRequest.setCorrectAnswer("set()");
        addQuestionRequest.setCategory(PYTHON);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");

        addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 23. To add a new element to a list we use which Python command?");
        addQuestionRequest.setDifficultyLevel(MEDIUM);
        addQuestionRequest.setOption1("list1.addEnd(5)");
        addQuestionRequest.setOption2("");
        addQuestionRequest.setOption3("{}");
        addQuestionRequest.setOption4("set()");
        addQuestionRequest.setCorrectAnswer("set()");
        addQuestionRequest.setCategory(PYTHON);
        response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");



    }

}

