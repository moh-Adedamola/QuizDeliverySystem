package com.popquizdelveryapp.controller;

import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.request.UpdateQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;
import com.popquizdelveryapp.dtos.response.ApiResponse;
import com.popquizdelveryapp.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/question")
public class QuestionsController {

    @Autowired
    public QuestionsService questionsService;

    @PostMapping("add")
    public ResponseEntity<?> addQuestion(@RequestBody AddQuestionRequest addQuestionRequest) {
        try{
            AddQuestionResponse response = questionsService.add(addQuestionRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable("id") String id) {
        try{
            Question question = questionsService.findQuestionById(id);
            return new ResponseEntity<>(new ApiResponse(true, question), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find/all")
    public ResponseEntity<?> getAllQuestions() {
        try{
            List<Question> question = questionsService.findAll();
            return new ResponseEntity<>(new ApiResponse(true, question), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find/category/{cat}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable("cat") String category) {
        try{
            return new ResponseEntity<>(new ApiResponse(true, questionsService.findByCategory(category)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find/difficulty")
    public ResponseEntity<?> getQuestionsByDifficulty(@RequestBody Difficulty difficulty) {
        try{

            return new ResponseEntity<>(new ApiResponse(true, questionsService.findByDifficultyLevel(difficulty)), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(new ApiResponse(true,questionsService.deleteQuestionById(id)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateQuestionById(@PathVariable("id") String id, @RequestBody UpdateQuestionRequest updateQuestionRequest) {
        try{
            return new ResponseEntity<>(new ApiResponse(true, questionsService.updateQuestionById(id, updateQuestionRequest)), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}
