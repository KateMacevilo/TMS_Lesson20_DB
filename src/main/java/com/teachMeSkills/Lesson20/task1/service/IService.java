package com.teachMeSkills.Lesson20.task1.service;

import com.teachMeSkills.Lesson20.task1.model.IModel;
import com.teachMeSkills.Lesson20.task1.model.Model;

import java.util.ArrayList;

public interface IService {

    int FIRST_STATEMENT_PARAM = 1;
    int SECOND_STATEMENT_PARAM = 2;
    int THIRD_STATEMENT_PARAM = 3;
    int FORTH_STATEMENT_PARAM = 4;

    void getAll();
    boolean deleteInfoByID(int ID);
    boolean addInfo(IModel model);


}
