package br.edu.ifsp.arq.ads.petpar.resources.job;

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
    //private CreditAnalysisService creditAnalysisService;

    @Value("${picpay.request-queue.scheduler-enabled}")
    private boolean isSchedulerEnabled;

    @Value("${picpay.request-queue.requests-amount}")
    private Integer requestAmount;

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Scheduled(cron = "${picpay.request-queue.period}", zone = TIME_ZONE)
    public void requestMultipleAnalysis() {


        if (!isSchedulerEnabled) {
            log.warn("[request-queue-scheduler] - disabled");
            return;
        }
    }

}
