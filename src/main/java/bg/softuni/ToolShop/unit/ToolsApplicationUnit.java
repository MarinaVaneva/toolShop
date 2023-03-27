package bg.softuni.ToolShop.unit;
import bg.softuni.ToolShop.model.entity.Manufacture;
import bg.softuni.ToolShop.model.enums.CategoryNameEnum;
import bg.softuni.ToolShop.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bg.softuni.ToolShop.model.entity.Tool;
import java.util.ArrayList;
import java.util.List;

import static bg.softuni.ToolShop.model.enums.CategoryNameEnum.HANDTOOLS;
import static bg.softuni.ToolShop.model.enums.CategoryNameEnum.POWERTOOLS;


@Component
public class ToolsApplicationUnit implements CommandLineRunner {


    private final ToolRepository toolRepository;
    private final ManufactureRepository manufactureRepository;

    public ToolsApplicationUnit(ToolRepository toolRepository, ManufactureRepository manufactureRepository) {
        this.toolRepository = toolRepository;
        this.manufactureRepository = manufactureRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (toolRepository.count() == 0 && manufactureRepository.count() == 0) {
            initTACWISE();
            initPremium();
            initPremium1();
            initPremium2();
            initTruper();
        }
    }
    private void initTACWISE() {
        initManufacture("TACWISE",
                "Пневматичен професионален такер с контрол на дълбочината и механизъм за бързо освобождаване.",
                HANDTOOLS, 380.00,
                "Такер пневматичен 19-50мм");

    }

    private void initPremium() {
        initManufacture("Premium",
                "Захранване: 230 V AC, 50 Hz, Мощност: 750 W",
                POWERTOOLS, 65.00,
                "БОРМАШИНА PREMIUM 750W");

    }

    private void initPremium1() {
        initManufacture("Premium",
                "Мощност: 2100W. Скорост на празен ход 6000 мин-1. Диаметър на диск: 230 мм, Напрежение: 230V/50Hz",
                POWERTOOLS, 115.00,
                "Ъглошлайф 230мм");

    }

    private void initPremium2() {
        initManufacture("Premium",
                "Замби 6бр к-т 4-12.5мм",
                HANDTOOLS, 14.80,
                "Замби 6бр");

    }

    private void initTruper() {
        initManufacture("Truper",
                "Кована глава с високо въглеродна стомана с двойна термична обработка.",
                HANDTOOLS, 123.00,
                "Чук боен 9.1кг");
    }

    private void initManufacture(String manufactureName, String description, CategoryNameEnum category, Double price, String title){
        Manufacture manufacture = new Manufacture() ;
        manufacture.setName(manufactureName);
        manufacture = manufactureRepository.save(manufacture);

        List<Tool> allTools = new ArrayList<>();

//        for (String tool: tools) {
//            Tool  aTool = new Tool();
//           aTool.setManufactures(manufacture) ;
//            aTool.setTitle(title);
//            aTool.setPrice(price);
//            aTool.setDescription(description);
//            aTool.setCategory(category);
//             allTools.add(aTool);
//        }
            Tool  aTool = new Tool();
            aTool.setManufactures(manufacture) ;
            aTool.setTitle(title);
            aTool.setPrice(price);
            aTool.setDescription(description);
            aTool.setCategories(category);
            allTools.add(aTool);

        manufacture.setTools(allTools);
        manufactureRepository .save(manufacture);

        toolRepository.saveAll(allTools);
    }




}
