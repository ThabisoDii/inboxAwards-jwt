package com.example.inbox10Awards.modules.nominationsModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/inbox10/")
@CrossOrigin
public class NominationsController {

    @Autowired
    private NominationsService nominationsService;

    @PostMapping("nominate-artist")
    public ResponseEntity<Optional<?>> nominateArtist(@RequestBody NominateArtistDTO nominateArtistDTO, @RequestHeader HashMap<String,String> headers)
    {
        return nominationsService.nominateArtist(nominateArtistDTO,headers);
    }

    @GetMapping("view-nominees")
    public ResponseEntity<Optional<?>> viewNominees(){
        return nominationsService.viewNominees();
    }
}
