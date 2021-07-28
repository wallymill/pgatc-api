package com.pgatc.api.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pgatc.api.data.entities.ModelPriority;
import com.pgatc.api.data.entities.SizePriority;
import com.pgatc.api.data.repositories.ModelPriorityRepository;
import com.pgatc.api.data.repositories.SizePriorityRepository;

@Configuration
class InitializeDatabaseValues {

  private static final String PRELOADING = "Preloading {}";
  private static final Logger log = LoggerFactory.getLogger(InitializeDatabaseValues.class);

  @Bean
  CommandLineRunner initDatabase(ModelPriorityRepository mpRepository, 
		  						 SizePriorityRepository sizeRepository) {

    return args -> {
    	
      if (mpRepository.findAll().size() != 4) {
	      log.info(PRELOADING , mpRepository.save(new ModelPriority("Emergency",1)));
	      log.info(PRELOADING , mpRepository.save(new ModelPriority("VIP",2)));
	      log.info(PRELOADING , mpRepository.save(new ModelPriority("Passenger",3)));
	      log.info(PRELOADING , mpRepository.save(new ModelPriority("Cargo", 4)));
      }
      log.debug("all dqp: {} ", mpRepository.findAll().toString());
      
      if (sizeRepository.findAll().size() != 2) {
    	  log.info(PRELOADING, sizeRepository.save(new SizePriority("Large", 1)));
    	  log.info(PRELOADING, sizeRepository.save(new SizePriority("Small", 2)));
      }
      log.debug("all sp:  {}", sizeRepository.findAll().toString());
      
    };
  }
}