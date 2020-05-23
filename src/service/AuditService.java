package service;
import java.sql.Timestamp;
public class AuditService {

    private final String auditPath = "AuditService";
    private AuditService(){

    }
    public void writeAction(String action){
        FileService fileService = FileService.getInstance();
        action = action + "," + (new Timestamp(System.currentTimeMillis())) + "," + Thread.currentThread().getName();
        fileService.writeFile(auditPath,action);
    }
    public static AuditService getInstance() {
        return AuditService.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static AuditService INSTANCE = new AuditService();
    }
}
