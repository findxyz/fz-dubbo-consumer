package xyz.fz.dubbo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.fz.dubbo.service.DemoService;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        for (int i = 0; i < 999; i++) {
            String hello = demoService.sayHello("world");
            System.out.println(hello);
            Thread.sleep(1000L);
        }
    }
}
