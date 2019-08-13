package com.example.inbox10Awards.modules.nominationsModule;

import com.example.inbox10Awards.genericDTO.GenericDTO;
import com.example.inbox10Awards.security.JwtTokenUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
public class NominationsService {
    @Autowired
    private NominationsRepository nominationsRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public ResponseEntity<Optional<?>> nominateArtist(NominateArtistDTO nominateArtistDTO, HashMap<String,String> headers){
        try{
            ModelMapper modelMapper = new ModelMapper();
            GenericDTO genericDTO = new GenericDTO();

            String userEmail = jwtTokenUtil.getUsernameFromToken(headers.get("authorization").replace("Bearer",""));
            nominateArtistDTO.setNominator(userEmail);
            NominationsEntity nominationsEntity = modelMapper.map(nominateArtistDTO, NominationsEntity.class);//maps DTO to the entity
            nominationsRepository.save(nominationsEntity);

            genericDTO.setHttpCode("200");
            genericDTO.setMessage("Nomination saved succesfully");
           // return ResponseEntity.ok(genericDTO);

            return ResponseEntity.ok(Optional.of(genericDTO));
        }catch(Exception ex){
            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setHttpCode("200");
            genericDTO.setMessage(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.of(genericDTO));
        }
    }

    public ResponseEntity<Optional<?>> viewNominees(){

        ArrayList<NominationsEntity> allNominees =  (ArrayList<NominationsEntity>)nominationsRepository.findAll();
        return ResponseEntity.ok(Optional.of(allNominees));
    }
}
