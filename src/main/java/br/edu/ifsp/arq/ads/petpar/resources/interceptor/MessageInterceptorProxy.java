package br.edu.ifsp.arq.ads.petpar.resources.interceptor;

/*@Aspect
@Component*/
public class MessageInterceptorProxy {
    /*@Autowired
    private RequestedCreditAnalysisService requestedCreditAnalysisService;


    @Around("@annotation(com.picpay.limitanalysis.domain.requestedcreditanalysis.interceptor.UpdateRequestedCreditAnalysis)")
    public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
        Object methodCallResult = null;

        try {
            methodCallResult = joinPoint.proceed();
            this.success(joinPoint);
            return methodCallResult;
        } catch (Exception var4) {
            this.failure(joinPoint, var4);
            throw var4;
        }
    }

    private void failure(ProceedingJoinPoint joinPoint, Exception e) {
        this.handleOriginalError(joinPoint, e);
    }

    private void handleOriginalError(ProceedingJoinPoint joinPoint, Exception e) {
        Arrays.asList(joinPoint.getArgs()).forEach((object) -> {
            if (object instanceof ProspectRequest) {
                ProspectRequest prospectRequest = (ProspectRequest)object;
                this.requestedCreditAnalysisService.updateWhenAnalysisDone(prospectRequest.getDocumentNumber(), CreditAnalysisStatus.FAILURE, "[checkCreditAnalysis] Original error - " + e.getMessage());
            }

        });
    }

    private void success(final ProceedingJoinPoint joinPoint) {
        this.handleEventProducer(joinPoint);
    }

    private void handleEventProducer(final ProceedingJoinPoint joinPoint) {
        Arrays.asList(joinPoint.getArgs()).forEach((object) -> {
            LimitChangedEventSourceAbstract payload = this.getLimitChangedEventFromJoingPoint(object);
            if (payload != null) {
                this.requestedCreditAnalysisService.updateWhenAnalysisDone(payload.getCpf(), CreditAnalysisStatus.SUCCESS, (String)null);
            }

        });
    }

    private LimitChangedEventSourceAbstract getLimitChangedEventFromJoingPoint(Object object) {
        if (object instanceof KafkaMessage) {
            EventSource kafkaMessage = ((KafkaMessage)object).getSourceEvent();
            if (kafkaMessage instanceof LimitChangedEventSourceAbstract) {
                LimitChangedEventSourceAbstract payload = (LimitChangedEventSourceAbstract)kafkaMessage;
                return payload;
            }
        }

        return null;
    }*/
}
