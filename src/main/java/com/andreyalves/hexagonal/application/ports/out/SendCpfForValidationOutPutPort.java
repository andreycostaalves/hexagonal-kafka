package com.andreyalves.hexagonal.application.ports.out;

public interface SendCpfForValidationOutPutPort {

    void send(String cpf);
}
