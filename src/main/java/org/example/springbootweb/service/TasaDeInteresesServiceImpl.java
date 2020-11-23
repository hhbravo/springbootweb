package org.example.springbootweb.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.springbootweb.entity.TasaDeIntereses;
import org.example.springbootweb.repository.TasaDeInteresesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
@CacheDefaults(cacheName = "tasa_de_intereses")
public class TasaDeInteresesServiceImpl implements TasaDeInteresesService {
    //create cache
    @Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
        @Override
        public void customize(CacheManager cacheManager)
        {
            cacheManager.createCache("tasa_de_intereses", new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 1000)))
                    .setStoreByValue(false)
                    .setStatisticsEnabled(true));
        }
    }

    @Autowired
    TasaDeInteresesRepository tasaDeInteresesRepository;

    private static final Logger LOGGER = LogManager.getLogger(TasaDeInteresesServiceImpl.class.getName());

    public TasaDeIntereses getTasaDeInteres(Long id) {
        return tasaDeInteresesRepository.findById(id).get();
    }
    @CacheResult
    public TasaDeIntereses getTasaDeInteresByInteresCode(String interesCode) {
        TasaDeIntereses tasaDeIntereses = null;
        List<TasaDeIntereses> tasaDeInteresesList = tasaDeInteresesRepository.findByInteresCode(interesCode);
        if (tasaDeInteresesList.size() > 0 ){
            tasaDeIntereses = tasaDeInteresesList.get(0);
        }
        return tasaDeIntereses;
    }


    public List<TasaDeIntereses> findAll() {
        return tasaDeInteresesRepository.findAll();
    }

    public Map<String, Object> getTasaDeInteresMap() {
        LOGGER.debug("Executing task");
        Map<String, Object> tasaDeInteresMap = new HashMap<String, Object>();
        for (TasaDeIntereses tasaDeIntereses : findAll()) {
            tasaDeInteresMap.put(tasaDeIntereses.getInteresCode(), tasaDeIntereses.getInteresMonto());
        }
        return tasaDeInteresMap;
    }
}
