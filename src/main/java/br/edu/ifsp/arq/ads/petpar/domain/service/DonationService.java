package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.DonationEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.DonationRepository;
import br.edu.ifsp.arq.ads.petpar.resources.messaging.kafka.service.KafkaService;
import br.edu.ifsp.arq.ads.petpar.resources.messaging.kafka.event.dto.SendMessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DonationService {

    @Autowired
    private DonationRepository kafkaService;

    public void send(DonationEntity request) throws Exception {
        try {
            kafkaService.sendNewConsumerLimitChanged(SendMessageEvent.of(request));
        } catch(Exception exception){
            throw exception;
        }


    }
}
