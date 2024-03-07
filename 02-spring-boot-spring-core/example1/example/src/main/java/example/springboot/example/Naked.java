package example.springboot.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("naked")
//@Qualifier("naked")
public class Naked implements Outfit{

    @Override
    public void wear() {
        System.out.println("Đang không mặc gì");
    }
}
