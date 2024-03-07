package example.springboot.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bikini")
//@Qualifier("bikini")
//@Scope("prototype")
public class Bikini implements Outfit{
    @Override
    public void wear() {
        System.out.println("Mặc bikini");
    }
}
