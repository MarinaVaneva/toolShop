package bg.softuni.ToolShop.web;


import bg.softuni.ToolShop.model.dtos.ToolDTO;
import bg.softuni.ToolShop.service.ToolsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tools")
public class ToolsController {
    private final ToolsService toolsService;

    public ToolsController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }

    @GetMapping
    public ResponseEntity <List<ToolDTO>> getAllTools(){

        return ResponseEntity.ok(toolsService.getAllTools());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ToolDTO> getBookById(@PathVariable("id") Long toolId) {
        Optional<ToolDTO> theBook = toolsService.findBookById(toolId);

        return
                theBook.
                        map(ResponseEntity::ok).
                        orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToolDTO> deleteToolById(@PathVariable("id") Long toolId) {
        toolsService.deleteById(toolId);

        return ResponseEntity.
                noContent().
                build();
    }
    @PostMapping()
    public ResponseEntity<ToolDTO> createTool(@RequestBody ToolDTO newTool, UriComponentsBuilder uriComponentsBuilder) {


        return ResponseEntity.created(uriComponentsBuilder.
                       path("/api/tools/{id}").build(newTool)).
                build();
    }


}
