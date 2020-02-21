package com.cve.cve.Controllers.Api;

import java.util.List;

import com.cve.cve.Dtos.Responses.EventDto;
import com.cve.cve.Services.EventService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EventController
 */
@RestController
@RequestMapping("/Api/Events")
public class EventController {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private EventService eventService;

  /*
   * @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE) public
   * ResponseEntity create(@Valid @RequestBody Event event,@RequestParam("file")
   * MultipartFile file) { File uploadedFile = new File("D:\\",
   * file.getOriginalFilename());
   * 
   * try { uploadedFile.createNewFile(); FileOutputStream fileOutputStream = new
   * FileOutputStream(uploadedFile); fileOutputStream.write(file.getBytes());
   * fileOutputStream.close(); event.setPlanningImageLink(uploadedFile.getPath());
   * } catch (IOException e) { e.printStackTrace(); }
   * 
   * return
   * ResponseEntity.ok(modelMapper.map(eventService.save(event),EventDto.class));
   * }
   */
/*


  @PostMapping
  public ResponseEntity create(@Valid @RequestBody Event event) {

    return ResponseEntity.ok(modelMapper.map(eventService.save(event), EventDto.class));
  }

  @PutMapping
  public ResponseEntity update(@Valid @RequestBody Event event) {

    return ResponseEntity.ok(modelMapper.map(eventService.update(event), EventDto.class));
  }

  @DeleteMapping
  public ResponseEntity delete(@Valid @RequestParam("id") Long id) {
    eventService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Event Deleted");
  }
*/
@GetMapping("/All")
public ResponseEntity<List<EventDto>> getAll() {
   List<EventDto> listeventDto= modelMapper.map(eventService.findAllVisibleEvents(),new TypeToken<List<EventDto>>() {}.getType());
   return ResponseEntity.ok(listeventDto);    
}
   
   @GetMapping("/{id}")
   public ResponseEntity<EventDto> getEvent(@PathVariable Long id){
     if(eventService.findById(id).isPresent()){
      return ResponseEntity.ok(modelMapper.map(eventService.findById(id).get(), EventDto.class));  
     }
     return new ResponseEntity<>(HttpStatus.OK); 
   }
  
}

