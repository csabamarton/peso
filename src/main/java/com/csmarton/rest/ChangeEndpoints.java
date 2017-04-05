package com.csmarton.rest;

import com.csmarton.model.ChangeRequest;
import com.csmarton.model.ChangeResult;
import com.csmarton.service.CashRegister;
import com.csmarton.service.CashRegisterFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/api")
public class ChangeEndpoints {

    @Autowired
    CashRegisterFactory cashRegisterFactory;

    @GET
    @Path("/test")
    public String test() {
        return "It works";
    }

    @POST
    @Path("/get/banknotes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ChangeResult getBanknotes(@Valid ChangeRequest request) {
        CashRegister cashRegister = cashRegisterFactory.buildCashRegister(request.getRegisterKey());

        ChangeResult result = cashRegister.getBanknotesForValue(request.getValue());

        return result;
    }

    @GET
    @Path("/get/inventory")
    @Produces(MediaType.APPLICATION_JSON)
    public CashRegister getInventory() {
        CashRegister cashRegister = cashRegisterFactory.buildCashRegister("cuc");

        return cashRegister;
    }
}
