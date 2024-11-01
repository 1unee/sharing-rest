package com.oneune.sharing.rest.config;

import com.oneune.sharing.rest.aop.annotation.ConfigurationBeansInfo;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationBeansInfo
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class SerializationConfig implements Config {

    @NonFinal ModelMapper modelMapper;

    /**
     * Initializes default model mapper instance.
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
        return modelMapper;
    }

    private ModelMapper copyModelMapper() {
        return modelMapper.map(modelMapper, ModelMapper.class);
    }
}
