package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.dictionary.HumanEmbeddedDictionary;
import ru.rivc.pojo.Adult;
import ru.rivc.pojo.Human;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * The type Human list service.
 * Service to work with in-memory dictionary
 * TODO methods for task 1,2 and 3
 */
@Service
public class HumanListService {
    private final HumanEmbeddedDictionary dictionary;

    /**
     * Instantiates a new Human list service.
     *
     * @param dictionary the dictionary
     */
    @Autowired
    public HumanListService(HumanEmbeddedDictionary dictionary) {
        this.dictionary = dictionary;
    }

    //TODO findById
    public Human findById(int id) {
        return dictionary.getHumans().stream()
                .map(h -> (Human) h)
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElseThrow();
    }
    
    //TODO groupByName
    public Map<String, List<Adult>> groubByName() {
        return dictionary.getHumans().stream()
                .filter(h -> h instanceof Adult)
                .map(h -> (Adult) h)
                .collect(Collectors.groupingBy(Adult::getName));
    }

    //TODO getRandomHumanForLottery()
    public Human getRandomHumanForLottery() {
        int listSize = dictionary.getHumans().size();
        Random random = new Random();
        return (Human) dictionary.getHumans().get(random.nextInt(listSize));
    }

}
