package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    private final long createdTime;

    public SingletonBean() {
        this.createdTime = System.currentTimeMillis();
        System.out.println("Creating Singleton Bean!!!!....");
    }

    public long getCreatedTime() {
        return createdTime;
    }
}
