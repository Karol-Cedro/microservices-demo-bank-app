package com.kcedro.operations.service;

import com.kcedro.operations.dto.OperationDto;
import com.kcedro.operations.entity.Operation;

import java.util.List;

public interface IOperationsService {


    boolean withdraw(OperationDto operationDto);

    void deposit(OperationDto operationDto);

    List<Operation> getOperationsHistory(Long accountId);


}
