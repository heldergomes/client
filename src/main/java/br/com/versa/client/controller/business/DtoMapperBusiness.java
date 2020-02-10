package br.com.versa.client.controller.business;

import br.com.versa.client.config.MapperConfig;
import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.Location;
import org.springframework.stereotype.Service;

@Service
public class DtoMapperBusiness {


    public Business toBusiness(BusinessDTO model){
        Business business =  MapperConfig.generate().map(model, Business.class);
        business.setLocation(toLocation(model));
        return business;
    }

    private Location toLocation(BusinessDTO model){
        return MapperConfig.generate().map(model, Location.class);
    }
}
