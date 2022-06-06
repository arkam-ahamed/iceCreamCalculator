package tetranyde.iceCreamCalculator;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IceCreamCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IceCreamCalculatorApplication.class, args);
    }

    @Bean
    DozerBeanMapper dozerBeanMapper() {
        List<String> mappingFiles = new ArrayList();
        mappingFiles.add("dozerJdk8Converters.xml");
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingFiles);
        return dozerBeanMapper;
    }

}
