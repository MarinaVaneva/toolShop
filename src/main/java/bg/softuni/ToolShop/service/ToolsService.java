package bg.softuni.ToolShop.service;


import bg.softuni.ToolShop.model.dtos.ToolDTO;
import bg.softuni.ToolShop.model.entity.Manufacture;
import bg.softuni.ToolShop.model.entity.Tool;
import bg.softuni.ToolShop.repository.ManufactureRepository;
import bg.softuni.ToolShop.repository.ToolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToolsService {

    private final ToolRepository toolRepository;
    private final ModelMapper modelMapper;
    private final ManufactureRepository manufactureRepository;

    public ToolsService(ToolRepository toolRepository, ModelMapper modelMapper, ManufactureRepository manufactureRepository) {
        this.toolRepository = toolRepository;
        this.modelMapper = modelMapper;
        this.manufactureRepository = manufactureRepository;
    }

    public List<ToolDTO> getAllTools(){
        return toolRepository.findAll()
                .stream()
                .map(tool -> modelMapper.map(tool, ToolDTO.class))
                .collect(Collectors.toList());

    }


    public
    Optional<ToolDTO> findBookById(Long toolId) {
        return toolRepository.
                findById(toolId)
                .stream()
                .map(tool -> modelMapper.map(tool, ToolDTO.class))
                .findFirst();

    }

    public void deleteById(Long toolId) {
        toolRepository.
                findById(toolId).
                ifPresent(toolRepository::delete);
    }
    public long createTool(ToolDTO newTool) {
       String manufactureName = newTool.getManufactures().getName();
       Optional<Manufacture> manufactureOpt = this.manufactureRepository.findManufactureByName(manufactureName);

       Tool aTools = new Tool();
////                setDescription(newTool.getDescription()).
////                setManufactures(manufactureOpt.orElseGet(() -> createNewManufactore(manufactureName))).
////                setCategory(newTool.getCategory()).
////                setPrice(newTool.getPrice()).
////                setTitle(newTool.getTitle());
      aTools.setManufactures(manufactureOpt.orElseGet(() -> createNewManufactore(manufactureName)));
      aTools.setTitle(newTool.getTitle());       aTools.setPrice(newTool.getPrice());       aTools.setDescription(newTool.getDescription());

       return toolRepository.save(aTools).getId();

    }

    private Manufacture createNewManufactore (String manufactoreName) {

       return manufactureRepository.save(createNewManufactore(manufactoreName));
   }


}
