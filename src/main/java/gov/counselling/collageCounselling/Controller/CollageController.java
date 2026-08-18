package gov.counselling.collagecounselling.controller;


import gov.counselling.collagecounselling.dto.CollageRequest;
import gov.counselling.collagecounselling.dto.CollageResponse;
import gov.counselling.collagecounselling.service.CollageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collage")
public class CollageController {

    private final CollageServiceImpl collageService;
    public CollageController(CollageServiceImpl collageService) {
        this.collageService = collageService;
    }

    @PostMapping
    public ResponseEntity<CollageResponse> createStudent(@RequestBody CollageRequest collageRequest){
         CollageResponse collageResponse = collageService.createCollage(collageRequest);
         return ResponseEntity.status(HttpStatus.CREATED).body(collageResponse);
    }

    @GetMapping
    public ResponseEntity<List<CollageResponse>> getCollages (){

        return ResponseEntity.status(HttpStatus.OK).body(collageService.getAllCollage());
    }

    @GetMapping("/{code}")
    public ResponseEntity<CollageResponse> getCollage (@PathVariable String code){
        return ResponseEntity.status(HttpStatus.OK).body(collageService.getCollage(code));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCollage (@PathVariable String code){
        collageService.deleteCollage(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted successfully..!");
    }

    @PatchMapping("/{code}")
    public ResponseEntity<CollageResponse> updateCollage(@PathVariable String code,@RequestBody CollageRequest request){
        CollageResponse updatedCollage = collageService.updateCollage(code,request);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCollage);
    }


}
