package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {
    private final long createdTime;

    public PrototypeBean() {
        this.createdTime = System.currentTimeMillis();
        System.out.println("Creating Prototype Bean!!!!....");
    }

    public long getCreatedTime() {
        return createdTime;
    }
}
