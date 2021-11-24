package com.example.cleanarchitecture.databuilders.domains;

import com.example.cleanarchitecture.databuilders.DataBuilderBase;
import com.example.cleanarchitecture.domains.Result;
import com.example.cleanarchitecture.domains.enums.Winner;

public class ResultDataBuilder extends DataBuilderBase<Result> {

    public Result build() {
        return Result.builder()
            .winner(Winner.NO)
            .yes(this.faker.number().randomDigit())
            .no(this.faker.number().randomDigit())
            .build();
    }
    
}
