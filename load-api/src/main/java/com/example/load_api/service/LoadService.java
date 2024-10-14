package com.example.load_api.service;

import com.example.load_api.model.Load;
import com.example.load_api.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public Load addLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(Long shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadById(Long loadId) {
        Optional<Load> load = loadRepository.findById(loadId);
        return load.orElse(null);
    }

    public Load updateLoad(Long loadId, Load loadDetails) {
        Optional<Load> loadOptional = loadRepository.findById(loadId);
        if (loadOptional.isPresent()) {
            Load load = loadOptional.get();
            load.setLoadingPoint(loadDetails.getLoadingPoint());
            load.setUnloadingPoint(loadDetails.getUnloadingPoint());
            load.setProductType(loadDetails.getProductType());
            load.setTruckType(loadDetails.getTruckType());
            load.setNoOfTrucks(loadDetails.getNoOfTrucks());
            load.setWeight(loadDetails.getWeight());
            load.setComment(loadDetails.getComment());
            load.setDate(loadDetails.getDate());
            return loadRepository.save(load);
        }
        return null;
    }

    public void deleteLoad(Long loadId) {
        loadRepository.deleteById(loadId);
    }
}
