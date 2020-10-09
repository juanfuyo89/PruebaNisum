package cl.nisum.techtest.controller;

import cl.nisum.techtest.model.request.RegisterRequest;
import cl.nisum.techtest.model.response.RegisterResponse;
import cl.nisum.techtest.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController extends GenericController {

    @Autowired
    RegisterService registerService;

    @RequestMapping(produces = "application/json", method = RequestMethod.POST, path = "/register/user")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = registerService.register(request);
        logInfo("Registering user: ");
        return new ResponseEntity<RegisterResponse>(response, HttpStatus.OK);
    }

}
