package com.andreyalves.hexagonal.config;

import com.andreyalves.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.andreyalves.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.andreyalves.hexagonal.adapters.out.InsertCustomerAdapter;
import com.andreyalves.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.andreyalves.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.andreyalves.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {


    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter){
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

}
