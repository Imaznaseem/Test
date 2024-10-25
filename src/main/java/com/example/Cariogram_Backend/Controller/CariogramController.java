package com.example.Cariogram_Backend.Controller;

import com.example.Cariogram_Backend.Model.CariogramInput;
import com.example.Cariogram_Backend.Services.InputHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cariogram")
@CrossOrigin(origins = "https://test-jhlp.onrender.com")
public class CariogramController {

    private final InputHandlerService inputHandlerService;

    @Autowired
    public CariogramController(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }

    @PostMapping("/analyze")
    public double[] analyze(@RequestBody @Valid CariogramInput input) {
        return inputHandlerService.RunAlgorithm(input.getInputValues());
    }
}
