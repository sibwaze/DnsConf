package com.novibe.common.base_dto;

import com.google.gson.Gson;
import com.novibe.App;

public interface Jsonable {

    Gson mapper = App.context.getBean(Gson.class);

    default String toJson() {
        return mapper.toJson(this);
    }

}
