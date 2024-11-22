package br.edu.ifsp.arq.ads.petpar.resources.job;

import br.edu.ifsp.arq.ads.petpar.domain.service.AdoptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ResetAdoptionStatusJob {
    //TODO
    // job para permitir adoção dos animais caso não seja efetivada.

    @Autowired
    private AdoptionService adoptionService;

    @Value("${request-queue.scheduler-enabled}")
    private boolean isSchedulerEnabled;

    @Value("${request-queue.requests-amount}")
    private Integer requestAmount;

    @Value("${request-queue.month-period}")
    private Integer monthPeriod;

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Scheduled(cron = "${request-queue.period}", zone = TIME_ZONE)
    public void requestMultipleAnalysis() {
        if (!isSchedulerEnabled) {
            log.warn("[request-queue-scheduler] - disabled");
            return;
        }
        adoptionService.resetAdoptionStatus(requestAmount,monthPeriod);


    }

}
